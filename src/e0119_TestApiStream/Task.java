package e0119_TestApiStream;

import java.util.List;

class Task { // Задача имеет случайный uuid (как id) и продукт, который надо продать списку компаний.
    String uuid;
    List<Company> companyList; // список компаний которым продается продукт
    Product product;

    Integer productCount; // общее количество продукта для продажи

    public Task(String uuid, List<Company> companyList, Product product, Integer productCount) {
        this.uuid = uuid;
        this.companyList = companyList;
        this.product = product;
        this.productCount = productCount;
    }

}
