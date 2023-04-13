package e0119_Test_for_StreamAPI_14_exercises;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.HashMap;
import java.util.Map;

/** === САМО ЗАДАНИЕ: ================================================================================
 *
 * ПРЯМО В ЭТОМ МЕТОДЕ НИЖЕ НАДО:
 * С помощью stream-API необходимо:
 *
 * a) понять какую структуру данных список, словарь, словарь словарей и т.д.
 * лучше всего использовать для представления результата по каждой задаче,
 *
 * b) и найти решение для следующих задач:
 *
 *
 *
 * 0. Города, в которых расположены фирмы                   (решено - 2 готовых примера)
 *      словарь списков
 *      { город :
 *          [ фирмы ] }
 *
 *
 *
 * 1. Города, в которых живут сотрудники каждого отдела.                    (решено)
 *      словарь словарей
 *      { Отдел : { сотрудник = город }
 *      print_1_CitiesDepartmentsEmployees(departmentList);
 *
 *
 * 2. Компании, продукты которых есть на складах каждого отдела.            (решено)
 *   словарь списков: {отдел = [компании, ...] }
 *
 *
 * 3. Определить по каждому отделу:
 *   какие компании расположены в тех же городах, что и работники отделов               ДЕЛАЮ...
 *
 *      { отдел = { город = [компания, работник] }
 *
 *
 *
 *
 *
 *
 * 4. Сумму всех товаров по каждому отделу
 * 5. Суммы всех товаров в отделе по каждой компании
 * 6. Определить в каждом отделе - есть ли родственники (одинаковые фамилии)
 * 7. Сформировать для каждого сотрудника каждого отдела список задач, исходя из того, какие товары есть в отделе
 * их количества в отделе. Если в отделе много товара, то надо создать несколько похожих задач, так, чтобы сумма
 * продукта который продается в одной задаче не превышала MAX_TASK_SUMMA.
 * сформировать и записать в поле employeeTaskMap - каждого отдела.
 * 8. На основе списков задач отделов выяснить сколько задач и на какую сумму, каждый сотрудник получил задач.
 * 9. На какую сумму каждый сотрудник продал каждой компании.
 * 10. Какой сотрудник продал больше всех товаров.
 * 11. С какой компанией работало больше всех отделов.
 * 12. С какой компанией работло больше всех сотрудников.
 * 13. Средняя сумма одной задачи для всех отделов.
 *
 * **/


public class App19_Test_for_StreamAPI_14_exercises {
    int MAX_TASK_SUMMA = 100; // 1000, и 10000
    List<Department> department = new ArrayList();

    public App19_Test_for_StreamAPI_14_exercises() {
        List<Address19> addressList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<Company> companyList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        List<Task> taskList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        Map<String, List<Task>> taskMap = new HashMap<>();
        Map<Product, Integer> productRegestry = new HashMap<>();

        //=====================================================================

        fillAddressList(addressList);
        fillProductList(productList);
        fillCompanyList(addressList, productList, companyList);
        fillEmployeeList(addressList, employeeList);

        createDepartmentList(productList, employeeList, departmentList);



//        ===== ЗАДАЧА №0 - ГОТОВОЕ РЕШЕНИЕ ДЛЯ ПРИМЕРА: ==========================================================
//        print_0_CitiesWithComponies(companyList);
//        print_0_CItiesWithCompanies2(companyList);


//        === ЗАДАЧА №1 - МОЕ РЕШЕНИЕ ====================================================================
        print_1_CitiesDepartmentsEmployees(departmentList);
//        System.out.println();

//        --- другие варианты, от Андрея: -----------------
//        print_1_CitiesDepartmentsEmployees_2(departmentList);
//        print_1_CitiesDepartmentsEmployees_3(departmentList);
//        print_1_CitiesDepartmentsEmployees_4_with_param3_if_D1_D3_renamed_concat(departmentList);


//        === ЗАДАЧА №2 - МОЕ РЕШЕНИЕ ====================================================================
        print_2_Companies_on_Departments_storages(companyList, departmentList);

//        === ЗАДАЧА №3 - МОЕ РЕШЕНИЕ ====================================================================
 /** 3. Определить по каждому отделу:
 *   какие компании расположены в тех же городах, что и работники отделов               ДЕЛАЮ...
 *
 *      { отдел = [
 *                   { город = [ [компания, ... ], [работник, ... ] ] },
  *                  { город = [ [компания, ... ], [работник, ... ] ] },
  *                  ...
  *               ]
*/

        System.out.println("\n>.. Задача 3. По каждому отделу: какие компании расположены в тех же городах, что и работники отделов");

        // 1) создание мапы Компании - Город (простая прямая мапа)
        System.out.println("\n# mapCompanyToCity : Компания = город:");

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

        Map<String, List<String>> mapCityToEmploee = employeeList.stream()
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

        departmentList.stream()
                .collect(Collectors.toMap(
                        dep -> dep.name,
                        dep -> dep.employeeses.stream()
                                .map(emp -> emp.address.city)
                                .collect(Collectors.toMap(
                                        city -> city,
                                        city -> mapCityToCompanies.get(city),
                                        (e1, e2) -> Stream.concat(e1.stream(), e2.stream()).toList()
                                ))

                ))
                .entrySet().stream().forEach(System.out::println);


/**      { отдел = [
*                   { город = [ [компания, ... ], [работник, ... ] ] },
*                  { город = [ [компания, ... ], [работник, ... ] ] },
*                  ...
*               ]
*/


//        mapCompanyToID.entrySet().stream().forEach(System.out::println);

        // 2) создание мапы - Отделы - ID (простая прямая мапа)
//        System.out.println("\n# mapDepsToID : Отделы и id-шники продуктов на их складах:");
//        Map<String, List<String>> mapDepsToID = departmentList.stream()
//                .collect(Collectors.toMap(
//                        k -> k.name,
//                        v -> v.productRegestry.keySet().stream()
//                                .map(pr -> pr.id)
//                                .collect(Collectors.toList())
//                ));
//        mapDepsToID.forEach((k,v) -> System.out.println(k + " : " + v));


        // 3) - создание списка (через создание сета) с уникальным набором значений всех элементов из списков значений оригинального словаря
//        List<String> listValuesIDs = mapCompanyToID.values().stream()
//                .map(v -> v.stream().toList())
//                .flatMap(List::stream)
//                .collect(Collectors.toSet()).stream()
//                .toList()
//                .stream().sorted().toList();












    }


