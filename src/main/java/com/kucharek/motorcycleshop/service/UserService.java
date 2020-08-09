package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.user.FormUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService
        extends UserDetailsService {

    User findByUserName(String userName);

    void saveFormUser(FormUser formUser);
    void saveUser(User user);

    void chargeUser(String userName);
}
