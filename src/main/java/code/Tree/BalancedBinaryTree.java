package code.Tree;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

/**
 * Created by rahul.ka on 22/09/16.
 */
public class BalancedBinaryTree {

    private Map.Entry<Integer, Integer> balanced(TreeNode a) {
        if (a == null) {
            return new AbstractMap.SimpleEntry(1, 0);
        }
        Map.Entry<Integer, Integer> left = balanced(a.left);
        Map.Entry<Integer, Integer> right = balanced(a.right);
        Integer height = Math.max(left.getValue(), right.getValue()) + 1;
        Integer isBalanced = 1;
        if (left.getKey() == 0 || right.getKey() == 0 || Math.abs(left.getValue()-right.getValue()) > 1) {
            isBalanced = 0;
        }
        return new AbstractMap.SimpleEntry<Integer, Integer>(isBalanced, height);

    }

    public int isBalanced(TreeNode a) {
        return balanced(a).getKey();
    }
}
