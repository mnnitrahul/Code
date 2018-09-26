package design.filesearch;

import java.io.IOException;

public class Searcher {
    public static void main(String[] args) throws IOException {
        Indexer indexer = new Indexer();
        indexer.index("/Users/agarwalr/Downloads/index.txt");
    }
}
