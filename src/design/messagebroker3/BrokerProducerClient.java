package design.messagebroker3;

public class BrokerProducerClient {

    private Broker broker;

    public BrokerProducerClient(Broker broker) {
        this.broker = broker;
    }

    public Topic createTopic(String name) {
        return broker.createTopic(name);

    }

    public void sendMessage(Topic topic, String message) {
        topic.sendMessage(new Message(message));

    }

}
