package com.websocket.chattest.config;

//import com.websocket.chattest.Handler.WebSocketChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration

@EnableWebSocketMessageBroker
//=========================1차 채팅===================
//@EnableWebSocket //웹 소켓 활성화
//@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //구독(우체통)하는 요청의 prefix로 /sub로 시작하도록 설정합니다.
        config.enableSimpleBroker("/sub");
        // 메시지를 발행(집배원)하는 요청의 prefix는 /pub로 시작하도록 설정
        config.setApplicationDestinationPrefixes("/pub");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //연결 endpoint는 /ws-stomp로 설정
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*").withSockJS();
    }
    // ========================================1차 채팅=============================
//    private final WebSocketHandler webSocketHandler;







//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        // WebSocketChatHandler를 이용하여 WebSocket 활성화하기 위한 Config파일을 작성합니다.
//        //"/ws/chat"은 Websocket에 접속하기 위한 endpoint
//        //"setAllowedOrigins는 CORS: 도메인이 다른 서버에서도 접속 가능하도록 설정
//        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
//    }
}
