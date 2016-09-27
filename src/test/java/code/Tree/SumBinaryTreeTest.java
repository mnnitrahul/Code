package code.Tree;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 23/09/16.
 */
public class SumBinaryTreeTest extends BaseTest{
    @Test
    public void t2SumTest() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        SumBinaryTree sumBinaryTree = new SumBinaryTree();
        assertEquals(1, sumBinaryTree.t2Sum(n4, 10));
        sumBinaryTree = new SumBinaryTree();
        assertEquals(1, sumBinaryTree.t2Sum(n4, 13));
        sumBinaryTree = new SumBinaryTree();
        assertEquals(1, sumBinaryTree.t2Sum(n4, 3));
        sumBinaryTree = new SumBinaryTree();
        assertEquals(0, sumBinaryTree.t2Sum(n4, 18));
    }

    @Test
    public void t2SumTest2() {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        SumBinaryTree sumBinaryTree = new SumBinaryTree();
        assertEquals(0, sumBinaryTree.t2Sum(n1, 40));


    }

}