package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.user.FormUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService
        extends UserDetailsService {

    User findByUserName(String userName);

    void save(FormUser formUser);

    void chargeUser(String userName);
}
