package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    private final KafkaProducer kafkaProducer;
    private final ProductService productService;

    @Autowired
    public Controller(KafkaProducer kafkaProducer, ProductService productService) {
        this.kafkaProducer = kafkaProducer;
        this.productService = productService;
    }

    @GetMapping("/message")
    public String greetingMessage(@RequestParam String message) {
        kafkaProducer.send(message);
        return "hello it is me " + message;
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}