package com.websocket.chattest.utils;

import com.websocket.chattest.DTO.ChatDTO;
import com.websocket.chattest.Entity.Chat;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ChatDTO entityToDto(Chat chat){
        ChatDTO chatDTO = new ChatDTO();
        BeanUtils.copyProperties(chat, chatDTO);
        return chatDTO;
    }

    public static Chat dtoToEntity(ChatDTO chatDTO){
        Chat chat = new Chat();
        BeanUtils.copyProperties(chatDTO, chat);
        return chat;
    }
}
