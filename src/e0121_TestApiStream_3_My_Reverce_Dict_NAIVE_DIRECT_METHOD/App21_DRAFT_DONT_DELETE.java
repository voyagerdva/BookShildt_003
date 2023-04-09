package e0121_TestApiStream_3_My_Reverce_Dict_NAIVE_DIRECT_METHOD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class App21_DRAFT_DONT_DELETE {
    public void run() {
        //=== СОЗДАНИЕ ИСХОДНОГО СЛОВАРЯ: ============================================================================
        System.out.println("\n------ : dicOriginal : -------------");
        String[] listValues1 = {"ONE", "TWO", "THREE", "TWO", "FOUR", "FIVE", "THREE", "THREE", "THREE"};
        String[] listValues2 = {"TWO", "FOUR"};
        String[] listValues3 = {"ONE", "TWO", "ONE", "FOUR", "FIVE"};
        String[] listValues4 = {"ONE", "FOUR", "FOUR", "FIVE"};
        String[] listValues5 = {"THREE"};


        HashMap<String, String[]> dictOriginal = new HashMap<>();
        dictOriginal.put("1", listValues1);
        dictOriginal.put("2", listValues2);
        dictOriginal.put("3", listValues3);
        dictOriginal.put("4", listValues4);
        dictOriginal.put("5", listValues5);

        for (String key : dictOriginal.keySet()) {
            List<String> valuesList = Arrays.stream(dictOriginal.get(key)).toList();
            System.out.println(key + " : " + valuesList);
        }

        System.out.println(dictOriginal);


        //=== СОЗДАНИЕ ОБРАТНОГО СЛОВАРЯ через GRUPPINGBY : ============================================================================

        /**
                                      1 : [ONE, TWO, THREE, TWO, FOUR, FIVE, THREE, THREE, THREE]
                                      2 : [TWO, FOUR]
                                      3 : [ONE, TWO, ONE, FOUR, FIVE]
                                      4 : [ONE, FOUR, FOUR, FIVE]
                                      5 : [THREE]

                                     ---<<<<< =======  : dictReverse (values to keys) : =======
                                     [ONE, TWO, ONE, FOUR, FIVE] => 3
                                     [ONE, FOUR, FOUR, FIVE] => 4
                                     [TWO, FOUR] => 2
                                     [ONE, TWO, THREE, TWO, FOUR, FIVE, THREE, THREE, THREE] => 1
                                     [THREE] => 5

                                     ------ : dictInverse (items of keyLists are keys, values unique to lists) : -------------
                                     FIVE=[3, 4, 1]
                                     ONE=[3, 4, 1]
                                     FOUR=[3, 4, 2, 1]
                                     TWO=[3, 2, 1]
                                     THREE=[1, 5]

         */

        System.out.println("\n--->>>>>>> : dictReverse0: СОЗДАНИЕ ОБРАТНОГО СЛОВАРЯ через GRUPPINGBY  : =======");

        for (String key : dictOriginal.keySet()) {
            List<String> valuesList = Arrays.stream(dictOriginal.get(key)).toList();
            System.out.println(key + " : " + valuesList);
        }

        dictOriginal.values().stream()
                .map(v -> Arrays.stream(v).toList())
//                .forEach(System.out::println);
        ;

        //-------------------------------------------------

//      ЭТО ПРОСТО ПРОБЫ ВСЯКИХ КОНСТРУКЦИЙ:
//        if (Arrays.stream(dictOriginal.get(key)).toList().contains(item)) {
//            key.concat(" " + key);
//        }

        System.out.println(dictOriginal.get("1"));
//        k -> Arrays.stream(k.getValue()).toList()

        //----------------------------------------------

        System.out.println("\n1--- listKeyOriginal -----------------");
        List<String> listKeyOriginal = dictOriginal.keySet().stream().collect(Collectors.toList());
        System.out.println("listKeyOriginal: " + listKeyOriginal);

        List<String[]> listValuesOriginal = dictOriginal.values().stream().toList();

        System.out.println("\n2--- listKeysInverse -----------------");
        List<String> listKeysInverse = dictOriginal.values().stream()
                .map(v -> Arrays.stream(v).toList())
                .flatMap(List::stream)
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.toList());

        System.out.println("listKeysInverse: " + listKeysInverse);


        //----------------------------------------------

        System.out.println("\n4--- dictInverse -----------------");
        HashMap<String, List<String>> dictInverse = new HashMap<>();

        for (int j = 0; j < listKeysInverse.size(); j++) {
            String keyInverse = listKeysInverse.get(j);
            System.out.println(">... " + j + " : " + keyInverse);

            List<String> valueInverse = dictOriginal.keySet().stream()
                    .filter(key -> Arrays.stream(dictOriginal.get(key)).toList().contains(keyInverse))
                    .collect(Collectors.toList());

            dictInverse.put(keyInverse, valueInverse);
        }



        System.out.println("dictInverse: " + dictInverse);


        dictOriginal.entrySet().stream()
                .collect(Collectors.toMap(
                         k -> Arrays.stream(k.getValue()).collect(Collectors.toList())
                        ,v -> v.getKey()
                ))
//                .entrySet()
//                .forEach(System.out::println);


        ;







//      САМАЯ КРУТАЯ ПОПЫТКА ПОЛУЧИТЬ КЛЮЧИ И ЗНАЧЕНИЯ ИЗ СЛОВАРЯ. НО СНОВА НЕ УДАЛОСЬ:
//        System.out.println(
//        dictOriginal.values().stream()
//                .map(v -> Arrays.stream(v).toList())
//                .flatMap(List::stream)
//                .collect(Collectors.toSet())
//                .stream()
//                .collect(Collectors.toMap(
//                        item -> item,
//                        item -> {
//                            dictOriginal.keySet().stream()
//                                    .flatMap(key -> {
//                                        if (Arrays.stream(dictOriginal.get(key)).toList().contains(item)) {
//                                            key = key + " ";
//                                        }
////                                        return key;
//                                    }),
//
//                        (v1,v2) -> v1.concat(" " + v2)
//
//                ))
//
////                .forEach(System.out::println);
//        );











////        === СОЗДАНИЕ ОБРАТНОГО СЛОВАРЯ: ============================================================================
//        System.out.println("\n---<<<<< =======  : dictReverse (values to keys) : ======= ");
//        Map<List<String>, String> dictReverse = dictOriginal.entrySet().stream()
//                .collect(Collectors.toMap(
//                        k -> Arrays.stream(k.getValue())
//                                .toList()
//                        , v -> v.getKey()
//                ));
//        dictReverse.forEach((k0, v0) -> System.out.println(k0 + " => " + v0));
//
//
//        //=== СОЗДАНИЕ ОБРАТНОГО СЛОВАРЯ: ============================================================================
//        System.out.println("\n------ : dictInverse (items of keyLists are keys, values unique to lists) : -------------");
//        HashMap<String, ArrayList<String>> dict4 = new HashMap<>();
//
//        ArrayList<String> valOld;
//
//        for (List<String> item : dictReverse.keySet()) {
//            for (String mem : item) {
//                if (!dict4.containsKey(mem)) {
//                    dict4.put(mem, new ArrayList<>(Collections.singleton(dictReverse.get(item))));
//                    continue;
//                }
//
//                valOld = dict4.get(mem);
//                valOld.add(dictReverse.get(item));
//                valOld = (ArrayList<String>) dict4.get(mem)
//                        .stream()
//                        .distinct()
//                        .collect(Collectors.toList());
//
//                dict4.put(mem, valOld);
//            }
//        }
//
//        dict4.entrySet().stream()
//                .forEach(System.out::println);

















//====== ВСЯКИЕ ЧЕРНОВИКИ: =======================================================================================
//
//                .forEach(System.out::println);
//                .forEach((k0,v0) -> System.out.println(k0 + " => " + v0));


//        Вот так можно поменять значение по ключу в словаре:
//        Map<String, String> result = resultFileTime
//                .entrySet()
//                .stream()
//                .collect(
//                        Collectors
//                                .toMap(
//                                        s->s.getKey().substring(0,3),
//                                        s->s.getValue()));

//
//        IBM : [0005, 0006, 0007, 0008, 0009]
//        WWW : [0009]
//        Pepsi : [0002, 0003, 0004, 0005, 0006, 0007]
//        Poridge : [0005, 0006]
//        AMD : [0006]
//        Coca : [0001, 0002, 0003]
//
//        D4 : [0003, 0009, 0002, 0008]
//        D1 : [0006, 0005, 0001]
//        D2 : [0003, 0004, 0005, 0002]
//        D3 : [0007, 0002]
    }
}
