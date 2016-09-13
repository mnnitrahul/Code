package code.array.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 12/09/16.
 */
public class MinStepsInGridTest {

    private MinStepsInGrid minStepsInGrid = new MinStepsInGrid();
    private ArrayList<Integer> X;
    private ArrayList<Integer> Y;
    @Test
    public void testMinStepsInGrid() {
        X = new ArrayList(Arrays.asList(-2));
        Y = new ArrayList(Arrays.asList(7));
        assertEquals(0, minStepsInGrid.coverPoints(X, Y));
    }

    @Test
    public void testMinStepsInGrid2() {
        X = new ArrayList(Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8));
        Y = new ArrayList(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8));
        assertEquals(108, minStepsInGrid.coverPoints(X, Y));

    }

}