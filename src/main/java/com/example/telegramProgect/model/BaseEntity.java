package com.example.telegramProgect.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntity {

    protected UUID id;
    protected LocalDateTime created;
    protected LocalDateTime updated;

    {
        this.id = UUID.randomUUID();
        this.created = LocalDateTime.now();
        this.updated = created;
    }


}
