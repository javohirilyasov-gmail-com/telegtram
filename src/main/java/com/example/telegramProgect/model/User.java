package com.example.telegramProgect.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    public User(UUID id, LocalDateTime create, LocalDateTime update, String name, String username, String password, String phoneNumber, boolean isDeleted) {
        super(id, create, update);
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isDeleted = isDeleted;
    }
}
