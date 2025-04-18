package com.SV_Shop_Zone.in.Service;

import com.SV_Shop_Zone.in.Model.*;
import com.SV_Shop_Zone.in.Repository.OrderItemRepo;
import com.SV_Shop_Zone.in.Repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    ProductService prodService;
    @Autowired
    OrderItemRepo itemRepo;
    @Autowired
    UserService userService;

    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    public Orders placeOrder(PlacedOrderDTO object) {
        Orders order = new Orders();
        order.setUser(userService.getUserById(object.getUserId()));
        order.setTime(LocalDateTime.now());
        order.setTotalPrice(calculateTotal(object.getCart()));
        Orders responseOb = ordersRepo.save(order);
        updateItems(responseOb, object);
        return responseOb;
    }

    private double calculateTotal(List<CartItemDTO> cart) {
        double res = 0;
        for(CartItemDTO item : cart) {
            Product prod = prodService.getProductById(item.getProductId());
            if(prod == null) {
                throw new IllegalArgumentException("Product not found with ID: " + item.getProductId());
            }
            res += prod.getPrice() * item.getQuantity();
        }
        return res;
    }

    private void updateItems(Orders responseOb, PlacedOrderDTO object) {
        for(CartItemDTO element : object.getCart()) {
            Product product = prodService.getProductById(element.getProductId());
            if (product == null) {
                throw new IllegalArgumentException("Product not found with ID: " + element.getProductId());
            }
            OrderItems item = new OrderItems();
            item.setOrder(responseOb);
            item.setProduct(product);
            item.setQuantity(element.getQuantity());
            item.setPrice(product.getPrice());
            itemRepo.save(item);
        }
    }
}
