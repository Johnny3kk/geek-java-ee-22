package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@SessionScoped
public class CartController implements Serializable {

    private List<Product> cart = new ArrayList<Product>();

    public String goChecking() {
        return "cart.xhtml?faces-redirect=true";
    }

    public void addInCart(Product product) {
        this.cart.add(product);
    }

    public void remove(Product product) {
        int index = this.cart.indexOf(product);
        cart.remove(index);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

}
