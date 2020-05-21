package com.kucharek.motorcycleshop.user;

import com.kucharek.motorcycleshop.user.validation.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword",
                message = "The password fields must match")
})
public class FormUser {

    @NotBlank(message = "{user.notNull}")
    private String userName;

    @NotBlank(message = "{user.notNull}")
    private String password;

    @NotBlank(message = "{user.notNull}")
    private String matchingPassword;

    @NotBlank(message = "{user.notNull}")
    private String firstName;

    @NotBlank(message = "{user.notNull}")
    private String lastName;

    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@" +
                      "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$",
             message = "{user.validEmail}")
    private String email;
}
