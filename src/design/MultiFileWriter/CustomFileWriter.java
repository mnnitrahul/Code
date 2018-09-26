package MultiFileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * Created by rahul.ka on 05/05/16.
 */
public class CustomFileWriter {

    private File file;
    private BufferedWriter bw;
    private final Object MUTEX= new Object();

    public CustomFileWriter(String fileName) throws IOException {
        file = new File(fileName);
        synchronized (MUTEX) {
            if (!file.exists())
            {
                file.createNewFile();
            }
        }
        bw = new BufferedWriter(new java.io.FileWriter(fileName));
    }

    public  void write(String msg) throws IOException {
        synchronized (MUTEX) {
            long length = file.length();
            bw.write(length + " " + msg);
            bw.newLine();
            bw.flush();
        }
    }

    public void close() throws IOException {
        bw.close();
    }
}
