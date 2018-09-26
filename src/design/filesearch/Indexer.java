package design.filesearch;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Indexer {
    public static final int LIMIT = 1000;
    Map<String, Long> index;
    public Indexer() {
        index = new HashMap<>();
    }
    public void index(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String last = "";
            long loc = 0;
            while (true) {
                char[] data = new char[LIMIT];

                int noOfChars = in.read(data);
                if (noOfChars < 0) {
                    return;
                }
                String wordString = last + data;
                String[] words = wordString.split(" ");
                List<String> wordsList = new ArrayList<>(Arrays.asList(words));
                if (noOfChars == LIMIT) {
                    last = wordsList.get(wordsList.size()-1);
                    wordsList.remove(wordsList.size()-1);
                }
                for (String word : wordsList) {
                    String prefix = word.substring(0,2);
                    if (!index.containsKey(prefix)) {
                        index.put(prefix, loc);
                    }
                    loc = loc+word.length()+1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Long> entry : index.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
