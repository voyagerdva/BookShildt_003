package e0119_Test_for_StreamAPI_14_exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initialize {

    public List<Address19> addressList;
    public List<Product> productList;
    public List<Company> companyList;
    public List<Employee> employeeList;
    public List<Task> taskList;
    public List<Department> departmentList;
    public Map<String, List<Task>> taskMap;
    public Map<Product, Integer> productRegestry;

    public void run() {
        addressList = new ArrayList<>();
        productList = new ArrayList<>();
        companyList = new ArrayList<>();
        employeeList = new ArrayList<>();
        taskList = new ArrayList<>();
        departmentList = new ArrayList<>();
        taskMap = new HashMap<>();
        productRegestry = new HashMap<>();

        //=====================================================================

        fillAddressList(addressList);
        fillProductList(productList);
        fillCompanyList(addressList, productList, companyList);
        fillEmployeeList(addressList, employeeList);

        createDepartmentList(productList, employeeList, departmentList);

    }


    private void fillAddressList(List<Address19> addressList) {
        addressList.add(new Address19("NY", "Wall st.", 12));                   //  0
        addressList.add(new Address19("Rome", "Wall st.", 15));                 //  1
        addressList.add(new Address19("NY", "Mall av.", 125));                  //  2
        addressList.add(new Address19("Moscow", "Leninf pr.", 133));            //  3
        addressList.add(new Address19("Paris", "Mira pr.", 5));                 //  4
        addressList.add(new Address19("Moscow", "Mira pr.", 313));              //  5
        addressList.add(new Address19("Nizh_Novgorod", "Leninf pr.", 22));      //  6
        addressList.add(new Address19("Nizh_Novgorod", "Radio st.", 5));        //  7
        addressList.add(new Address19("Rome", "Pavel sq.", 53));                //  8   Rome
        addressList.add(new Address19("NY", "Era", 54));                        //  9
        addressList.add(new Address19("Moscow", "Green st.", 81));              //  10
        addressList.add(new Address19("Nizh_Novgorod", "Moor st.", 36));        //  11
        addressList.add(new Address19("Paris", "Flower av.", 8));               //  12
        addressList.add(new Address19("Rome", "Pritool st.", 63));              //  13  Rome
        addressList.add(new Address19("Paris", "Bio st.", 56));                 //  14
        addressList.add(new Address19("NY", "Mooring st.", 39));                //  15
        addressList.add(new Address19("NY", "Garden sq.", 521));                //  16
    }

    private void fillEmployeeList(List<Address19> addressList, List<Employee> employeeList) {
        employeeList.add(new Employee("000", "Tirion", "Lannister", addressList.get(0)));    // NY
        employeeList.add(new Employee("001", "Jaime", "Lannister", addressList.get(1)));     //
        employeeList.add(new Employee("002", "Serseya", "Lannister", addressList.get(2)));   // NY
        employeeList.add(new Employee("003", "Jon", "Snow", addressList.get(3)));            //
        employeeList.add(new Employee("004", "Robb", "Stark", addressList.get(4)));          //
        employeeList.add(new Employee("005", "Sansa", "Stark", addressList.get(8)));         //
        employeeList.add(new Employee("006", "Arya", "Stark", addressList.get(6)));          // Nizh_Novgorod
        employeeList.add(new Employee("007", "Robert", "Barateon", addressList.get(7)));     // Nizh_Novgorod
        employeeList.add(new Employee("008", "Stannis", "Barateon", addressList.get(13)));   //
        employeeList.add(new Employee("009", "Sandor", "Kligan", addressList.get(0)));       // NY
        employeeList.add(new Employee("010", "Viserion", "Targarien", addressList.get(9)));  // NY
        employeeList.add(new Employee("011", "Dejeneris", "Targarien", addressList.get(0))); // NY
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
        Department department4 = new Department("D4", employeeList.get(11), employeeList.subList(8, 12), productRegestry4);

        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);
        departmentList.add(department4);
    }


}
