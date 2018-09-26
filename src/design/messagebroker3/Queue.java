package design.messagebroker3;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Queue {
    java.util.Queue<Message> queue;
    java.util.Queue<Message> pendingQueue;

    public Queue() {
        this.queue = new ArrayDeque<>();
        pendingQueue = new PriorityQueue<>();
    }
    public void addMessage(Message message) {
        queue.add(message);
    }
    public void removeMessage(Message message) {
        pendingQueue.remove(message);
    }
    public Message getMessage() {
        Message message = queue.poll();
        if (message != null) {
            pendingQueue.add(message);
        }
        return message;
    }

}
