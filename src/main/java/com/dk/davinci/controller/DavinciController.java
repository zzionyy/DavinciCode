package com.dk.davinci.controller;

import com.dk.davinci.model.Command;
import com.dk.davinci.model.GameStatus;
import com.dk.davinci.model.dto.GameRoom;
import com.dk.davinci.model.dto.Message;
import com.dk.davinci.model.dto.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class DavinciController {
    private GameRoom gameRoom = null;
    private static final Map<String, WebSocketSession> sessionMap = new HashMap<>();
    private static final Gson gson = new Gson();


    public void addSession(WebSocketSession session) throws IOException {
        String sessionKey = session.getId();
        if (sessionMap.containsKey(sessionKey)) {
            return;
        }
        sessionMap.put(sessionKey, session);
        if (gameRoom == null) {
            gameRoom = new GameRoom();
            User host = new User(session.getId());
            gameRoom.setHost(host);
            gameRoom.setGameStatus(GameStatus.WAITING);
        } else {
            User guest = new User(session.getId());
            log.info("guest.getId {}", guest.getUserId());
            gameRoom.setGuest(guest);
            readyToStart();
        }
        log.info("gameRoom {}", gameRoom.toString());
    }


    private void readyToStart() throws IOException {
        log.info("readyToStart() called");
        if (gameRoom == null) return;


        User host = gameRoom.getHost();
        User guest = gameRoom.getGuest();

        WebSocketSession hostSession = sessionMap.get(host.getUserId());
        WebSocketSession guestSession = sessionMap.get(guest.getUserId());

        Message<Object> message1 = new Message<>(Command.READY, new Object());
        TextMessage textMessage1 = new TextMessage(gson.toJson(message1));
        hostSession.sendMessage(textMessage1);


        Message<Object> message2 = new Message<>(Command.WAITING, new Object());
        TextMessage textMessage2 = new TextMessage(gson.toJson(message2));
        guestSession.sendMessage(textMessage2);

    }

    public void gameStart() {
        log.info("gameStart {}", gameRoom.toString());
        if (gameRoom == null) return;

        Message<Object> message = new Message<>(Command.START, new Object());

    }


}
