package com.example.telegramProgect.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Data()
@NoArgsConstructor()
@AllArgsConstructor()
@Getter
@Setter


public class Message extends BaseEntity {

    private UUID senderId;
    private UUID receiverId;
    private String senderUsername;
    private String receiverUsername;
    private String text;
    private boolean isDeleted;

    public Message(UUID id, LocalDateTime create, LocalDateTime update, UUID senderId, UUID receiverId, String senderUsername, String receiverUsername, String text, boolean isDeleted) {
        super(id, create, update);
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.text = text;
        this.isDeleted = isDeleted;
    }
}
