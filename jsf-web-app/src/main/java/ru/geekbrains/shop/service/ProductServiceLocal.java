package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductServiceLocal {

    void insert(ProductRepr productRepr);

    void update(ProductRepr productRepr);

    void delete(Long id);

    ProductRepr findById(Long id);

    List<ProductRepr> findAll();
}
