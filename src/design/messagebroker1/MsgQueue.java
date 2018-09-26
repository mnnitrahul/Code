package design.messagebroker1;

import java.util.*;

/**
 * 
 * @author agarwalr
 */

public class MsgQueue {
	private Map<Topic, List<MsgQueueClient>> publishersMap;
	private MessageHandler messageHandler;
	private Map<String, Topic> topicsMap;
	private Map<Integer, Integer> msgCount;
	private int msgIdCounter ;
	private final Object MUTEX= new Object();
	
	public MsgQueue() {
		publishersMap = new HashMap<Topic, List<MsgQueueClient>>();
		msgCount = new HashMap<Integer, Integer>();
		msgIdCounter = 0;
		messageHandler = new MessageHandler();
		topicsMap = new HashMap<String, Topic>();
	}
	
	private synchronized int generateMessageId() {
		msgIdCounter++;
		return msgIdCounter;
	}
	
	public void createTopic(String topicName) {
		synchronized (topicName) {
			Topic topic = new Topic(topicName);
			List<MsgQueueClient> list = new LinkedList<MsgQueueClient>();
			topicsMap.put(topicName, topic);
			publishersMap.put(topic, list);
		}
	}
	
	public void subscribeReader(String topicName, MsgQueueClient reader) {
		synchronized (topicName) {
			Topic topic = topicsMap.get(topicName);
			System.out.println("\t \t \t \t Queue: subcribing reader for topic " + topicName);
			List<MsgQueueClient> readers = publishersMap.get(topic);
			readers.add(reader);		
		}
	}
	
	public void sendMessage(String topicName, String message)  {
		int msgId = generateMessageId();
		List<MsgQueueClient> readersList = null;
		Topic topic = null;
		synchronized (topicName) {
			topic = topicsMap.get(topicName);
			readersList = new ArrayList<MsgQueueClient>(publishersMap.get(topic));		
		}
		if (readersList == null || readersList.isEmpty() || topic == null) {
			return;
		}
		System.out.println("Queue: recieve request to send msg. Msg id is " + msgId);
		Message m = new Message(topic, message, msgId);
		System.out.println("Queue: saving msg");
		messageHandler.saveMsg(m);
		
		synchronized (MUTEX) {
			msgCount.put(msgId, readersList.size());
		}
		notifyAllReaders(m);
		
	}
	
	private void notifyAllReaders(Message msg) {
		List<MsgQueueClient> readersLocal = null;
		synchronized (msg.getTopic()) {
			readersLocal = new ArrayList<MsgQueueClient>(publishersMap.get(msg.getTopic()));
		}
		for (MsgQueueClient reader : readersLocal) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					reader.readMsg(msg);
				}
			});
			thread.start();
		}
		
	}
	
	public void sendAck(Message msg) {
		synchronized (MUTEX) {
			int count = msgCount.get(msg.getMsgId());
			count--;
			if (count > 0) {
				msgCount.put(msg.getMsgId(), count);
				System.out.println("msg count is " + count);
			} else {
				messageHandler.deleteMsg(msg);
			}
			
		}
	}
	
	
	
}
