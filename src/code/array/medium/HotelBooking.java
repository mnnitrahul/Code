package code.array.medium;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
/**
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 * Custom sort
 */

/**
 * Created by rahul.ka on 15/09/16.
 */
public class HotelBooking {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int max = 0;
        List<Map.Entry<Integer, Boolean>> entries = new ArrayList<>();
        for (Integer i : arrive) {
            entries.add(new AbstractMap.SimpleEntry<Integer, Boolean>(i, true));
        }
        for (Integer i : depart) {
            entries.add(new AbstractMap.SimpleEntry<Integer, Boolean>(i, false));
        }
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Boolean>>() {
            @Override
            public int compare(Map.Entry<Integer, Boolean> o1, Map.Entry<Integer, Boolean> o2) {
                if (o1.getKey().equals(o2.getKey())) {
                    if(o1.getValue().equals(false)) return -1;
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry<Integer, Boolean> order: entries) {
            if (order.getValue()) {
                max++;
                if (max > K) {
                    return false;
                }
            } else {
                max--;
            }
        }
        return true;
    }
}
