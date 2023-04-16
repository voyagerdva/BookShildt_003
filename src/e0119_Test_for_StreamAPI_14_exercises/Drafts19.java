package e0119_Test_for_StreamAPI_14_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Drafts19 {
//
//    // 4) список (через создание сета) с уникальным набором значений всех элементов из списков значений оригинального словаря
//    List<String> listValuesIDs = mapCompanyToID.values().stream()
//            .map(v -> v.stream().toList())
//            .flatMap(List::stream)
//            .collect(Collectors.toSet()).stream()
//            .toList()
//            .stream().sorted().toList();
//
//    // 5) 3-й способ. создаем такой же словарь, только через чисто toMap. Оставляем этот, поскольку
//    // с HashMap потом не будет работать подстановка ID-to-CompanyList:
//        System.out.println("\n>.. Способ 3: через чисто toMap");
//    Map<String, List<String>> mapIdToCompany = listValuesIDs.stream()
//            .collect(Collectors.toMap(
//                    k -> k,
//                    v -> {
//                        List<String> valueInverse = mapCompanyToID.keySet().stream()
//                                .filter(key -> mapCompanyToID.get(key).contains(v))
//                                .collect(Collectors.toList());
//                        return valueInverse;
//                    }
//            ));
//        mapIdToCompany.entrySet().stream().forEach(System.out::println);
//
//    // 6) Мапа:
//        System.out.println("\n>.. :");
//
//    // 7) Мапа:
//        System.out.println("\n>.. :");
//
//
//        init.departmentList.stream()
//                .collect(Collectors.toMap(
//            dep -> dep.name,
//    dep -> {
//        ArrayList list = new ArrayList();
//
//        list.add(
//                mapCompanyToID.entrySet().stream()
//                        .collect(Collectors.toMap(
//                                i -> i.getKey(),
//                                i -> i.getValue()
//                        )));
//
//        return list;
//    }
//
//
//
//
//
//
//
//
//                                                    productRegestry.entrySet().stream()
//                                                    .map(e -> e.getValue())
//                                                    .reduce((a, b) -> a + b).get()
//                ))
//                        .entrySet().stream().forEach(System.out::println);


//                        dep -> dep.name,
//                        dep -> {
//                            ArrayList list = new ArrayList();
//                            return dep.productRegestry.keySet().stream()
//                                    .flatMap(
//                                            k -> mapIdToCompany.get(k.id).stream()
//                                                    .collect(Collectors.toMap(
//                                                            comp -> comp,
//                                                            comp -> mapCompanyToID.get(comp)
//                                                    )))
//
//                        }
//                        );

//                                    .collect(
////                                            ,
////                                            k -> dep.productRegestry.entrySet().stream()
////                                                    .map(e -> e.getValue())
////                                                    .reduce((a,b) -> a+b)
////                                                    .get(),
//////                                            (a,b) -> b.stream().
//////                                                    map (x -> a.add(x))
////                                            (a,b) -> a
//                                    ));
//
//                            list.add(dep.productRegestry.keySet().stream()
//                                    .collect(Collectors.toMap(
//                                            k -> mapIdToCompany.get(k.id),
//                                            k -> k.id,
//                                            (a,b) -> a
//                                    )))
//
//                                    ;
//
//
////                            list.add(dep.productRegestry.values().stream()
////                                    .collect(Collectors.toList()));
//
//
//
//                            return list;
//                        }
//                ));
//        mapDepToIDsAndQtitys.entrySet().forEach(System.out::println);

}