    private void fillAddressList(List<Address19> addressList) {
        addressList.add(new Address19("NY", "Wall st.", 12));
        addressList.add(new Address19("NY", "Wall st.", 15));
        addressList.add(new Address19("NY", "Mall av.", 125));
        addressList.add(new Address19("Moscow", "Leninf pr.", 133));
        addressList.add(new Address19("Paris", "Mira pr.", 5));
        addressList.add(new Address19("Moscow", "Mira pr.", 313));
        addressList.add(new Address19("Nizh Novgorod", "Leninf pr.", 22));
        addressList.add(new Address19("Nizh Novgorod", "Radio st.", 5));
        addressList.add(new Address19("Rome", "Pavel sq.", 53));
        addressList.add(new Address19("NY", "Era", 54));
        addressList.add(new Address19("Moscow", "Green st.", 81));
        addressList.add(new Address19("Nizh Novgorod", "Moor st.", 36));
        addressList.add(new Address19("Paris", "Flower av.", 8));
        addressList.add(new Address19("Rome", "Pritool st.", 63));
        addressList.add(new Address19("Paris", "Bio st.", 56));
        addressList.add(new Address19("NY", "Mooring st.", 39));
        addressList.add(new Address19("NY", "Garden sq.", 521));
    }

    private void fillEmployeeList(List<Address19> addressList, List<Employee> employeeList) {
        employeeList.add(new Employee("001", "Tirion", "Lannister", addressList.get(0)));
        employeeList.add(new Employee("002", "Jaime", "Lannister", addressList.get(1)));
        employeeList.add(new Employee("003", "Serseya", "Lannister", addressList.get(2)));
        employeeList.add(new Employee("004", "Jon", "Snow", addressList.get(3)));
        employeeList.add(new Employee("005", "Robb", "Stark", addressList.get(4)));
        employeeList.add(new Employee("006", "Sansa", "Stark", addressList.get(8)));
        employeeList.add(new Employee("007", "Arya", "Stark", addressList.get(6)));
        employeeList.add(new Employee("008", "Robert", "Barateon", addressList.get(7)));
        employeeList.add(new Employee("009", "Stannis", "Barateon", addressList.get(3)));
        employeeList.add(new Employee("010", "Sandor", "Kligan", addressList.get(0)));
        employeeList.add(new Employee("011", "Viserion", "Targarien", addressList.get(9)));
        employeeList.add(new Employee("012", "Dejeneris", "Targarien", addressList.get(0)));
    }

    private void fillProductList(List<Product> productList) {
        productList.add(new Product("0001", "mirror", 23.30));
        productList.add(new Product("0002", "hammer", 13.05));
        productList.add(new Product("0003", "soap", 24.11));
        productList.add(new Product("0004", "armchear", 12.73));
        productList.add(new Product("0005", "table", 54.0));
        productList.add(new Product("0006", "water", 11.3));
        productList.add(new Product("0007", "chocolate", 70.0));
        productList.add(new Product("0008", "cackes", 29.37));
        productList.add(new Product("0009", "bread", 82.74));
        productList.add(new Product("0010", "salt", 31.21));
    }

