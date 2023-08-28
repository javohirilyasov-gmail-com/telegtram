package com.example.telegramProgect.repository.user;

import com.example.telegramProgect.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private static UserRepository userRepository = null;

    private UserRepository(){}

    public static UserRepository getInstance() {
        if (userRepository == null){
            userRepository = new UserRepository();
            return userRepository;
        }
        return userRepository;
    }


    public void create(User user) throws SQLException, ClassNotFoundException {
        if (user != null) {
            Connection connection = connectionToSQL();


            PreparedStatement preparedStatement = connection.prepareStatement("insert into tg_user(id,name,username,password,phone_number,created,updated)values (?::uuid,?,?,?,?,?,?);");
            preparedStatement.setString(1, user.getId().toString());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setTimestamp(6,Timestamp.valueOf(user.getCreated()));
            preparedStatement.setTimestamp(7,Timestamp.valueOf(user.getUpdated()));

            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    public void delete(UUID id) throws SQLException, ClassNotFoundException {
        if (id != null) {
            Connection connection = connectionToSQL();

            PreparedStatement preparedStatement = connection.prepareStatement("update tg_user set is_deleted = true where id = ?::uuid;");
            preparedStatement.setString(1, id.toString());

            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    public User update(User user) throws SQLException, ClassNotFoundException {
            User updatedUser = null;
        if (user != null){
            Connection connection = connectionToSQL();

            PreparedStatement preparedStatement = connection.prepareStatement("update tg_user set name = ?, username = ?, password = ?, phone_number = ?, updated = ? where id = ?::uuid and is_deleted <> true;");
            LocalDateTime update = user.getUpdated();
            update = LocalDateTime.now();
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getPhoneNumber());
            preparedStatement.setTimestamp(5,Timestamp.valueOf(update));
            preparedStatement.setString(6,user.getId().toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_number");
                LocalDateTime updated = resultSet.getTimestamp("updated").toLocalDateTime();
                updatedUser = new User(user.getId(),user.getCreated(),updated,name,username,password,phoneNumber,false   );
            }
        }
        return updatedUser;
    }



    public List<User> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = connectionToSQL();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from tg_user where is_deleted <> true;");

        List<User> users = new ArrayList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
            LocalDateTime updated = resultSet.getTimestamp("updated").toLocalDateTime();
            users.add(new User(id,created,updated,name,username,password,phoneNumber,false ));
        }
        return users;
    }



    public User findByUserPhoneNumber(String phoneNumber) throws SQLException, ClassNotFoundException {
        Connection connection = connectionToSQL();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from tg_user where phone_number = ? and is_deleted <> true;");
        preparedStatement.setString(1,phoneNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        User getUser = null;
        if (resultSet.next()){
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
            LocalDateTime updated = resultSet.getTimestamp("updated").toLocalDateTime();
            getUser = new User(id,created,updated,name,username,password,phoneNumber,false);
        }
        return getUser;
    }





    private Connection connectionToSQL() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");


        Connection cOnnection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/telegram","postgres","123"
        );
        return cOnnection;
    }

}
