package messagebroker2;

public class MsgQueueClient {
	private MsgQueue queue;
	private Subscribers queueReader;
	public MsgQueueClient(String credetial) {
		queue = new MsgQueue();
	}
	public MsgQueueClient(MsgQueue ampQueue) {
		this.queue = ampQueue;
	}
	
	public void sendMessage(String topic, String message) {
		queue.sendMessage(topic, message);
	}

	public void registerReader(String topic, Subscribers queueReader) {
		this.queueReader = queueReader;
		queue.subscribeReader(topic, this);
		
	}
	public void readMsg(Message msg) {
		queueReader.readMsg(msg);
	}
	public void sendAck(Message msg) {
		queue.sendAck(msg);
	}
}
