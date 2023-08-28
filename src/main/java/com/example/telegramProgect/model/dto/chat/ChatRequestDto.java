package com.example.telegramProgect.model.dto.chat;


import com.example.telegramProgect.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequestDto extends Message {

    private UUID id;
    private UUID receiverId;
    private String senderUsername;
    private String receiverUsername;
    private String receiverPhoneNumber;


}
