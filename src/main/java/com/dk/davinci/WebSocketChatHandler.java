package com.dk.davinci;

import com.dk.davinci.controller.DavinciController;
import com.dk.davinci.model.Command;
import com.dk.davinci.model.dto.Message;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Slf4j
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {


    private static final Gson gson = new Gson();
    @Autowired
    DavinciController davinciController = new DavinciController();

    //세션 연결
    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        Message<String> message = new Message<>(Command.CONNECTED, session.getId());
        TextMessage textMessage = new TextMessage(gson.toJson(message));
        session.sendMessage(textMessage);
        davinciController.addSession(session);

    }

    //세션 연결 해제
    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }

    @Override
    protected void handleTextMessage (@NonNull WebSocketSession session, TextMessage message) throws IOException {

        log.info("message {}", message);
        //json으로 온 파일을 역직렬화한다.
        Message payload = gson.fromJson(message.getPayload(), Message.class);
        log.info("payload {}", payload);

        switch (payload.getCommand()) {
            case READY -> {}
            case START -> davinciController.gameStart();
        }
//        TextMessage textMessage = switch (payload) {
//            case "game" -> new TextMessage("Welcome to our game!");
//            case "hi" -> new TextMessage("hello");
//            case "hello" -> new TextMessage("hi");
//            case "jiwon" -> new TextMessage("whoareyouhowcanyouknowmyname");
//            default -> new TextMessage("다빈치코드를 플레이하려면 'game'을 치세요.");
//        };
//        session.sendMessage(textMessage);

    }
}
