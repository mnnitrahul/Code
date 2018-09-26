package design.messagebroker1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MessageHandler {
	public void saveMsg(Message msg) {
		File file = new File(msg.getTopic().getTopicPath() + msg.getMsgId());	
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(msg.getMsg());
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMsg(Message msg) {
		File file = new File(msg.getTopic().getTopicPath() + msg.getMsgId());	
		System.out.println("deleting file " + file.getAbsolutePath());
		file.delete();
	}
}
