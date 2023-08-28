package com.example.telegramProgect.model.dto.user;


import com.example.telegramProgect.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto extends User {

    private String name;
    private String username;
    private String password;
    private String phoneNumber;

}
