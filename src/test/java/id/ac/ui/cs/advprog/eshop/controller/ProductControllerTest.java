package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.CarService;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private CarService carService;

    @MockBean
    private CarServiceImpl carServiceImpl;


    @Test
    public void testCreateProductPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("CreateProduct"));
    }

    @Test
    public void testCreateProductPost() throws Exception {
        Product product = new Product();
        product.setProductName("Test Product");

        mockMvc.perform(MockMvcRequestBuilders.post("/product/create")
                        .param("name", product.getProductName()))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("list"));
    }

    @Test
    public void testProductListPage() throws Exception {
        Product product1 = new Product();
        product1.setProductName("Test Product 1");
        Product product2 = new Product();
        product2.setProductName("Test Product 2");

        when(productService.findAll()).thenReturn(Arrays.asList(product1, product2));

        mockMvc.perform(MockMvcRequestBuilders.get("/product/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("ProductList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"));
    }

    @Test
    public void testDeleteProductPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/delete/{id}", "123"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("../list"));
    }

    @Test
    public void testEditProductPage() throws Exception {
        Product product = new Product();
        product.setProductId("456");
        when(productService.findById("456")).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/edit/{id}", "456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("EditProduct"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("product"));
    }

    @Test
    public void testEditProductPost() throws Exception {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("Updated Product");
        updatedProduct.setProductId("789");

        mockMvc.perform(MockMvcRequestBuilders.post("/product/edit/{id}", "789")
                        .param("name", updatedProduct.getProductName()))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("../list"));
    }
}
