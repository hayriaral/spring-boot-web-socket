package com.example.messagingstompwebsocket;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public GreetingService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        simpMessagingTemplate.convertAndSend("/topic/greetings",
                new Greeting("WebSocket test"));
    }
}