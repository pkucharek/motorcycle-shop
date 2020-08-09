package com.kucharek.motorcycleshop.service;

import com.kucharek.motorcycleshop.data.Role;
import com.kucharek.motorcycleshop.data.RoleRepository;
import com.kucharek.motorcycleshop.data.User;
import com.kucharek.motorcycleshop.data.UserRepository;
import com.kucharek.motorcycleshop.user.FormUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public void saveFormUser(FormUser formUser) {
        User user = User.builder()
            .username(formUser.getUserName())
            .password(passwordEncoder.encode(formUser.getPassword()))
            .firstName(formUser.getFirstName())
            .lastName(formUser.getLastName())
            .email(formUser.getEmail())
            .balance((long) 500)
            .phoneNumber(formUser.getPhoneNumber())
            .roles(Arrays.asList(roleRepository.findRoleByName("ROLE_USER")))
                .build();

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority>
        mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> {
                    return new SimpleGrantedAuthority(role.getName());
                }).collect(Collectors.toList());
    }

    @Override
    public void chargeUser(String userName) {
        User user = userRepository.findByUsername(userName);
        user.setBalance(user.getBalance() + 500);
        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
