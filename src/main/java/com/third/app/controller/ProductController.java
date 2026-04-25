package com.third.app.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.third.app.model.Product;
import com.third.app.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*") 
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // FIX: Added this method so the Edit page can load data
    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        return service.getById(id); 
    }

    @GetMapping
    public List<Product> findAll() {
        return service.getAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @PostMapping("/bulk")
    public List<Product> createMultiple(@RequestBody List<Product> products) {
        return service.saveAll(products);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product details) {
        return service.update(id, details);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Product " + id + " has been deleted.";
    }
}