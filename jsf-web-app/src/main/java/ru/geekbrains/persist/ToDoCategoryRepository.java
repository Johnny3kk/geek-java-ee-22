package ru.geekbrains.persist;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ToDoCategoryRepository {

    ToDoCategory findById(Long id);

    List<ToDoCategory> findAll();
}
