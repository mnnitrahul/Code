package code.Tree;

/**
 * https://www.interviewbit.com/problems/2-sum-binary-tree/
 * Assume all element are different
 */

/**
 * Created by rahul.ka on 23/09/16.
 */
public class SumBinaryTree {

    public int t2Sum(TreeNode A, int B) {
        BSTIter s = new BSTIter(A);
        int left = s.next();
        int right = s.prev();
        int sum = left+right;
        if (sum == B) {
            //System.out.println("left: " + left + " right: " + right);
            return 1;
        }
        while (s.hasNext() || s.hasPrev()) {
            if (sum > B) {
                if (!s.hasPrev()) {
                    return 0;
                }
                right = s.prev();
                if (left == right) {    // Assumption that all elements are different
                    if (!s.hasPrev()) {
                        return 0;
                    }
                    right = s.prev();
                }

            }
            if (sum < B) {
                if (!s.hasNext()) {
                    return 0;
                }
                left = s.next();
                if (left == right) {
                    if (!s.hasNext()) {
                        return 0;
                    }
                    left = s.next();
                }
            }
            sum = left + right;
            if (sum == B) {
                //System.out.println("left: " + left + " right: " + right);
                return 1;
            }
        }
        return 0;
    }
}
