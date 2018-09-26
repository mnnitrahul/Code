package design.messagebroker3;

import java.util.UUID;

public class Message {
    String messageString;
    String messageId;

    public Message(String message) {
        messageString = message;
        messageId = UUID.randomUUID().toString();
    }
}
