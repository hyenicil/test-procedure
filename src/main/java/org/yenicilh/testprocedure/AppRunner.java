package org.yenicilh.testprocedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yenicilh.testprocedure.entity.Product;
import org.yenicilh.testprocedure.service.ProductImplService;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private ProductImplService productService;

    @Override
    public void run(String... args) throws Exception {

        Product product = new Product("Armut", 5.0, "Meyve");
        productService.save(product, "test");
    }
}