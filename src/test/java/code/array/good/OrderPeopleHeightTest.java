package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 24/09/16.
 */
public class OrderPeopleHeightTest extends BaseTest{
    OrderPeopleHeight orderPeopleHeight = new OrderPeopleHeight();
    @Test
    public void order() throws Exception {
        List<Integer> actualResult = orderPeopleHeight.order(new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4)), new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        List<Integer> result = new ArrayList(Arrays.asList(5, 3, 2, 1, 6, 4));
        assertArrayEquals(result.toArray(), actualResult.toArray());

    }

}