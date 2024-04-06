package com.example.requesttracing.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private String gender;
    private String phone;
    private Long age;
}
