package e0119_Test_for_StreamAPI_14_exercises;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.HashMap;
import java.util.Map;


public class App19_Test_for_StreamAPI_14_exercises {
    int MAX_TASK_SUMMA = 100; // 1000, и 10000
    List<Department> department = new ArrayList();

    public App19_Test_for_StreamAPI_14_exercises() {
        Initialize init = new Initialize();
        init.run();
        exercisesRun(init);
    }

    private void exercisesRun(Initialize init) {
//      ===== ЗАДАЧА №0 - ГОТОВОЕ РЕШЕНИЕ ДЛЯ ПРИМЕРА: ==========================================================
//        ex_0_CitiesWithComponies(init.companyList);
//        ex_0_CItiesWithCompanies2(init.companyList);


//      === ЗАДАЧА №1 - Города, в которых живут сотрудники каждого отдела (мое решение) ===========================
//        ex_1_CitiesDepartmentsEmployees(init.departmentList);

//        --- другие варианты, от Андрея: -----------------
//        ex_1_CitiesDepartmentsEmployees_2(init.departmentList);
//        ex_1_CitiesDepartmentsEmployees_3(init.departmentList);
//        ex_1_CitiesDepartmentsEmployees_4_with_param3_if_D1_D3_renamed_concat(init.departmentList);


//      === ЗАДАЧА №2 - Компании, продукты которых есть на складах каждого отдела (мое решение) =====================
//        ex_2_Companies_on_Departments_storages(init.companyList, init.departmentList);

//      === ЗАДАЧА №3 - какие компании расположены в тех же городах, что и работники каждого отдела (мое решение) =====
//        ex_3_Companies_and_Emploees_in_same_Cities_of_each_Departmens(init.companyList, init.employeeList, init.departmentList);

//      === ЗАДАЧА №4 - Сумму всех товаров по каждому отделу (мое решение) =================================
//        ex_4_TotalProducts_in_each_Departments(init);

//      === ЗАДАЧА №5 - Суммы всех товаров в отделе по каждой компании (мое решение) =======================
        System.out.println("\n>.. Задача 5. Суммы всех товаров в отделе по каждой компании");

        /**          { отдел = [
         *                         { компания = кол-во товаров },
         *                          { компания = кол-во товаров },
         *                           ...
         *                      ],
         *              ...
         *             }
         */

        // 1) мапа: Компании - ID товаров (простоя прямая мапа)
        System.out.println("\n# mapCompanyToID : Компании и списки id-шников продуктов, которые они производят:");
        Map<String, List<String>> mapCompanyToID = init.companyList.stream()
                .collect(Collectors.toMap(
                        k -> k.name,
                        v -> v.productIdList.stream()
                                .collect(Collectors.toList())
                ));
        mapCompanyToID.entrySet().stream().forEach(System.out::println);

        // 2) мапа: Отделы - ID товаров (простая прямая мапа)
        System.out.println("\n# mapDepsToID : Отделы и id-шники продуктов на их складах:");
        Map<String, List<String>> mapDepsToID = init.departmentList.stream()
                .collect(Collectors.toMap(
                        k -> k.name,
                        v -> v.productRegestry.keySet().stream()
                                .map(pr -> pr.id)
                                .collect(Collectors.toList())
                ));
        mapDepsToID.forEach((k, v) -> System.out.println(k + " : " + v));


        // 3) Мапа: Отделы = Компании в них (return из 2-й задачи)
        System.out.println("\n# mapDepsToCompany : Отделы = список компаний:");
        Map<String, Set<String>> mapDepsToCompany = ex_2_Companies_on_Departments_storages(init.companyList, init.departmentList);
        mapDepsToCompany.entrySet().stream().forEach(System.out::println);
























        // 4) Мапа: ID товара = его количество
        System.out.println("\n>.. Отдел = { ID товара = его количество }:");
        Map<String, ArrayList> mapDepsToIDsToQntity = init.departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> {
                            ArrayList list = new ArrayList();
                            Map<String, Integer> mapa = dep.productRegestry.entrySet().stream()
                                    .collect(Collectors.toMap(
                                            product -> product.getKey().id,
                                            product -> product.getValue()
                                    ));
                            list.add(mapa);
                            return list;
                        }
                ));
        mapDepsToIDsToQntity.entrySet().stream().forEach(System.out::println);



        System.out.println("\n>.. 1) :");
        Map<String, Map<String, Integer>> mapDepsToIDsToQntity1 = init.departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> dep.productRegestry.keySet().stream()
                                .collect(Collectors.toList()).stream()
                                .collect(Collectors.toMap(
                                        key -> key.id,
                                        key -> dep.productRegestry.entrySet().stream()
                                                .filter(e -> Objects.equals(e.getKey().id, key.id))
                                                .map(e -> e.getValue())
                                                .collect(Collectors.toList())
                                                .get(0)
                                ))
                ));
        mapDepsToIDsToQntity1.entrySet().stream().forEach(System.out::println);


























        // 4) Мапа: Отделы = что-то еще:
        System.out.println("\n# что-то еще:");
        Map<String, ArrayList> mapDepsToCompanyToIDs = init.departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> {
                            ArrayList list = new ArrayList();
                            list.add(
                                    mapDepsToCompany.get(dep.name).stream()
                                            .collect(Collectors.toMap(
                                                            comp -> comp,
                                                            comp -> mapCompanyToID.get(comp).stream()
                                                                    .filter(id -> mapDepsToID.get(dep.name).contains(id))
                                                                    .collect(Collectors.toList())
                                                    )
                                            )
                            );
                            return list;
                        }
                ));
        mapDepsToCompanyToIDs.entrySet().stream().forEach(System.out::println);












        System.out.println("\n>.. 2) :");
        mapDepsToIDsToQntity.values().stream()
