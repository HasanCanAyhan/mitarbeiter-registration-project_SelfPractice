package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mitarbeiter {



    //VALIDATION
    //@NotNull  --> Field should not be null
    //@NotEmpty --> Field should not be ""
    //@NotBlank --> Field should not be "     "

    //@NotNull -> @NotNull
    //@NotEmpty -> @NotNull + @NotEmpty
    //@NotBlank -> @NotNull + @NotEmpty + @NotBlank

    @NotBlank
    @Size(max = 12, min = 2) // index 1 , index 2
    private String firstName;

    @NotBlank
    private String lastName;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")//Thymeleaf accepts yyyy-MM-dd, but LocalDate accepts mm-dd-yyyy
    private LocalDate birthday;

    //@NotBlank
    //@Email // for email format
    private String email;

    //@NotBlank
    //@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}") // regex
    private String password;


    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;


}
