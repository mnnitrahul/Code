package MultiFileWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by rahul.ka on 05/05/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Writer[] writers = new Writer[5];
        Random random = new Random();
        Thread[] threads = new Thread[5];
        CustomFileWriter fileWriter = new CustomFileWriter("/tmp/rahul.txt");
        for (Integer i = 0;i<5; ++i) {
            writers[i] = new Writer(i.toString(), fileWriter);
            threads[i] = new Thread(writers[i]);
            threads[i].start();
        }
        for (Thread thread: threads) {
            thread.join();
        }
        BufferedReader reader = new BufferedReader(new FileReader("/tmp/rahul.txt"));
        reader.skip(167);
        System.out.println(reader.readLine());
    }
}
