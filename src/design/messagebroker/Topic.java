package design.messagebroker;

import java.io.File;

public final class Topic {
	String topicName;
	String topicPath;
	private static final String BASE_DIR = "/tmp/code/queue/";
	
	public Topic(String topicName) {
		File file = new File(BASE_DIR + topicName);
		if (!file.exists()) {
			file.mkdir();
		}
		this.topicPath = BASE_DIR + topicName + "/";
		this.topicName = topicName;
	}
	
	public String getTopicName() {
		return topicName;
	}
	
	public String getTopicPath() {
		return topicPath;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("topic Name is " + topicName);
		builder.append("topic Path is " + topicPath);
		return builder.toString();
	}
}
