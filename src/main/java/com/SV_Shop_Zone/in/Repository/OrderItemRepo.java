package com.SV_Shop_Zone.in.Repository;

import com.SV_Shop_Zone.in.Model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findByOrderOrderId(int orderId);
}
