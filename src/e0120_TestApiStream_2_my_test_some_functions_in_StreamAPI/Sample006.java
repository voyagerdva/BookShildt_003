package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import e0119_Test_for_StreamAPI_14_exercises.Address19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample006 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add("ONE");
        list1.add("TWO");
        list2.add("THREE");
        list2.add(String.valueOf(list1));

        System.out.println(list2);



    }
}
