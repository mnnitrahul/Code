package code.array.good;

import java.util.*;

/**
 * Created by rahul.ka on 17/10/16.
 * https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
 */
public class MaxRectangle {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {

        int max = Integer.MIN_VALUE;
        List<Integer> heights = createHeights(a.get(0).size());
        for (int i =0; i < a.size(); ++i) {
            List<Integer> arr = a.get(i);
            for (int j = 0; j < arr.size(); ++j) {
                if (arr.get(j) ==0) heights.set(j, 0);
                else heights.set(j, heights.get(j)+arr.get(j));
            }
            //System.out.println("height: " + heights);
            max = Math.max(max, area(heights));
        }
        return max;
    }

    private List<Integer> createHeights( int size) {
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i< size; ++i) {
            heights.add(0);
        }
        return heights;
    }

    private int area(List<Integer> heights) {
        List<Integer> left = getDist(heights);
        //System.out.println("left: " + left);
        Collections.reverse(heights);
        List<Integer> right = getDist(heights);
        Collections.reverse(heights);
        Collections.reverse(right);
        //System.out.println("right: " + right);
        int size = heights.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; ++i) {
            max = Math.max(max, (left.get(i)+right.get(i)-1)*heights.get(i));
        }
        //System.out.println("max: " + max);
        return max;
    }

    private List<Integer> getDist(List<Integer> heights) {
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        ArrayList<Integer> distances = new ArrayList<>();
        stack.push(new AbstractMap.SimpleEntry<Integer, Integer>(-1, -1));
        int pos = 0;
        for (int height: heights) {
            while (stack.peek().getValue() >= height) {
                stack.pop();
            }
            distances.add(pos-stack.peek().getKey());
            stack.push(new AbstractMap.SimpleEntry<Integer, Integer>(pos, height));
            pos++;
        }
        return distances;
    }
}
