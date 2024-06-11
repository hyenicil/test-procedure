package org.yenicilh.testprocedure.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yenicilh.testprocedure.entity.Product;
import org.yenicilh.testprocedure.repository.ProductRepository;
import org.yenicilh.testprocedure.repository.ProductService;

import java.sql.SQLException;

@Service
public class ProductImplService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product, String schemaName) throws SQLException {
        PGobject productData = new PGobject();
        productData.setType("new_schema.product_type");

        String value = String.format(
                "(%s, %s, %s, %d)",
                product.getName() != null ? "'" + product.getName() + "'" : null,
                product.getPrice() != null ? product.getPrice().toString() : null,
                product.getCategory() != null ? "'" + product.getCategory() + "'" : null,
                product.getId() != null ? product.getId() : null
        );
        productData.setValue(value);

        return productRepository.saveProduct(schemaName, productData);

    }

}
