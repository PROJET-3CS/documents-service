package com.example.user_managment.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class DocumentDto {
    private Long userId;

    private Date date;

    private String text;
}
