package com.example.dars5_sptring.telegramProgect.repository.message;

import com.example.dars5_sptring.telegramProgect.model.Message;
import com.example.dars5_sptring.telegramProgect.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageRepository {




    public void create(Message message) throws SQLException, ClassNotFoundException {
        Connection connection = connectionToSQL();


        PreparedStatement preparedStatement = connection.prepareStatement("insert into message(id,sender_id,receiver_id,sender_username,receiver_username,message,created,updated)values " +
                "(?::uuid,?::uuid,?::uuid,?,?,?,?,?)");
        preparedStatement.setString(1,message.getId().toString());
        preparedStatement.setString(2,message.getSenderId().toString());
        preparedStatement.setString(3,message.getReceiverId().toString());
        preparedStatement.setString();
    }



    private Connection connectionToSQL() throws ClassNotFoundException, SQLException {
        Class.forName("java.sql.Driver");


        Connection cOnnection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/telegram","postgres","123"
        );
        return cOnnection;
    }
}
