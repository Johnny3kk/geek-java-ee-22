package ru.geekbrains.shop.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {

    @WebMethod
    void insert(ProductRepr productRepr);

    @WebMethod
    void update(ProductRepr productRepr);

    @WebMethod
    void delete(Long id);

    @WebMethod
    ProductRepr findById(Long id);

    @WebMethod
    List<ProductRepr> findAll();
}
