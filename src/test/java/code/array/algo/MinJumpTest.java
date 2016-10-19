package code.array.algo;

import code.BaseTest;
import code.array.common.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 16/10/16.
 */
public class MinJumpTest extends BaseTest{
    MinJump minJump = new MinJump();
    @Test
    public void jump() throws Exception {
        int actualResult = minJump.jump(new ArrayList<>(Arrays.asList(2,3,1,1,4)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }

}