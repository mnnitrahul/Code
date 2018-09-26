package code.array.good;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/combination-sum/
 */

/**
 * Created by rahul.ka on 26/09/16.
 */
public class CombinationSum {


    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b, int index, ArrayList<Integer> result) {
//        System.out.println("sum: " + b + " index: " + index + " resultSet: " + result);
        if ((index == a.size() && b!=0)|| b <0) {
//            System.out.println("not found result: ");
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>>  list = new ArrayList<>();
        if (b == 0) {
            list.add(new ArrayList(result));
//            System.out.println("found result: " + result);
            return list;
        }
        ArrayList<ArrayList<Integer>> without = combinationSum(a, b, index+1, result);
//        System.out.println("without1: " + without ) ;
        result.add(a.get(index));
        ArrayList<ArrayList<Integer>> with = combinationSum(a, b-a.get(index), index, result);
//        System.out.println("with1: " +with);
        list.addAll(with);
        list.addAll(without);
        result.remove(result.size()-1);
//        System.out.println("without: " + without);
//        System.out.println("with: " + with);
//        System.out.println("returning  list: " + list);
        return list;
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        //a = new ArrayList<>(new HashSet<>(a));
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
