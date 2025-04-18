package com.SV_Shop_Zone.in.Service;

import com.SV_Shop_Zone.in.Model.Product;
import com.SV_Shop_Zone.in.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product postProduct(Product p) {
        return repo.save(p);
    }

    public Product putProduct(Product p) {
        return repo.save(p);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }

    public List<Product> getProductsByKey(String keyword) {
        return repo.searchByKeyword(keyword);
    }
}
