package design.messagebroker;

public final class Message {
	private String msg;
	private int msgId;
	private Topic topic;
	public Message(Topic topic, String msg, int msgId) {
		this.topic = topic;
		this.msg = msg;
		this.msgId = msgId;
	}
	public String getMsg() {
		return msg;
	}
	public int getMsgId() {
		return msgId;
	}
	public Topic getTopic() {
		return topic;
	}
	@Override 
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("topic is " + topic.getTopicName());
		builder.append(" msg is " + msg);
		builder.append(" msgId is " + msgId); 
		return builder.toString();
	}
}
