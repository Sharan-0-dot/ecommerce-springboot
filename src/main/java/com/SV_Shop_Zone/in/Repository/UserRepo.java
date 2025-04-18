package com.SV_Shop_Zone.in.Repository;

import com.SV_Shop_Zone.in.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
