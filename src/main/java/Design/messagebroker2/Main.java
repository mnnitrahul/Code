package messagebroker2;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main: starting queue");
		MsgQueue queue = new MsgQueue();
		System.out.println("Main: creating topic1");
		queue.createTopic("topic1");
		System.out.println("Main: creating topic2");
		queue.createTopic("topic2");
		System.out.println("Main: Creating readers");
		Subscribers.startReader(5, queue);
		System.out.println("Main: Creating writters");
		Publishers.startWritter(5, queue);
		
		
	}
}
