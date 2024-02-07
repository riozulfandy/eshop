package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        product.setProductId(String.valueOf(productData.size()));
        return product;
    }

    public void delete(String productId) {
        productData.removeIf(product -> product.getProductId().equals(productId));
    }

    public Product findById(String productId) {
        return productData.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public void update(Product product) {
        productData.stream()
                .filter(p -> p.getProductId().equals(product.getProductId()))
                .findFirst()
                .ifPresent(p -> {
                    p.setProductName(product.getProductName());
                    p.setProductQuantity(product.getProductQuantity());
                });
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}