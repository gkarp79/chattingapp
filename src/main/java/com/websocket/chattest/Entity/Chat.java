package com.websocket.chattest.Entity;


import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Log4j2
@Document(collection = "chat")
public class Chat {

    @Id
    private String id;
    private String msg;
    private String sender;
    private String roomNum;
    private LocalDateTime creatAt;
}
