package com.ss.bookstore.service;

import com.ss.bookstore.entity.User;

public interface UserService {
    String getUser(int id);
    String getRole(String username);
    User getUser(User user);

}
