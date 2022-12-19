package com.websocket.chattest.Repository;

import com.websocket.chattest.DTO.ChatDTO;
import com.websocket.chattest.Entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {


    @Query("{roomNum: ?0}")
    List<Chat> mFindByRoomNum(String roomNum);
}
