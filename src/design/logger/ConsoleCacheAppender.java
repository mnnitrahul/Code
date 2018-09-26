package design.logger;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsoleCacheAppender implements ILoggerAppender{
    private LogLevel level;
    private BlockingQueue<String> queue;
    private Thread consumeThread = null;
    protected ConsoleCacheAppender(String level) {
        if (level != null) {
            this.level = LogLevel.valueOf(level);
        }
        queue = new ArrayBlockingQueue<String>(100);
        consumeThread = new Thread(consume);
        consumeThread.start();
    }
    @Override
    public void log(LogLevel logLevel, String message) {
        if (level.getLevel() <= logLevel.getLevel()) {
            try {
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Runnable consume = () -> {
        String msg;
        try {
            while((msg = queue.take()) !="exit"){
                Thread.sleep(10);
                System.out.println("Consumed "+msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}
