package e0121_TestApiStream_3_My_Reverce_Dict_VIA_StreamAPI_Filter_toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class App22 {
    public void run() {
        //=== СОЗДАНИЕ ИСХОДНОГО СЛОВАРЯ: ============================================================================
        System.out.println("\n------ : dicOriginal : -------------");
        String[] listValues1 = {"ONE", "TWO", "TWO", "FOUR", "FIVE", "THREE", "THREE", "THREE"};
        String[] listValues2 = {"FOUR", "THREE"};
        String[] listValues3 = {"ONE", "TWO", "ONE", "FOUR"};
        String[] listValues4 = {"ONE", "FOUR", "FIVE"};
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

        //====  dictReverse0: СОЗДАНИЕ ИНВЕРСНОГО СЛОВАРЯ через FILTER   =======================================
        System.out.println("\n--->>>>>>> : dictReverse0: СОЗДАНИЕ ИНВЕРСНОГО СЛОВАРЯ через FILTER  : =======");

        // 1) создание списка (из сета) с уникальным набором значений всех элементов из списков значений оригинального словаря:
        List<String> listKeysInverse = dictOriginal.values().stream()
                .map(v -> Arrays.stream(v).toList())
                .flatMap(List::stream)
                .collect(Collectors.toSet()).stream()
                .toList();

        // 2) создаем новый инверсный словарь:
        HashMap<String, List<String>> dictInverse = new HashMap<>();

        for (int j = 0; j < listKeysInverse.size(); j++) {
            String keyInverse = listKeysInverse.get(j);
            List<String> valueInverse = dictOriginal.keySet().stream()
                    .filter(key -> Arrays.stream(dictOriginal.get(key)).toList().contains(keyInverse))
                    .collect(Collectors.toList());
            dictInverse.put(keyInverse, valueInverse);
        }

        dictInverse.entrySet().forEach(System.out::println);
    }
}
