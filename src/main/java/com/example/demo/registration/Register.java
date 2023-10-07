package com.example.demo.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Register {
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String password;
}
