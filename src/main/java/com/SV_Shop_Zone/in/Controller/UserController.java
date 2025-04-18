package com.SV_Shop_Zone.in.Controller;


import com.SV_Shop_Zone.in.Model.OrderItems;
import com.SV_Shop_Zone.in.Model.Orders;
import com.SV_Shop_Zone.in.Model.User;
import com.SV_Shop_Zone.in.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User u = service.getUserById(id);
        if(u == null) {
            return new ResponseEntity<>("User Not Exists",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(u, HttpStatus.OK);
        }
    }

    @GetMapping("/Orders/{id}")
    public ResponseEntity<?> getAllOrders(@PathVariable int id) {
        List<Orders> list = service.getAllOrders(id);
        if(list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("Orders/items/{OrderId}")
    public ResponseEntity<?> getAllItems(@PathVariable int OrderId) {
        List<OrderItems> list = service.getAllItems(OrderId);
        if(list == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> postUser(@RequestBody User u) {
        return service.postUser(u);
    }

    @PutMapping("/")
    public ResponseEntity<?> putUser(@RequestBody User u) {
        User u1 = service.putuser(u);
        if(u1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(u1, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        User u1 = service.getUserById(id);
        if(u1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            service.deleteUser(id);
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
        }
    }
}
