package com.example.telegramProgect.repository.message;

import com.example.telegramProgect.model.Message;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MessageRepository {


    private static MessageRepository messageRepository = null;
    private MessageRepository(){}

    public static MessageRepository getInstance() {
        if (messageRepository == null){
            messageRepository = new MessageRepository();
        }

        return messageRepository;
    }




    public void create(Message message) throws SQLException, ClassNotFoundException {
        if (message != null) {
            Connection connection = connectionToSQL();


            PreparedStatement preparedStatement = connection.prepareStatement("insert into message(id,sender_id,receiver_id,sender_username,receiver_username,message,created,updated)values " +
                    "(?::uuid,?::uuid,?::uuid,?,?,?,?,?)");
            preparedStatement.setString(1, message.getId().toString());
            preparedStatement.setString(2, message.getSenderId().toString());
            preparedStatement.setString(3, message.getReceiverId().toString());
            preparedStatement.setString(4, message.getSenderUsername());
            preparedStatement.setString(5, message.getReceiverUsername());
            preparedStatement.setString(6, message.getText());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(message.getCreated().toString()));
            preparedStatement.setTimestamp(8, Timestamp.valueOf(message.getUpdated().toString()));

            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    public void remove (UUID id) throws SQLException, ClassNotFoundException {
        if (id != null) {
            Connection connection = connectionToSQL();
            PreparedStatement preparedStatement = connection.prepareStatement("update message set is_deleted = true where id = ?::uuid");
            preparedStatement.setString(1, id.toString());
            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    public Message update(Message message) throws SQLException, ClassNotFoundException {
            Message updatedMessage = null;
        if (message != null){
            Connection connection = connectionToSQL();

            PreparedStatement preparedStatement = connection.prepareStatement("update message set sender_id = ?::uuid," +
                    "receiver_id = ?::uuid, sender_username = ?, receiver_username = ?,message = ?,updated = ?  where id = ?::uuid and is_deleted <> true;");
            LocalDateTime update = message.getUpdated();
            update = LocalDateTime.now();
            preparedStatement.setString(1,message.getSenderId().toString());
            preparedStatement.setString(2,message.getReceiverId().toString());
            preparedStatement.setString(3,message.getSenderUsername());
            preparedStatement.setString(4,message.getReceiverUsername());
            preparedStatement.setString(5,message.getText());
            preparedStatement.setTimestamp(6,Timestamp.valueOf(update));
            preparedStatement.setString(7,message.getId().toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                UUID senderId = UUID.fromString(resultSet.getString("sender_id"));
                UUID receiverID = UUID.fromString(resultSet.getString("receiver_id"));
                String senderUsername = resultSet.getString("sender_username");
                String receiverUsername = resultSet.getString("receiver_username");
                String text = resultSet.getString("message");
                updatedMessage = new Message(message.getId(),message.getCreated(),message.getUpdated(),senderId,receiverID,senderUsername,receiverUsername,text,false );

            }
        }
            return updatedMessage;
    }

    public List<Message> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = connectionToSQL();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from message where is_deleted <> true;");

        List<Message> messages = new ArrayList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            UUID id = UUID.fromString(resultSet.getString("id"));
            UUID sender_id = UUID.fromString(resultSet.getString("sender_id"));
            UUID receiver_id = UUID.fromString(resultSet.getString("receiver_id"));
            String senderUsername = resultSet.getString("sender_username");
            String receiverUsername = resultSet.getString("receiver_username");
            String message = resultSet.getString("message");
            boolean isDeleted = resultSet.getBoolean("is_deleted");
            LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
            LocalDateTime updated = resultSet.getTimestamp("updated").toLocalDateTime();
            messages.add(new Message(id,created,updated,sender_id,receiver_id,senderUsername,receiverUsername,message,isDeleted));
        }
        return messages;
    }



    private Connection connectionToSQL() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");


        Connection cOnnection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/telegram","postgres","123"
        );
        return cOnnection;
    }
}
