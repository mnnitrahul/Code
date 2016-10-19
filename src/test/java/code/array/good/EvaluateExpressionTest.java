package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 18/10/16.
 */
public class EvaluateExpressionTest extends BaseTest{
    EvaluateExpression evaluateExpression = new EvaluateExpression();

    @Test
    public void cnttrue() throws Exception {
        int actualResult = evaluateExpression.cnttrue("T|F");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void cnttrue2() throws Exception {
        int actualResult = evaluateExpression.cnttrue("T|F&T");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }

    @Test
    public void cnttrue3() throws Exception {
        int actualResult = evaluateExpression.cnttrue("F^T&T");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }

    @Test
    public void cnttrue4() throws Exception {
        int actualResult = evaluateExpression.cnttrue("T^T^T^F|F&F^F|T^F^T");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(533, actualResult);
    }


}