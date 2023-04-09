
package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.util.*;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.stream.Collectors;

public class Sample001 {
    private final List<User001> userList = Arrays.asList(
            new User001(1, "Michael", "Robert", 37, "TR"),
            new User001(2, "Mary", "Patricia", 11, "EN"),
            new User001(3, "John", "Michael", 7, "FR"),
            new User001(4, "Jennifer", "Linda", 77, "TR"),
            new User001(5, "William", "Elizabeth", 23, "US"),
            new User001(6, "Sue", "Jackson", 11, "IT"),
            new User001(7, "Michael", "Tommy", 37, "EN")
    );

    public static void main(String[] args) {
        Sample001 sample = new Sample001();
//        sample.test1();
//        sample.test2();
//        sample.test3();
//        sample.test4();
//        sample.test5();
//        sample.test6();
//        sample.test7();
//        sample.test8();
//        sample.test9();
        sample.test10();


    }

    private void test1() {
        System.out.println("\n>... Test 1");
        userList.stream()
                .forEach(item -> System.out.println("User: "
                        + item.id + " " + item.firstName + " " + item.lastName + " " + item.age + " " + item.nationality + " "));
    }

    private void test2() {
        System.out.println("\n>... Test 2");
        userList.stream()
                .map(u -> {
                    User001 user = new User001(
                            u.getId(),
                            "X-" + u.getFirstName(),
                            "Y-" + u.getLastName(),
                            u.getAge(),
                            u.getNationality()
                    );
                    return user;
                })
                .collect(Collectors.toList())
                .forEach(item -> System.out.println("User: " + item.id + " " + item.firstName + " " + item.lastName + " " + item.age + " " + item.nationality + " "));
    }

    private void test3() {
        System.out.println("\n>... Test 3");
        userList.stream()
                .sorted(Comparator.comparing(User001::getAge))
                .collect(Collectors.toList())
                .forEach(item -> System.out.println("User: " + item.id + " " + item.firstName + " " + item.lastName + " " + item.age + " " + item.nationality + " "));

    }

    private void test4() {
        System.out.println("\n>... Test 4");
        userList.stream()
                .sorted(Comparator.comparing(User001::getAge)
                        .thenComparing(User001::getFirstName)
                        .thenComparing(User001::getNationality))
                .collect(Collectors.toList())
                .forEach(item -> System.out.println("User: " + item.id + " " + item.firstName + " " + item.lastName + " " + item.age + " " + item.nationality + " "));

    }

    private void test5() {
        System.out.println("\n>... Test 5");
        double averageAge = userList.stream()
                .mapToInt(User001::getAge)
                .summaryStatistics()
                .getAverage();

        System.out.println("Average Age: " + averageAge);

        int maxFirstNameLenght = userList.stream()
                .mapToInt(v -> v.getFirstName().length())
                .summaryStatistics()
                .getMax();
        System.out.println("maxFirstNameLenght: " + maxFirstNameLenght);


    }

    private void test6() {
        System.out.println("\n>... Test 6");
        boolean isAllAgesGreaterThan_6 = userList.stream()
                .allMatch(u -> u.getAge() > 6);
        System.out.println("isAllAgesGreaterThan_6: " + isAllAgesGreaterThan_6);
    }

    private void test7() {
        System.out.println("\n>... Test 7");
        boolean isFirstChar_S = userList.stream()
                .anyMatch(u -> u.getFirstName().charAt(0) == 'S');
        System.out.println("isFirstChar_S: " + isFirstChar_S);
    }

    private void test8() {
        System.out.println("\n>... Test 8");



        System.out.println("\n- list:");
        List<User001> list = userList.stream()
                .collect(Collectors.toList());
        list.forEach(item -> System.out.println("User: "
                + item.id + " "
                + item.firstName + " "
                + item.lastName + " "
                + item.age + " "
                + item.nationality + " "));

        System.out.println("\n- set:");
        Set<User001> set = userList.stream()
                .collect(Collectors.toSet());
        set.forEach(item -> System.out.println("User: "
                + item.id + " "
                + item.firstName + " "
                + item.lastName + " "
                + item.age + " "
                + item.nationality + " "));


        System.out.println("\n- linkedList:");
        List<User001> linkedList = userList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        linkedList.forEach(item -> System.out.println("User: "
                + item.id + " "
                + item.firstName + " "
                + item.lastName + " "
                + item.age + " "
                + item.nationality + " "));

        System.out.println("\n- map:");
        Map<Long, User001> map = userList.stream()
                .collect(Collectors.toMap(
                        item -> item.getId(),
                        item -> item
                ));
        map.forEach((k, v) -> {
            System.out.print(k + " : ");
            System.out.println(v.getFirstName()
                    + v.id + " "
                    + v.lastName + " "
                    + v.age + " "
                    + v.nationality + " ");
        });

    }

    private void test9() {
        System.out.println("\n>... Test 9");
        long countDiffNations = userList.stream()
                .map(User001::getNationality)
                .distinct()
                .count();
        System.out.println("countDiffNations: " + countDiffNations);
    }

    private void test10() {
        System.out.println("\n>... Test 10");
        userList.stream()
                .filter(p -> p.getFirstName().charAt(0) != 'M')
                .filter(p -> p.getAge() > 10)
                .collect(Collectors.toList())
                .forEach(item -> System.out.println("User: "
                        + item.id + " "
                        + item.firstName + " "
                        + item.lastName + " "
                        + item.age + " "
                        + item.nationality + " "));
    }
}
