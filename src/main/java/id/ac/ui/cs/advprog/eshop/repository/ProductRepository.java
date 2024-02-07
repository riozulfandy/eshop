package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    int id = 1;

    public Product create(Product product) {
        productData.add(product);
        product.setProductId(String.valueOf(id++));
        return product;
    }

    public void delete(String productId) {
        productData.removeIf(product -> product.getProductId().equals(productId));
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}