package ru.geekbrains.shop.persist;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BoxingRepository {

    Boxing findById(Long id);

    List<Boxing> findAll();
}
