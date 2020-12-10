package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.persist.*;
import ru.geekbrains.shop.service.ProductRepr;
import ru.geekbrains.shop.service.ProductServiceLocal;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private ProductServiceLocal productService;

    @Inject
    private BoxingRepository boxingRepository;

    private ProductRepr product;

    private List<ProductRepr> products;

    private List<Boxing> boxings;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        this.products = productService.findAll();
        this.boxings = boxingRepository.findAll();
    }

    public List<ProductRepr> getAllProducts() {
        return products;
    }

    public List<Boxing> getBoxings() {
        return boxings;
    }

    public ProductRepr getProduct() {
        return product;
    }

    public void setProduct(ProductRepr product) {
        this.product = product;
    }


    public String editProduct(ProductRepr product) {
        this.product = product;
        return "/manager/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductRepr product) {
        productService.delete(product.getId());
    }

    public String saveProduct() {
        if (product.getId() == null) {
            productService.insert(product);
        } else {
            productService.update(this.product);
        }
        return "/shop.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        this.product = new ProductRepr();
        return "/manager/product.xhtml?faces-redirect=true";
    }

    public String goShopping() {
        return "shop.xhtml?faces-redirect=true";
    }
}
