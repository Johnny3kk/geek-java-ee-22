package ru.geekbrains.controller;

import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ToDoRepr;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.service.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartControllerEjb implements Serializable {

    @EJB
    private CartService cartService;

    public String goChecking() {
        return "cart.xhtml?faces-redirect=true";
    }

    public void add(ProductRepr productRepr) {
        cartService.add(productRepr);
    }

    public void remove(ProductRepr productRepr) {
        cartService.remove(productRepr);
    }

    public List<ProductRepr> getAll() {
        return cartService.getCart();
    }

}
