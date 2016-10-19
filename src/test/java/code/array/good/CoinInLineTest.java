package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 18/10/16.
 */
public class CoinInLineTest extends BaseTest{

    CoinInLine coinInLine = new CoinInLine();

    @Test
    public void maxcoin() throws Exception {
        int actualResult = coinInLine.maxcoin(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(6, actualResult);
    }

}