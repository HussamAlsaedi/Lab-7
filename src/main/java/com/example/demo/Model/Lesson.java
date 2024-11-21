package com.example.demo.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lesson {

    @NotEmpty(message = "Id Must Be Not Empty")
    @Size(min = 1, max = 10, message ="Long of id Must Be between 1 to 10")
    private String id;

    @NotEmpty(message = "Capacity Must Be Not Empty")
    @Size(min = 1, max = 15, message ="capacity Must Be between 1 to 15")
   // @Pattern(regexp = "[0-9]$" , message = "Capacity must be number")
    private String capacity;
}
