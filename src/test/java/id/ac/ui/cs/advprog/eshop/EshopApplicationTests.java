package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void applicationStartsSuccessfully() {
        // Test if the main method of your application starts up without errors
        EshopApplication.main(new String[]{});
    }
}
