package com.SV_Shop_Zone.in.Controller;


import com.SV_Shop_Zone.in.Model.Product;
import com.SV_Shop_Zone.in.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "https://sharan-0-dot.github.io",
        "https://sharan-0-dot.github.io/E-Commerse-WebPage/",
        "http://127.0.0.1:5500"
})
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Product p = service.getProductById(id);
        if(p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> postProduct(@RequestBody Product p) {
        Product p1 = service.postProduct(p);
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> putProduct(@RequestBody Product p1) {
        return new ResponseEntity<>(service.putProduct(p1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable int id) {
        Product p1 = service.getProductById(id);
        if(p1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            service.deleteProductById(id);
            return new ResponseEntity<>(p1, HttpStatus.OK);
        }
    }

    @GetMapping("/Search/{key}")
    public ResponseEntity<?> getProductsByKey(@PathVariable String key) {
        if(key == null || key.trim().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getProductsByKey(key), HttpStatus.OK);
    }
}
