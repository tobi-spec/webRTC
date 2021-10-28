package de.tobias.signalingbackend;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessionList = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished( WebSocketSession session) throws Exception {
        sessionList.add(session);
    }

    @Override
    public void afterConnectionsClosed(WebSocketSession session, CloseStatus status){
        sessionList.remove(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
        throws InterruptedException,IOException {
            for (WebSocketSession webSocketSession: sessionList) {
                if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())){
                    webSocketSession.sendMessage(message);
                }
            }
        }

}
