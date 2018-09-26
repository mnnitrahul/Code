package code.array.simple;

/**
 * https://www.interviewbit.com/problems/equal/
 */

import java.util.*;

/**
 * Created by rahul.ka on 27/09/16.
 */
public class Equal4Variable {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        Map<Integer, List<Map.Entry<Integer, Integer>>> map = new HashMap<>();
        for (int i = 0; i<a.size()-1; ++i) {
            for (int j = i+1; j< a.size(); ++j) {
                int sum = a.get(i)+a.get(j);
                List<Map.Entry<Integer, Integer>> value = map.get(sum);
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(new AbstractMap.SimpleEntry(i, j));
                map.put(sum, value);
            }
        }

        for (int i = 0; i<a.size()-1; ++i) {
            for (int j = i+1; j< a.size(); ++j) {
                int sum = a.get(i)+a.get(j);
                List<Map.Entry<Integer, Integer>> value = map.get(sum);
                if (value.size()>1) {
                    for (int index = 1; index < value.size();++index) {
                        Map.Entry<Integer, Integer> entry = value.get(index);
                        if (entry.getKey() != i && entry.getKey() != j && entry.getValue() != i && entry.getValue() != j) {
                            return new ArrayList<>(Arrays.asList(i, j, entry.getKey(), entry.getValue()));
                        }
                    }

                }
            }
        }
        return new ArrayList<>();
    }
}
