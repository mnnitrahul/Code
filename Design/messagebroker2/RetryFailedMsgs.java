package messagebroker2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetryFailedMsgs {
	private Topic topic;
	private Map<Integer, Integer> msgCount;
	public RetryFailedMsgs(Topic topic, Map<Integer, Integer> msgCount) {
		this.topic = topic;
		this.msgCount = new HashMap<Integer, Integer>(msgCount); 
	}
	
	public void retryMsgs(List<MsgQueueClient> readers) {
		File folder = new File(topic.getTopicPath());
		for (File file : folder.listFiles()) {
			long modifiedTime = file.lastModified();
			long currentTime = System.currentTimeMillis();
			if ((currentTime - modifiedTime) > 10000) {
				List<String> data = new ArrayList<String>();
				try {
					data = Files.readAllLines(Paths.get(file.getAbsolutePath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int id = Integer.parseInt(file.getName());
				Integer count = readers.size();
				msgCount.put(id, count);
				Message message = new Message(topic, data.get(0), id);
				for (MsgQueueClient reader : readers) {
					reader.readMsg( message);
				}
			}
		}
				
	}
}
