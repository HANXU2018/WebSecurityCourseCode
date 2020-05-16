package com.safe.web1.dao;

import com.safe.web1.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer>{
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}
