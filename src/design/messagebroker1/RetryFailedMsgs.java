package design.messagebroker1;

import java.io.File;

public class RetryFailedMsgs {
	private Topic topic;
	public RetryFailedMsgs(Topic topic) {
		this.topic = topic;
	}
	public void retryMsgs() {
		File folder = new File(topic.getTopicPath());
		for (File file : folder.listFiles()) {
			long modifiedTime = file.lastModified();
			long currentTime = System.currentTimeMillis();
			if ((currentTime - modifiedTime) > 10000) {
				// lock file
				// send to All Subscribers
			}
		}
				
	}
}
