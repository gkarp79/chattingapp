package com.websocket.chattest.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.chattest.DTO.ChatDTO;
import com.websocket.chattest.Entity.Chat;
import com.websocket.chattest.Repository.ChatRepository;
import com.websocket.chattest.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Log4j2
public class ChatService {

    //ObjectMapper JAVA 개체를 JSON으로 직렬화 또는 JSON문자열을 JAVA객체로 역직렬화
    private final ObjectMapper objectMapper;

    private final ChatRepository chatRepository;

    public List<ChatDTO> getMessage(String roomNum){




        return chatRepository.mFindByRoomNum(roomNum).stream().map(AppUtils::entityToDto).collect(Collectors.toList());

    }

    public Chat saveMessage(ChatDTO chatDTO){
        chatDTO.setCreatAt(LocalDateTime.now());

        return chatRepository.save(AppUtils.dtoToEntity(chatDTO));
    }

    // 서버에 생성된 모든 채팅방의 정보를 모아둔 구조
//    private Map<String, ChatRoom> chatRooms;

//    @PostConstruct
//    private void init(){
//        // LinkedHashMap은 입력된 순서대로 Key가 보장
//        chatRooms = new LinkedHashMap<>();
//    }

    // 채팅방 조회 - 채팅방 Map에 담긴 정보를 조회




    // 채팅방 생성 - Random UUID로 구별 ID를 가진 채팅방 객체를 생성하고 채팅방 Map에 추가
//    public ChatRoom findRoomById(String roomId){
//        return chatRooms.get(roomId);
//    }


    // 메시지 발송 - 지정한 WebSocket 세션에 메시지를 발송
//    public ChatRoom createRoom(String name){
//        String randomId = UUID.randomUUID().toString();
//        ChatRoom chatRoom = ChatRoom.builder().
//                roomId(randomId)
//                .name(name)
//                .build();
//        chatRooms.put(randomId, chatRoom);
//        return chatRoom;
//    }
//
//    //<T> - 제네릭은 클래스/ 인터페이스 / 메서드 등의 타입을 파라미터로 사용할 수 있게 해주는 역할을 한다.
//    public <T> void sendMessage(WebSocketSession session, T message){
//        try{
//            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
//        }catch (IOException e){
//            log.error(e.getMessage(),e);
//        }
//    }
}
