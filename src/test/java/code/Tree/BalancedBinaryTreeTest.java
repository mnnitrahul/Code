package code.Tree;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 22/09/16.
 */
public class BalancedBinaryTreeTest extends BaseTest{
    BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

    @Test
    public void isBalanced() throws Exception {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t4.right = t5;
        int actualResult = balancedBinaryTree.isBalanced(t1);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);

    }

}