package com.example.telegramProgect.service.message;

import com.example.telegramProgect.model.Message;
import com.example.telegramProgect.repository.message.MessageRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    private final MessageRepository messageRepository;


    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public void create(Message message) throws SQLException, ClassNotFoundException {
        messageRepository.create(message);
    }

    public void delete(UUID id) throws SQLException, ClassNotFoundException {
        messageRepository.remove(id);
    }

    public Message update(Message message) throws SQLException, ClassNotFoundException {
        return messageRepository.update(message);
    }

    public List<Message> getAll() throws SQLException, ClassNotFoundException {
        return messageRepository.getAll();
    }

}
