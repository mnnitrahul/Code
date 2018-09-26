package code.array.simple;

import java.util.List;

/**
 * Created by rahul.ka on 18/09/16.
 */
public class BinarySearchRotatedArray {
    private int search(List<Integer> list, int num, int start, int end) {
        if (start > end) return -1;
        int mid = (end+start)/2;
        if (list.get(mid) == num) return mid;
//        System.out.println("start: " + start + " end: " + end + " mid: " + mid);
        int midValue = list.get(mid);
        if (midValue > list.get(0)) { // left side is sorted
            if (midValue > num) {
                return search(list, num, start, mid-1);
            }
            return search(list, num, mid+1, end);
        }       // right side is sorted
        if (midValue < num) {
            return search(list, num, mid+1, end);
        }
        return search(list, num, start, mid-1);
    }
    public int search2(final List<Integer> a, int b) {
        if (a == null || a.isEmpty()) {
            return -1;
        }
        return search(a, b, 0, a.size()-1);
    }

    public int search(final List<Integer> a, int b) {
        if (a == null || a.isEmpty()) {
            return -1;
        }
        int start = 0;
        int end = a.size() -1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (a.get(mid) == b) {
                res = mid;
                break;
            }
//        System.out.println("start: " + start + " end: " + end + " mid: " + mid);
            int midValue = a.get(mid);
            if (midValue > a.get(0)) { // left side is sorted
                if (midValue > b) {
                    end = mid-1;
                    continue;
                }
                start = mid+1;
                continue;
            }       // right side is sorted
            if (midValue < b) {
                start = mid+1;
                continue;
            }
            end = mid-1;
            continue;
        }
        return res;
    }
}
