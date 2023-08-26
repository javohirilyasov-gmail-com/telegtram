package com.example.dars5_sptring.telegramProgect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message extends BaseEntity {

    private UUID senderId;
    private UUID receiverId;
    private String senderName;
    private String receiverName;
    private String text;
    private boolean isDeleted;


}
