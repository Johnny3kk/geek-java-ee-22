package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.persist.Boxing;
import ru.geekbrains.shop.persist.BoxingRepository;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private BoxingRepository boxingRepository;

    private Product product;

    private Boxing boxing;

    private List<Product> products;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        this.products = productRepository.findAll();

    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Boxing> getAllBoxing() {
        return boxingRepository.findAll();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boxing getBoxing() {
        return boxing;
    }

    public void setBoxing(Boxing boxing) {
        this.boxing = boxing;
    }

    public String editProduct(Product product) {
        this.product = product;
        return "product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product.getId());
    }

    public String saveProduct() {
        if (product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(this.product);
        }
        return "shop.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        this.product = new Product();
        return "product.xhtml?faces-redirect=true";
    }

    public String goShopping() {
        return "shop.xhtml?faces-redirect=true";
    }
}
