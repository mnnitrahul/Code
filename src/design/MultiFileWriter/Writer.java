package MultiFileWriter;

import java.io.IOException;
import java.util.Random;

/**
 * Created by rahul.ka on 05/05/16.
 */
public class Writer implements Runnable {
    private String name;
    private CustomFileWriter fileWriter;

    public Writer(String name, CustomFileWriter fileWriter) {
        this.name = name;
        this.fileWriter = fileWriter;
    }

    public void write(String msg) throws IOException {
        fileWriter.write(name + "_" + msg);
    }

    public void run()  {
        Random random = new Random();
        for (Integer i = 0; i<5; ++i) {
            try {
                write(i.toString());
                Thread.sleep(random.nextInt(2000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
