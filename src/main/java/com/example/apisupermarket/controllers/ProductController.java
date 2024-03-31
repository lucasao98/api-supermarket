package com.example.apisupermarket.controllers;

import com.example.apisupermarket.domain.product.Product;
import com.example.apisupermarket.domain.product.ProductRepository;
import com.example.apisupermarket.domain.product.RequestProduct;
import com.example.apisupermarket.domain.user.User;
import com.example.apisupermarket.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity getProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }
    @PostMapping
    public ResponseEntity storeProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        Optional<User> userOptional = userRepository.findById(data.id_user());

        if(userOptional.isPresent()){
            newProduct.setUsuario(userOptional.get());

            repository.save(newProduct);

            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody @Valid RequestProduct data){
        Optional <Product> optionalProduct = repository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            product.setProduct_name(data.product_name());
            product.setProduct_description(data.product_description());
            product.setProduct_expiry(data.product_expiry());
            product.setProduct_price(data.product_price());
            product.setProduct_manufacturing_date(data.product_manufacturing_date());

            repository.save(product);

            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        Optional<Product> optionalProduct = repository.findById(id);

        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            repository.delete(product);

            return ResponseEntity.ok("Produto Deletado com sucesso");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
