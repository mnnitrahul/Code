package code.dp;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 16/10/16.
 */
public class ArrangeHorseTest extends BaseTest{

    ArrangeHorse arrangeHorse = new ArrangeHorse();

    @Test
    public void arrange1() throws Exception {
        int actualResult = arrangeHorse.arrange("WWWB", 2);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void arrange2() throws Exception {
        int actualResult = arrangeHorse.arrange("BWWWWBBWWBWBWWBBBBBWBWWBBBWWWWBBBW", 28);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

}