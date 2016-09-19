package code.array.good;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 17/09/16.
 */
public class PainterPartitionTest {
    @Rule
    public TestName name = new TestName();
    PainterPartition painterPartition = new PainterPartition();

    @Test
    public void paint1() throws Exception {
        int actualResult =  painterPartition.paint(2, 5, new ArrayList<>(Arrays.asList(1, 10)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(50, actualResult);
    }

    @Test
    public void paint2() throws Exception {
        int actualResult =  painterPartition.paint(2, 5, new ArrayList<>(Arrays.asList(10)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(50, actualResult);
    }

    @Test
    public void paint3() throws Exception {
        int actualResult =  painterPartition.paint(1, 5, new ArrayList<>(Arrays.asList(1, 10)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(55, actualResult);
    }

    @Test
    public void paint4() throws Exception {
        int actualResult =  painterPartition.paint(1, 5, new ArrayList<>(Arrays.asList(10)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(50, actualResult);
    }

    @Test
    public void paint5() throws Exception {
        int actualResult =  painterPartition.paint(3, 10, new ArrayList<>(Arrays.asList(640, 435, 647, 352, 8, 90, 960, 329, 859)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(17220, actualResult);
    }

    @Test
    public void paint6() throws Exception {
        int actualResult =  painterPartition.paint(6, 10, new ArrayList<>(Arrays.asList( 762, 798, 592, 899, 329)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(8990, actualResult);
    }

    @Test
    public void paint7() throws Exception {
        int actualResult =  painterPartition.paint(1, 1000000, new ArrayList<>(Arrays.asList(1000000, 1000000)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(9400003, actualResult);
    }

    @Test
    public void books1() throws Exception {
        int actualResult =  painterPartition.books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 2);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(113, actualResult);
    }

}