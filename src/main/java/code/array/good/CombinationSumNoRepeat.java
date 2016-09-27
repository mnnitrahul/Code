package code.array.good;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * https://www.interviewbit.com/problems/combination-sum-ii/
 */

/**
 * Created by rahul.ka on 26/09/16.
 */
public class CombinationSumNoRepeat {


    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b, int index, ArrayList<Integer> result) {
        if ((index == a.size() && b!=0)|| b <0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>>  list = new ArrayList<>();
        if (b == 0) {
            list.add(new ArrayList(result));
            return list;
        }
        ArrayList<ArrayList<Integer>> without = combinationSum(a, b, index+1, result);
        result.add(a.get(index));
        ArrayList<ArrayList<Integer>> with = combinationSum(a, b-a.get(index), index+1, result);
        list.addAll(with);
        list.addAll(without);
        result.remove(result.size()-1);
        return list;
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = combinationSum(a, b, 0, new ArrayList<>());
        result = new ArrayList<>(new LinkedHashSet<>(result));
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int index = 0;
                while (index < o1.size() && index < o2.size()) {
                    if (o1.get(index) < o2.get(index)) {
                        return -1;
                    }
                    if (o1.get(index) > o2.get(index)) {
                        return 1;
                    }
                    index++;
                }
                return 0;
            }
        });
        return result;
    }
}
