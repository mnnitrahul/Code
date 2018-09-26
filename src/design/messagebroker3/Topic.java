package design.messagebroker3;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
    Broker broker;
    private String name;
    private Map<String, Queue> subscribers;
    public  Topic(Broker broker, String name) {
        this.broker = broker;
        this.name = name;
        subscribers = new HashMap<>();
    };

    public  void subscribe(String name) {
        subscribers.put(name, new Queue());

    }

    public  void unSubscribe(String name) {
        subscribers.remove(name);

    }

    public void sendMessage(Message message) {
        for(Map.Entry<String, Queue> entry : subscribers.entrySet()) {
            Queue queue = entry.getValue();
            queue.addMessage(message);
        }
    }

    public Message getMessage(String subscriberName) {
        return subscribers.get(subscriberName).getMessage();
    }

    public void ackMessage(String subscriberName, Message message) {
        subscribers.get(subscriberName).removeMessage(message);
    }
}
