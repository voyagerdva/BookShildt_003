package e0119_Test_for_StreamAPI_14_exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {
    public String name;
    Employee head;
    List<Employee> employeeses;
    Map<Product, Integer> productRegestry;
    public Map<String, List<Task>> employeeTaskMap = new HashMap<>();

    public Department (String name, Employee head, List<Employee> employees, Map<Product, Integer> productRegestry) {
        this.name = name;
        this.head = head;
        this.employeeses = employees;
        this.productRegestry = productRegestry;
    }
}
