package com.example.telegramProgect.service.user;


import com.example.telegramProgect.model.User;
import com.example.telegramProgect.model.dto.user.UserRequestDto;
import com.example.telegramProgect.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(User user) throws SQLException, ClassNotFoundException {
        userRepository.create(user);
    }

    public void delete(UUID id) throws SQLException, ClassNotFoundException {
        userRepository.delete(id);
    }

    public User update(User user) throws SQLException, ClassNotFoundException {
        return userRepository.update(user);
    }

    public List<User> getAll() throws SQLException, ClassNotFoundException {
        return userRepository.getAll();
    }

    public User findByUserPhone(String phoneNumber) throws SQLException, ClassNotFoundException {
        return userRepository.findByUserPhoneNumber(phoneNumber);
    }


    public User checkerPhoneNumber(UserRequestDto user){
        String phoneNumber = user.getPhoneNumber();
        String updatedNumber = phoneNumber.replaceAll("\\s", "");
        user.setPhoneNumber(updatedNumber);
        return user;
    }


}
