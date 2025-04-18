package com.SV_Shop_Zone.in.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "contact")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    @Column(unique = true, nullable = false)
    private String contact;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Orders> ordersList;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public String getEmail() {
        return email;
    }
}
