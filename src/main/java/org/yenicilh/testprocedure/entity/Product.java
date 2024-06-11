package org.yenicilh.testprocedure.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import jdk.jfr.Threshold;

@Entity(name = "product")
@Table(name="product", schema = "new_schema")
public class Product {

    private String name;
    private Double price;
    private String category;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
