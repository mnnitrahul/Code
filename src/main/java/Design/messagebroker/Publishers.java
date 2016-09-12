package messagebroker;

import java.util.Random;

public class Publishers implements Runnable{
	private String threadId;
	private MsgQueueClient msgQueueClient;
	private Random random ;
	private String topic;
	public Publishers(int threadId, MsgQueue msgQueue, String topic) {
		this.threadId = "writter" + threadId;
		this.topic = topic;
		this.msgQueueClient = new MsgQueueClient(msgQueue);
		random = new Random();
		System.out.println("Publishers: creating publisher " + threadId);
	}
	public void run() { 
		int count = 1;
		while (true) {
			String str= threadId + "-" + count++;
			System.out.println("Publishers: " + threadId + " sending msg " + str + " and topic is " + topic);
			msgQueueClient.sendMessage(topic, str);
			try {
				Integer sleep = random.nextInt(5000);
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void startWritter(int count, MsgQueue msgQueue) throws InterruptedException {
		Thread.sleep(1000);
		String topic = "topic";
		int j = 0;
		for (int i = 0;i < count; ++i) {
			if (i%3 ==0) {
				j++;
			}
			Publishers publisher = new Publishers(i, msgQueue, topic+j);
			Thread thread = new Thread(publisher);
			thread.start();
		}
	}
}
