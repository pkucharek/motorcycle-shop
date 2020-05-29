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

    @Pattern(regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                      "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
                      "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+" +
                      "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",
             message = "{user.validEmail}")
    private String email;

    @Pattern(regexp = "^\\d{9}$", message = "{user.validPhoneNumber}")
    private String phoneNumber;
}
