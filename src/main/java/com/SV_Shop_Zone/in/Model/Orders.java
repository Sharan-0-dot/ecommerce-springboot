package com.SV_Shop_Zone.in.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @Column(columnDefinition = "DOUBLE")
    private double totalPrice;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime time;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderItems> orderItemsList;

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }
}
