/* 
User: Urmi
Date: 11/25/2020 
Time: 3:06 PM
*/

package com.example.cassandra.springbootcassandrademo.controller;

import com.example.cassandra.springbootcassandrademo.exception.ResourceNotFoundException;
import com.example.cassandra.springbootcassandrademo.model.Product;
import com.example.cassandra.springbootcassandrademo.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public Product addProducts(@RequestBody Product product){
        productRepository.save(product);
        return productRepository.findById(product.getId()).orElseGet(null);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id){
        Product p = productRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Product not found: " + id));
        return ResponseEntity.ok().body(p);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){

        return productRepository.findAll();
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        product.setName(productDetails.getName());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found::: " + productId));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }

}
