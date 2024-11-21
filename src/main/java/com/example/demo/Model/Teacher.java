package com.example.demo.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "Id Must Be Not Empty")
    @Size(min = 1, max = 10, message ="Long of id Must Be between 1 to 10")
    private String id;

    @NotEmpty(message = "Name Must Be Not Empty")
    @Size(min = 1, max = 40, message ="Long of name Must Be between 1 to 40")
    private String name;

    @NotEmpty(message = "Email Must Be Not Empty")
    @Email(message = "Please Write Correct Email")
    private String email;
}
