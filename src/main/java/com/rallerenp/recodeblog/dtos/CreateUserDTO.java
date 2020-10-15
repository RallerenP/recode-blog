package com.rallerenp.recodeblog.dtos;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Data // Lombok data annotation (auto create getter, setter, equals, hashcode, etc..)
public class CreateUserDTO
{
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 20)
    private String username;

    @Pattern(
            regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message = "Password must be atleast 8 characters, and contain atleast 1 uppercase letter, 1 lowercase letter and 1 number."
    )
    private String password;

    @Email
    private String email;
}
