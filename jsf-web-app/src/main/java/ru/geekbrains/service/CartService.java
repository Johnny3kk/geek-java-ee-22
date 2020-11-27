package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.service.ProductRepr;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartService implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    private List<ProductRepr> cart = new ArrayList<ProductRepr>();

    public void add(ProductRepr productRepr) {
        this.cart.add(productRepr);
    }

    public void remove(ProductRepr productRepr) {
        int index = this.cart.indexOf(productRepr);
        cart.remove(index);
    }

    public List<ProductRepr> getCart() {
        return cart;
    }
}
