package com.SV_Shop_Zone.in.Controller;


import com.SV_Shop_Zone.in.Model.Orders;
import com.SV_Shop_Zone.in.Model.PlacedOrderDTO;
import com.SV_Shop_Zone.in.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Order")
public class OrdersController {
    @Autowired
    OrderService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllOrders() {
        List<Orders> list = service.getAllOrders();
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> placeOrder(@RequestBody PlacedOrderDTO object) {
        Orders ob = service.placeOrder(object);
        if(ob != null) {
            return new ResponseEntity<>(ob, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
