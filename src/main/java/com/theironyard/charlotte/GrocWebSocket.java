package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@WebSocket
public class GrocWebSocket {
    // Store sessions if you want to, for example, broadcast a message to all users
    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();
    private static final List<Food> foodList = new ArrayList<>();


    @OnWebSocketConnect
    public void connected(Session session) throws IOException {
        sessions.add(session);

        broadcastFoods();
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void message(Session session, String message) throws IOException {
        Command c = new JsonParser().parse(message, Command.class);

        if (c.getCommand().equals("add-item")) {
            foodList.add(new Food(c.getName(), c.getQuantity()));
        }

        if (c.getCommand().equals("find-item")) {
            // find whatever the crap item luke is talking about
            // then update the "Found" field on the "food" to whatever "luke"
            for (Food f : foodList) {
                if (f.getId() == c.getFoodId()) {
                    f.setFound(c.isFound());
                    break;
                }
            }

            // wants to do.

        }

        broadcastFoods();
    }

    private void broadcastFoods() throws IOException {
        String jsonMessage = new JsonSerializer().serialize(foodList);

        System.out.println(jsonMessage);

        for (Session sess : sessions) {
            sess.getRemote().sendString(jsonMessage); // and send it back
        }
    }

}