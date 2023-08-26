package com.example.dars5_sptring.telegramProgect.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private boolean isDeleted;
}
