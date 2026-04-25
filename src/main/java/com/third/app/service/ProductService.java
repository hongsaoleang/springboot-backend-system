package com.third.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.third.app.model.Product;
import com.third.app.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // --- ADDED THIS METHOD ---
    // This supports the findOne method in your Controller
    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product save(Product p) {
        return repository.save(p);
    }

    public List<Product> saveAll(List<Product> products) {
        return repository.saveAll(products);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Product not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public Product update(Long id, Product details) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        // Update fields from the 'details' object sent by Vue
        existing.setName(details.getName());
        existing.setDescription(details.getDescription());
        existing.setPrice(details.getPrice());
        existing.setQuantity(details.getQuantity());
        existing.setCategory(details.getCategory());
        
        return repository.save(existing);
    }
}