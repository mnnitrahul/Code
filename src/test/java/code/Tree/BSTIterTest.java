package code.Tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rahul.ka on 23/09/16.
 */
public class BSTIterTest {

    @Test
    public void test1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        BSTIter tree = new BSTIter(n1);
        Assert.assertEquals(true, tree.hasNext());
        Assert.assertEquals(2, tree.next());
        Assert.assertEquals(true, tree.hasNext());
        Assert.assertEquals(1, tree.next());
        Assert.assertEquals(true, tree.hasNext());
        Assert.assertEquals(3, tree.next());
        Assert.assertEquals(false, tree.hasNext());


    }

    @Test
    public void test2() {
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
        BSTIter tree = new BSTIter(n4);
        System.out.print("left value: ");
        while (tree.hasNext()) {
            System.out.print(tree.next() + " ");
        }
        System.out.println();
        System.out.print("right value: ");
        while (tree.hasPrev()) {
            System.out.print(tree.prev() + " ");
        }
        System.out.println();

    }

}