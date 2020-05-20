package com.kucharek.motorcycleshop.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormUser {

    private String userName;

    private String password;

    private String matchingPassword;

    private String firstName;

    private String lastName;

    private String email;
}
