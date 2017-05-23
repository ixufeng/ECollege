package com.xf.college.service.websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * socket 处理
 * Created by xufeng on 2017/5/18.
 */
@Service
public class CollegeWebSocketHandler implements WebSocketHandler {

    public static final Map<String, WebSocketSession> userSocketSessionMap;
    static {
        userSocketSessionMap = new HashMap<String, WebSocketSession>();
    }

    /**
     * 建立连接后
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userId = (String) session.getAttributes().get("userId");
        //save session
        userSocketSessionMap.putIfAbsent(userId, session);
    }

    /**
     * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        if (webSocketMessage.getPayloadLength() == 0){
            return;
        }
        String msg = webSocketMessage.getPayload().toString();
        SocketMessage message = new Gson().fromJson(msg,SocketMessage.class);
        message.setDate(new Date());
        sendMessageToUser(message.getToUserId(),new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(message)));
    }

    /**
     * 消息传输错误处理
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * 关闭连接后,移除map中存储的session
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        Iterator<Map.Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
        // 移除Socket会话
        while (it.hasNext()) {
            Map.Entry<String, WebSocketSession> entry = it.next();
            if (entry.getValue().getId().equals(webSocketSession.getId())) {
                userSocketSessionMap.remove(entry.getKey());
                System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
                break;
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给某个用户发送消息
     *
     * @param toUserId
     * @param message
     * @throws IOException
     */
    public void sendMessageToUser(String toUserId, TextMessage message)throws IOException {
        WebSocketSession session = userSocketSessionMap.get(toUserId);
        if (session != null && session.isOpen()) {
            session.sendMessage(message);
        }
    }
}
