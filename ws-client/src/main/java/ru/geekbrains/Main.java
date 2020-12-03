package ru.geekbrains;


import ru.geekbrains.shop.service.ProductService;
import ru.geekbrains.shop.service.ProductServiceWs;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

//        URL url = new URL("http://localhost:8080/jsf-web-app/ToDoService/ToDoServiceImpl?wsdl");
//        ToDoService toDoService = new ToDoService(url);
//
//        ToDoServiceWs port = toDoService.getToDoServiceImplPort();
//        port.findAll().forEach(todo -> System.out.println(todo.getId() + ": " + todo.getDescription()));

        URL url = new URL("http://localhost:8080/jsf-web-app/ProductService/ProductServiceImpl?wsdl");
        ProductService productService = new ProductService(url);

        ProductServiceWs port = productService.getProductServiceImplPort();
        port.findAll().forEach(product -> System.out.println(product.getId() + ": " + product.getName()));
    }
}
