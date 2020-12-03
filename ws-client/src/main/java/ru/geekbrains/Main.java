package ru.geekbrains;

import ru.geekbrains.service.ToDoService;
import ru.geekbrains.service.ToDoServiceWs;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/jsf-web-app/ToDoService/ToDoServiceImpl?wsdl");
        ToDoService toDoService = new ToDoService(url);

        ToDoServiceWs port = toDoService.getToDoServiceImplPort();
        port.findAll().forEach(todo -> System.out.println(todo.getId() + ": " + todo.getDescription()));
    }
}
