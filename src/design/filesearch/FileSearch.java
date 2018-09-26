package design.filesearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSearch {
    RandomAccessFile file;

    long length;
    public FileSearch(String fileName) {
        File file = new File(fileName );
        if (file.exists() && file.canRead()) {
            try {
                this.file = new RandomAccessFile(file, "r");
            } catch (FileNotFoundException e) {
                throw new NullPointerException(("Invalid file"));
            }
        } else {
            throw new NullPointerException(("Invalid file"));
        }
        length = file.length();
        /**
         * Read complete file and create Index - start and end location.
         */
    }

    public void find(String word) {
    }
}
