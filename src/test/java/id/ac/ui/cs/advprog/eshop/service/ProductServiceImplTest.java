package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testCreateProduct() {
        // Arrange
        Product productToCreate = new Product();
        productToCreate.setProductName("Test Product");

        // Mock the repository behavior
        Mockito.when(productRepository.create(productToCreate)).thenReturn(productToCreate);

        // Act
        Product createdProduct = productService.create(productToCreate);

        // Assert
        assertEquals("Test Product", createdProduct.getProductName());
    }

    @Test
    public void testFindAllProducts() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductName("Test Product 1");
        products.add(product1);
        Product product2 = new Product();
        product2.setProductName("Test Product 2");
        products.add(product2);

        // Mock the repository behavior
        Iterator<Product> productIterator = products.iterator();
        Mockito.when(productRepository.findAll()).thenReturn(productIterator);

        // Act
        List<Product> allProducts = productService.findAll();

        // Assert
        assertEquals(2, allProducts.size());
        assertEquals("Test Product 1", allProducts.get(0).getProductName());
        assertEquals("Test Product 2", allProducts.get(1).getProductName());
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        String productId = "1";

        // Act
        productService.delete(productId);

        // Assert
        Mockito.verify(productRepository).delete(productId);
    }

    @Test
    public void testFindProductById() {
        // Arrange
        String productId = "1";
        Product product = new Product();
        product.setProductName("Test Product");

        // Mock the repository behavior
        Mockito.when(productRepository.findById(productId)).thenReturn(product);

        // Act
        Product foundProduct = productService.findById(productId);

        // Assert
        assertEquals("Test Product", foundProduct.getProductName());
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        Product productToUpdate = new Product();
        productToUpdate.setProductName("Test Product");

        // Act
        productService.update(productToUpdate);

        // Assert
        Mockito.verify(productRepository).update(productToUpdate);
    }

}
