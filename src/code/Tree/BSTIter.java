package code.Tree;

import java.util.Stack;
/**
 * https://www.interviewbit.com/problems/bst-iterator/
 */

/**
 * Created by rahul.ka on 23/09/16.
 */
public class BSTIter {

    private Stack<TreeNode> s = new Stack<>();
    private Stack<TreeNode> sRight = new Stack<>();
    private TreeNode lRoot;
    private TreeNode rRoot;

    public BSTIter(TreeNode root) {
        lRoot = root;
        rRoot = root;
        addAll(lRoot);
        addAllRight(rRoot);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
        //System.out.println("stack is " + s);
        TreeNode node = s.pop();
        addAll(node.right);
        return node.val;

    }

    public boolean hasPrev() {
        return !sRight.empty();
    }

    public int prev() {
       // System.out.println("stack is " + sRight);
        TreeNode node = sRight.pop();
        addAllRight(node.left);
        return node.val;
    }

    private void addAll(TreeNode node) {
        while (node != null) {
            s.add(node);
            node = node.left;
        }
    }

    private void addAllRight(TreeNode node) {
        while (node != null) {
            sRight.add(node);
            node = node.right;
        }
    }

}