    private void fillCompanyList(List<Address19> addressList, List<Product> productList, List<Company> companyList) {
        companyList.add(new Company(addressList.get(10), "Coca", productList.subList(0, 3).stream().map(p -> p.id).toList()));
        companyList.add(new Company(addressList.get(11), "Pepsi", productList.subList(1, 7).stream().map(p -> p.id).toList()));
        companyList.add(new Company(addressList.get(12), "Poridge", productList.subList(4, 6).stream().map(p -> p.id).toList()));
        companyList.add(new Company(addressList.get(13), "IBM", productList.subList(4, 9).stream().map(p -> p.id).toList()));
        companyList.add(new Company(addressList.get(15), "AMD", productList.subList(5, 6).stream().map(p -> p.id).toList()));
        companyList.add(new Company(addressList.get(15), "WWW", productList.subList(8, 9).stream().map(p -> p.id).toList()));
        companyList.add(new Company(addressList.get(15), "Arrow", productList.subList(5, 9).stream().map(p -> p.id).toList()));
    }

    private void createDepartmentList(List<Product> productList, List<Employee> employeeList, List<Department> departmentList) {
        Map<Product, Integer> productRegestry1 = new HashMap<>();
        productRegestry1.put(productList.get(0), 122);
        productRegestry1.put(productList.get(4), 66);
        productRegestry1.put(productList.get(5), 200);
        Department department1 = new Department("D1", employeeList.get(0), employeeList.subList(0, 3), productRegestry1);

        Map<Product, Integer> productRegestry2 = new HashMap<>();
        productRegestry2.put(productList.get(1), 43);
        productRegestry2.put(productList.get(2), 100);
        productRegestry2.put(productList.get(3), 13);
        productRegestry2.put(productList.get(4), 8);
        Department department2 = new Department("D2", employeeList.get(4), employeeList.subList(4, 6), productRegestry2);

        Map<Product, Integer> productRegestry3 = new HashMap<>();
        productRegestry3.put(productList.get(1), 43);
        productRegestry3.put(productList.get(6), 71);
        Department department3 = new Department("D3", employeeList.get(7), employeeList.subList(7, 10), productRegestry3);

        Map<Product, Integer> productRegestry4 = new HashMap<>();
        productRegestry4.put(productList.get(1), 55);
        productRegestry4.put(productList.get(2), 31);
        productRegestry4.put(productList.get(7), 90);
        productRegestry4.put(productList.get(8), 144);
        Department department4 = new Department("D4", employeeList.get(11), employeeList.subList(11, 12), productRegestry4);

        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);
        departmentList.add(department4);
    }



    //==================================================================================================

    private void print_0_CitiesWithComponies(List<Company> companyList) {
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
    private void print_0_CItiesWithCompanies2(List<Company> companyList) {
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

    private void print_1_CitiesDepartmentsEmployees(List<Department> departmentList) {
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

    private void print_1_CitiesDepartmentsEmployees_2(List<Department> departmentList) {
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

    private void print_1_CitiesDepartmentsEmployees_3(List<Department> departmentList) {
        System.out.println("\n>.. Задача 1. Города, в которых живут сотрудники каждого отдела. Вариант от Андрея 3");
        BinaryOperator<? super Stream<Employee>> param3 = (k,v) -> {
            System.out.println("param3");
            return Stream.concat(k,v);
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

    private void print_1_CitiesDepartmentsEmployees_4_with_param3_if_D1_D3_renamed_concat(List<Department> departmentList) {
        System.out.println();
        BinaryOperator<? super Stream<Employee>> param3 = (k,v) -> {
            System.out.println("param3");
            return Stream.concat(k,v);
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

    private void print_2_Companies_on_Departments_storages(List<Company> companyList, List<Department> departmentList) {
        /**
         2. Компании продукты которых есть на складах каждого отдела.             <---
            словарь:
                {отдел = [компании, ...] }
         */
        System.out.println("\n>.. Задача 2. Компании, продукты которых есть на складах каждого отдела");


//        System.out.println("\n# mapCompanyToID : Компании и списки id-шников продуктов, которые они производят:");
        // 1) создание мапы Компании - ID (простоя прямая мапа)
        Map<String, List<String>> mapCompanyToID = companyList.stream()
                .collect(Collectors.toMap(
                        k -> k.name,
                        v -> v.productIdList.stream()
                                .collect(Collectors.toList())
                ));
//        mapCompanyToID.entrySet().stream().forEach(System.out::println);

        // 2) создание мапы - Отделы - ID (простая прямая мапа)
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


        // 6) создаем мапу - соответствие отделы - имена компаний
//        System.out.println("\n>.. Мапа Отделы - Компании:");

        mapDepsToID.entrySet().stream()
                .collect(Collectors.toMap(
                        k -> k.getKey(),
                        v_listID -> {
                            return v_listID.getValue().stream()
                                    .map(id -> mapIdToCompany.get(id))
                                    .flatMap(x -> x.stream())
                                    .collect(Collectors.toSet());
                        }
                ))
                .entrySet().stream()
                .forEach(System.out::println);
    }




}




