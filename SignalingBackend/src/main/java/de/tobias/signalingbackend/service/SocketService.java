package de.tobias.signalingbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SocketService extends TextWebSocketHandler {

    List<WebSocketSession> sessionList = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
        throws InterruptedException,IOException {
            for (WebSocketSession webSocketSession: sessionList) {
                if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())){
                    webSocketSession.sendMessage(message);
                }
            }
        }

        @Override
    public void afterConnectionEstablished( WebSocketSession session) throws Exception {
        sessionList.add(session);
    }

}
