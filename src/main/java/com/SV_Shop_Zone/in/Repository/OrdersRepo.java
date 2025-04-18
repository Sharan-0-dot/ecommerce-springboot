package com.SV_Shop_Zone.in.Repository;

import com.SV_Shop_Zone.in.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
