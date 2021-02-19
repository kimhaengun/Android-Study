package com.example.myapplication8;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Integer id;
    private String user;
    private String content;
    private String time;
}
