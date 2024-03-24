package com.example.apisupermarket.controllers;

import com.example.apisupermarket.domain.product.Product;
import com.example.apisupermarket.domain.product.ProductRepository;
import com.example.apisupermarket.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }
    @PostMapping
    public ResponseEntity storeProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        repository.save(newProduct);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody @Valid RequestProduct data){
        Product product = repository.getReferenceById(id);
        product.setName(data.product_name());
        product.setPrice(data.product_price());

        repository.save(product);

        return ResponseEntity.ok(product);
    }
}
