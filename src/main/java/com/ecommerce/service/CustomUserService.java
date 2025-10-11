package com.ecommerce.service;

import com.ecommerce.entity.User;

public interface CustomUserService
{

    String saveUser(User user);

    void updatePassword(String username,String password);

    String updateUserRole(int id, User user);
}
