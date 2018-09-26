package design.messagebroker3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker {

    private Map<String, Topic> topicMap;

    public Broker() {
        topicMap = new HashMap<>();

    }

    public Topic createTopic(String name) {
        Topic topic = new Topic(this, name);
        topicMap.put(name, topic);
        return topic;
    }
}
