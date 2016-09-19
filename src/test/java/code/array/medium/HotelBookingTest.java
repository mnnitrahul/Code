package code.array.medium;

import code.array.medium.HotelBooking;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 15/09/16.
 */
public class HotelBookingTest {
    @Rule
    public TestName name = new TestName();
    HotelBooking hotelBooking = new HotelBooking();

    @Test
    public void test1() {
        ArrayList<Integer> arrivals = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> departures = new ArrayList<>(Arrays.asList(2, 6, 8));
        boolean actualResult = hotelBooking.hotel(arrivals, departures, 1);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(false, actualResult);
    }

    @Test
    public void test2() {
        ArrayList<Integer> arrivals = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> departures = new ArrayList<>(Arrays.asList(2, 3, 4));
        boolean actualResult = hotelBooking.hotel(arrivals, departures, 1);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(true, actualResult);
    }

}