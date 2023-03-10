package com.websocket.chattest;

import com.websocket.chattest.config.StreamLambdaHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatTestApplication.class, args);
    }

}
