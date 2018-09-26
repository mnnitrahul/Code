package code.Tree;

import lombok.ToString;

/**
 * Created by rahul.ka on 22/09/16.
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "{val=" + val + '}';
    }
}
