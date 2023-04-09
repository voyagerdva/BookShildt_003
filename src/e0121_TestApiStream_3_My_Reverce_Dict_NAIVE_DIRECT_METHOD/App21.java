package e0121_TestApiStream_3_My_Reverce_Dict_NAIVE_DIRECT_METHOD;

import java.util.*;
import java.util.stream.Collectors;

public class App21 {
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


//        === СОЗДАНИЕ ОБРАТНОГО СЛОВАРЯ: ============================================================================
        System.out.println("\n---<<<<< =======  : dictReverse (values to keys) : ======= ");
        Map<List<String>, String> dictReverse = dictOriginal.entrySet().stream()
                .collect(Collectors.toMap(
                        k -> Arrays.stream(k.getValue())
                                .toList()
                        , v -> v.getKey()
                ));
        dictReverse.forEach((k0, v0) -> System.out.println(k0 + " => " + v0));


        //=== СОЗДАНИЕ ИНВЕРСНОГО СЛОВАРЯ: ============================================================================
        System.out.println("\n------ : dictInverse (items of keyLists are keys, values unique to lists) : -------------");
        HashMap<String, ArrayList<String>> dict4 = new HashMap<>();

        ArrayList<String> valOld;

        for (List<String> item : dictReverse.keySet()) {
            for (String mem : item) {
                if (!dict4.containsKey(mem)) {
                    dict4.put(mem, new ArrayList<>(Collections.singleton(dictReverse.get(item))));
                    continue;
                }

                valOld = dict4.get(mem);
                valOld.add(dictReverse.get(item));
                valOld = (ArrayList<String>) dict4.get(mem)
                        .stream()
                        .distinct()
                        .collect(Collectors.toList());

                dict4.put(mem, valOld);
            }
        }

        dict4.entrySet().stream()
                .forEach(System.out::println);
    }
}