//                .map(v -> v.stream().)
//                .map(x -> x.toString())
                .forEach(System.out::println);


        System.out.println("\n>.. 3) :");
        Object var = mapDepsToIDsToQntity.get("D4").get(0);
        System.out.println(var);


    }


    //==========================================================================================================

    private void ex_4_TotalProducts_in_each_Departments(Initialize init) {
        //        словарь интов.         { отдел = сумма_товаров, ... }
        System.out.println("\n>.. Задача 4. По каждому отделу - сумму всех товаров:");

        System.out.println("\n>.. Отделы = всего товаров в них:");
        Map<String, Integer> mapDepsToQuantity = init.departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> dep.productRegestry.entrySet().stream()
                                .map(e -> e.getValue())
                                .reduce((a, b) -> a + b)
                                .get()
                ));
        mapDepsToQuantity.entrySet().stream().forEach(System.out::println);

        System.out.println("\n>.. Отделы = список id товаров и список их количествов (просто для отработки и полезного примера):");
        Map<String, List<String>> mapDepsToIDsAndQtitys = init.departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> {
                            ArrayList list = new ArrayList();
                            list.add(dep.productRegestry.keySet().stream()
                                    .map(k -> k.id)
                                    .collect(Collectors.toList()));
                            list.add(dep.productRegestry.values().stream()
                                    .collect(Collectors.toList()));
                            return list;
                        }
                ));
        mapDepsToIDsAndQtitys.entrySet().stream().forEach(System.out::println);


        System.out.println("\n>.. Общее кол-во товаров во всех отделах всего (просто для отработки полезного примера):");
        Integer qntityTotal = init.departmentList.stream()
                .flatMap(dep -> dep.productRegestry.entrySet().stream()
                        .map(x -> x.getValue())
                )
                .collect(Collectors.toList())
                .stream()
                .reduce((x, y) -> x + y).get();
        System.out.println(qntityTotal);

