package java8.streams.aggregatingstreams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {
    public static void main(String args[]) {

        System.out.println("Creating list");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            strings.add("Item " + i);
        }

        strings.stream()
                .forEach(str -> System.out.println(str));

        // parallel
        strings.stream()
                .parallel()
                .forEach(str -> System.out.println(str));
    }

}