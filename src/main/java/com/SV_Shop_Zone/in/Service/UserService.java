package com.SV_Shop_Zone.in.Service;

import com.SV_Shop_Zone.in.Model.OrderItems;
import com.SV_Shop_Zone.in.Model.Orders;
import com.SV_Shop_Zone.in.Model.User;
import com.SV_Shop_Zone.in.Repository.OrderItemRepo;
import com.SV_Shop_Zone.in.Repository.OrdersRepo;
import com.SV_Shop_Zone.in.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    @Autowired
    OrderItemRepo itemRepo;

    public List<User> getAllUser() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }


    public ResponseEntity<?> postUser(User u) {
        try {
            User savedUser = repo.save(u);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Error: Email or Contact already exists!", HttpStatus.CONFLICT);
        }
    }

    public User putuser(User u) {
        return repo.save(u);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }

    public List<Orders> getAllOrders(int id) {
        User user = repo.findById(id).orElse(null);
        if(user == null) {
            return null;
        }
        return user.getOrdersList();
    }

    public List<OrderItems> getAllItems(int orderId) {
        List<OrderItems> list = itemRepo.findByOrderOrderId(orderId);
        if(list == null) return null;
        return list;
    }
}
