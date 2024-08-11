package org.example.product;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Product")
public class Product implements Serializable {
    private Integer id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(Integer id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
