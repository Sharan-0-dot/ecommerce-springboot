package com.SV_Shop_Zone.in.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacedOrderDTO {
    private int userId;
    private List<CartItemDTO> cart;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItemDTO> getCart() {
        return cart;
    }

    public void setCart(List<CartItemDTO> cart) {
        this.cart = cart;
    }
}
