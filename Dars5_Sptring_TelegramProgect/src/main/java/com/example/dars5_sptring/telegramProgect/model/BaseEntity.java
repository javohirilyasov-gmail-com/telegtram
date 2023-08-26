package com.example.dars5_sptring.telegramProgect.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class BaseEntity {

    protected UUID id;
    protected LocalDateTime create;
    protected LocalDateTime update;


}
