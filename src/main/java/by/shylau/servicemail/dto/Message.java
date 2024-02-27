package by.shylau.servicemail.dto;

import lombok.Data;

@Data
public class Message {
    private String address;
    private String subject;
    private String text;
}
