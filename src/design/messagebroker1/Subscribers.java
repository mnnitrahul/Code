package design.messagebroker1;

public class Subscribers {
	private String threadId;
	private MsgQueueClient msgQueueClient;
	public Subscribers(int threadId, MsgQueue msgQueue) {		
		this.threadId = "reader" + threadId;
		this.msgQueueClient = new MsgQueueClient(msgQueue);
		System.out.println("\t \t \t \t \t \t \t Subscribers: creating subsciber " + threadId);
	}
	public void registerReader(String topic) {
		System.out.println("\t \t \t \t \t \t \t Subscribers: " + threadId + " is subcribing to topic " + topic);
		msgQueueClient.registerReader(topic, this);
	}
	
	public void readMsg(Message msg) {
		System.out.println("\t \t \t \t \t \t \t Subscribers: " + threadId + " Reads msg " + msg.getMsg() + " and msg id is " + msg.getMsgId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msgQueueClient.sendAck(msg);
	}
	
	public static void startReader(int count, MsgQueue msgQueue) throws InterruptedException {
		String topic = "topic";
		int j = 0;
		for (int i = 0;i < count; ++i) {
			if (i%4 ==0) {
				j++;
			}
			
			Subscribers subscriber = new Subscribers(i, msgQueue);
			subscriber.registerReader(topic+j);
		}
	}
}
