package design.messagebroker3;

public class BrokerConsumerClient {

    private Broker broker;
    private Topic topic;
    private String name;
    public BrokerConsumerClient(Broker broker, Topic topic, String name) {
        this.broker = broker;
        this.topic = topic;
        this.name = name;
        topic.subscribe(name);
    }

    public Message receiveMessage() {
        return topic.getMessage(name);
    }

    public void ackMessage(Message message) {
        topic.ackMessage(name, message);
    }

}