//        return mapDepsToIDsAndQtitys;
    }

    private void ex_3_Companies_and_Emploees_in_same_Cities_of_each_Departmens(List<Company> companyList, List<Employee> employeeList, List<Department> departmentList) {
        /** 3. Определить по каждому отделу:
         *   какие компании расположены в тех же городах, что и работники отделов               ДЕЛАЮ...
         *
         *      { отдел = [
         *                   { город = [ [компания, ... ], [работник, ... ] ] },
         *                  { город = [ [компания, ... ], [работник, ... ] ] },
         *                  ...
         *               ]
         *
         */

        System.out.println("\n>.. Задача 3. По каждому отделу: какие компании расположены в тех же городах, что и работники отделов");

        // 1) мапа: Компании - Город (простая прямая мапа)
        System.out.println("\n# mapCompanyToCity : Компания = город:");

        // 1) Города и Компании
        Map<String, List<String>> mapCityToCompanies = companyList.stream()
                .collect(Collectors.toMap(
                        e -> e.address.city,
                        e -> e.name,
                        (e1, e2) -> e1.concat(" " + e2)
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        el -> el.getKey(),
                        el -> Arrays.stream(el.getValue().split(" ")).collect(Collectors.toList())
                ));
        mapCityToCompanies.entrySet().stream().forEach(System.out::println);
        System.out.println();

        // 2) Города и сотрудники
        Map<String, List<String>> mapCityToEmploees = employeeList.stream()
                .collect(Collectors.toMap(
                        emp -> emp.address.city,
                        emp -> emp.id,
                        (e1, e2) -> e1.concat(" " + e2)
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        el -> el.getKey(),
                        el -> Arrays.stream(el.getValue().split(" ")).collect(Collectors.toList())
                ));
        mapCityToEmploees.entrySet().stream().forEach(System.out::println);
        System.out.println();


        // 3) Отделы, города и компании в них
        Map<String, Map<String, List<String>>> mapDepsToCityesAndCompanies = departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> dep.employeeses.stream()
                                .map(emp -> emp.address.city)
                                .collect(Collectors.toMap(
                                        city -> city,
                                        city -> mapCityToCompanies.get(city),
                                        (e1, e2) -> Stream.concat(e1.stream(), e2.stream()).toList()
                                ))

                ));

        mapDepsToCityesAndCompanies.entrySet().stream().forEach(System.out::println);


        // 4) Отделы и их сотрудники
        System.out.println("\n>.. Отделы и их сотрудники:");
        Map<String, List<String>> mapDepsToEmploeeses = departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> dep.employeeses.stream()
                                .map(emp -> emp.id)
                                .collect(Collectors.toList())
                ));
        mapDepsToEmploeeses.entrySet().stream().forEach(System.out::println);

        System.out.println("\n>.. Отделы = города = компании и сотрудники:");
        departmentList.stream()
                .collect(Collectors.toMap(
                                dep -> dep.name,
                                dep -> dep.employeeses.stream()
                                        .map(emp -> emp.address.city)
                                        .collect(Collectors.toSet())
                                        .stream().collect(Collectors.toMap(
                                                city -> city,
                                                city -> {
                                                    ArrayList listCompanyEmploee = new ArrayList();
                                                    List listEmploeesInCityOfDep = mapDepsToEmploeeses.get(dep.name);
                                                    List listEmploeesInCity = mapCityToEmploees.get(city);
                                                    Object listIntersection = listEmploeesInCity.stream()
                                                            .filter(x -> listEmploeesInCityOfDep.contains(x))
                                                            .collect(Collectors.toList());
                                                    listCompanyEmploee.add(mapCityToCompanies.get(city));
                                                    listCompanyEmploee.add(listIntersection);

                                                    return listCompanyEmploee;
                                                }
                                        )).entrySet().stream().toList()
                        )
                )

                .entrySet().stream().forEach(System.out::println);
    }

    private Map<String, Set<String>> ex_2_Companies_on_Departments_storages(List<Company> companyList, List<Department> departmentList) {
        /**
         2. Компании продукты которых есть на складах каждого отдела.             <---
         словарь:
         {отдел = [компании, ...] }
         */
//        System.out.println("\n>.. Задача 2. Компании, продукты которых есть на складах каждого отдела");


//        System.out.println("\n# mapCompanyToID : Компании и списки id-шников продуктов, которые они производят:");
        // 1) мапа: Компании - ID (простоя прямая мапа)
        Map<String, List<String>> mapCompanyToID = companyList.stream()
                .collect(Collectors.toMap(
                        k -> k.name,
                        v -> v.productIdList.stream()
                                .collect(Collectors.toList())
                ));
//        mapCompanyToID.entrySet().stream().forEach(System.out::println);

        // 2) мапа: - Отделы - ID (простая прямая мапа)
//        System.out.println("\n# mapDepsToID : Отделы и id-шники продуктов на их складах:");
        Map<String, List<String>> mapDepsToID = departmentList.stream()
                .collect(Collectors.toMap(
                        k -> k.name,
                        v -> v.productRegestry.keySet().stream()
                                .map(pr -> pr.id)
                                .collect(Collectors.toList())
                ));
//        mapDepsToID.forEach((k,v) -> System.out.println(k + " : " + v));


        // 3) - создание списка (через создание сета) с уникальным набором значений всех элементов из списков значений оригинального словаря
        List<String> listValuesIDs = mapCompanyToID.values().stream()
                .map(v -> v.stream().toList())
                .flatMap(List::stream)
                .collect(Collectors.toSet()).stream()
                .toList()
                .stream().sorted().toList();


//        System.out.println("\n# Инверсный словарь mapCompanyToID - mapIdsToCompany:");

        HashMap<String, List<String>> mapIdToCompanyHash = new HashMap<>();

        // 4) создаем новый инверсный словарь через for и put:
//        System.out.println("\n>.. Способ 1: через for, put");
        for (int j = 0; j < listValuesIDs.size(); j++) {
            String keyInverse = listValuesIDs.get(j);
            List<String> valueInverse = mapCompanyToID.keySet().stream()
                    .filter(key -> mapCompanyToID.get(key).contains(keyInverse))
                    .collect(Collectors.toList());
            mapIdToCompanyHash.put(keyInverse, valueInverse);
        }
//        mapIdToCompanyHash.entrySet().stream().forEach(System.out::println);

        // 5) создаем такой же словарь, только через чисто toMap -> HashMap:
//        System.out.println("\n>.. Способ 2: через чисто toMap -> HashMap");
        mapIdToCompanyHash = listValuesIDs.stream()
                .collect(Collectors.toMap(
                        k -> k,
                        v -> {
                            List<String> valueInverse = mapCompanyToID.keySet().stream()
                                    .filter(key -> mapCompanyToID.get(key).contains(v))
                                    .collect(Collectors.toList());
                            return valueInverse;
                        },
                        (v1, v2) -> v1,
                        HashMap::new
                ));
//        mapIdToCompanyHash.entrySet().stream().forEach(System.out::println);

        // 6) 3-й способ. создаем такой же словарь, только через чисто toMap. Оставляем этот, поскольку
        // с HashMap потом не будет работать подстановка ID-to-CompanyList:
//        System.out.println("\n>.. Способ 3: через чисто toMap");
        Map<String, List<String>> mapIdToCompany = listValuesIDs.stream()
                .collect(Collectors.toMap(
                        k -> k,
                        v -> {
                            List<String> valueInverse = mapCompanyToID.keySet().stream()
                                    .filter(key -> mapCompanyToID.get(key).contains(v))
                                    .collect(Collectors.toList());
                            return valueInverse;
                        }
                ));
//        mapIdToCompany.entrySet().stream().forEach(System.out::println);


        // 6) мапа: отделы - компании в них
//        System.out.println("\n>.. Мапа Отделы - Компании: mapDepsToCompany :");
        Map<String, Set<String>> mapDepsToCompany = mapDepsToID.entrySet().stream()
                .collect(Collectors.toMap(
                        k -> k.getKey(),
                        v_listID -> {
                            return v_listID.getValue().stream()
                                    .map(id -> mapIdToCompany.get(id))
                                    .flatMap(x -> x.stream())
                                    .collect(Collectors.toSet());
                        }
                ));
//        mapDepsToCompany.entrySet().stream().forEach(System.out::println);
        return mapDepsToCompany;
    }

    private void ex_1_CitiesDepartmentsEmployees_4_with_param3_if_D1_D3_renamed_concat(List<Department> departmentList) {
        System.out.println();
        BinaryOperator<? super Stream<Employee>> param3 = (k, v) -> {
            System.out.println("param3");
            return Stream.concat(k, v);
        };

        departmentList.stream()
                .collect(Collectors.toMap(
                                k -> k.name,
                                v -> v.employeeses.stream(),
                                param3
                        )
                )
                .forEach((k, v) -> System.out.println(k + " :: " + ((Stream<Employee>) v)
                        .map(se -> se.firstName + " - " + se.address.city)
                        .collect(Collectors.toList())))
        ;
    }

    private void ex_1_CitiesDepartmentsEmployees_3(List<Department> departmentList) {
        System.out.println("\n>.. Задача 1. Города, в которых живут сотрудники каждого отдела. Вариант от Андрея 3");
        BinaryOperator<? super Stream<Employee>> param3 = (k, v) -> {
            System.out.println("param3");
            return Stream.concat(k, v);
        };

        departmentList.stream()
                .collect(Collectors.toMap(
                        k -> {
                            System.out.println("k.name = " + k.name);
                            return k.name;
                        },
                        v -> {
                            System.out.println("v.employeeses.stream() (id) = " + v.head.id);
                            return v.employeeses.stream();
                        },
                        param3))
                .forEach((k, v) -> System.out.println(k + " :: " + ((Stream<Employee>) v)
                        .map(se -> se.firstName + " - " + se.address.city)
                        .collect(Collectors.toList())))
        ;
    }

    private void ex_1_CitiesDepartmentsEmployees_2(List<Department> departmentList) {
        System.out.println("\n>.. Задача 1. Города, в которых живут сотрудники каждого отдела. Вариант от Андрея 2. toMap:");
        departmentList.stream()
                .collect(Collectors.toMap(
                        k -> {
                            System.out.println("k.name = " + k.name);
                            return k.name;
                        },
                        v -> {
                            System.out.println("v.employeeses.stream() (id) = " + v.head.id);
                            return v.employeeses.stream()
                                    .collect(Collectors.toMap(
                                            e -> {
                                                System.out.println("v.employeeses.stream() -> e.firstName = " + e.firstName);
                                                return e.firstName;
                                            },
                                            e -> {
                                                System.out.println("v.employeeses.stream() -> e.address.city = " + e.address.city);
                                                return e.address.city;
                                            }
                                    ));
                        }))
                .forEach((k, v) -> System.out.println(k + " :: " + v));
    }

    private void ex_1_CitiesDepartmentsEmployees(List<Department> departmentList) {
        System.out.println("\n>.. Задача 1. Города, в которых живут сотрудники каждого отдела:");

        departmentList.stream()
                .collect(Collectors.toMap(
                        k -> k.name,
                        v -> v.employeeses.stream()
                                .collect(Collectors.toConcurrentMap( //toMap тоже работает !!!
                                        e -> e.firstName,
                                        e -> e.address.city
                                ))))
                .forEach((k, v) -> System.out.println(k + " :: " + v));
    }

    private void ex_0_CItiesWithCompanies2(List<Company> companyList) {
        System.out.println(">.. Задача 0. Города, в которых расположены фирмы. Второй вариант.");

        HashMap<String, Optional<String>> companyCities2 = companyList.stream()
                .collect(Collectors.groupingBy(
                        company -> company.address.city,
                        HashMap::new,
                        Collectors.mapping(c -> c.name,
                                Collectors.reducing((c1, c2) -> c1 + ", " + c2))
                ));

        companyCities2.forEach(
                (city, cmpList) -> {
                    System.out.println(city + " - " + cmpList.get());
                }
        );

        System.out.println("========================================================");
    }

    private void ex_0_CitiesWithComponies(List<Company> companyList) {
        System.out.println(">.. Задача 0. Города, в которых расположены фирмы.");

        Map<String, List<Company>> companyCities = companyList.stream()
                .collect(Collectors.groupingBy(
                        company -> company.address.city,
                        HashMap::new,
                        Collectors.toList()
                ));

        companyCities.forEach(
                (city, cmpList) -> {
                    System.out.println(city + " - " + cmpList.stream()
                            .map(c -> c.name)
                            .reduce((s, t) -> s + ", " + t)
                            .get()
                    );
                }
        );

        System.out.println("========================================================");
    }

}
