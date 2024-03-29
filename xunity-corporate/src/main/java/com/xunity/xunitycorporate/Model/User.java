package com.xunity.xunitycorporate.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String department;
    //private String loginStatus;
    //private LocalDate registerDate;
    private Integer marketId;
}
