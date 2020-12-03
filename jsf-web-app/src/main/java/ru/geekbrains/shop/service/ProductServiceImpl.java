package ru.geekbrains.shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.shop.persist.Boxing;
import ru.geekbrains.shop.persist.BoxingRepository;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.ProductRepository;
import ru.geekbrains.shop.rest.ProductServiceRs;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "ru.geekbrains.shop.service.ProductServiceWs", serviceName = "ProductService")
public class ProductServiceImpl implements ProductServiceLocal, ProductServiceWs, ProductServiceRs {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Inject
    private ProductRepository productRepository;

    @Inject
    private BoxingRepository boxingRepository;

    @TransactionAttribute
    @Override
    public void insert(ProductRepr productRepr) {
        Boxing boxing = boxingRepository.findById(productRepr.getBoxingId());
        productRepository.insert(new Product(null, productRepr.getName(), productRepr.getBrand(), productRepr.getDescription(), productRepr.getCost(), boxing));
    }

    @TransactionAttribute
    @Override
    public void update(ProductRepr productRepr) {
        Boxing boxing = boxingRepository.findById(productRepr.getBoxingId());
        productRepository.update(new Product(productRepr.getId(), productRepr.getName(), productRepr.getBrand(), productRepr.getDescription(), productRepr.getCost(), boxing));
    }

    @TransactionAttribute
    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public ProductRepr findById(Long id) {
        return productRepository.findProductReprById(id);
    }

    @Override
    public List<ProductRepr> findAll() {
        return productRepository.findAllProductRepr();
    }
}
