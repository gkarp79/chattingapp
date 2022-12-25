package com.websocket.chattest.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;


import com.websocket.chattest.DTO.ChatDTO;
import com.websocket.chattest.Entity.Chat;
import com.websocket.chattest.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Log4j2
public class ChatService {

    //ObjectMapper JAVA 개체를 JSON으로 직렬화 또는 JSON문자열을 JAVA객체로 역직렬화
    private final DynamoDBMapper dynamoDBMapper;
    private DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.PUT);

    public List<ChatDTO> getMessage(String roomNum){
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(roomNum));
        DynamoDBScanExpression queryExpression = new DynamoDBScanExpression().withFilterExpression("roomNum = :val1").withExpressionAttributeValues(eav);

        return dynamoDBMapper.scan(Chat.class, queryExpression).stream().map(AppUtils::entityToDto).collect(Collectors.toList());

    }

    public void saveMessage(ChatDTO chatDTO){

        chatDTO.setCreatAt(LocalDateTime.now());

        dynamoDBMapper.save(AppUtils.dtoToEntity(chatDTO),dynamoDBMapperConfig);
    }


}
