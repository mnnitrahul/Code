package code.array.good;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 21/09/16.
 */
public class LruTest extends BaseTest{

    @Test
    public void test1() {
        Lru s = new Lru(2);
        s.set(1, 10);
        s.set(5, 12);
        assertEquals(12, s.get(5));//        returns 12
        assertEquals(10, s.get(1));//        returns 10
        assertEquals(-1, s.get(10));//       returns -1
        s.set(6, 14);//    this pushes out key = 5 as LRU is full.
        assertEquals(-1, s.get(5));//
        //System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
    }

    @Test
    public void test2() {
        Lru s = new Lru(1);
        s.set(1, 10);
        s.set(5, 12);
        assertEquals(12, s.get(5));//        returns 12
        assertEquals(-1, s.get(1));//        returns 10
        assertEquals(-1, s.get(10));//       returns -1
        //System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
    }

    @Test
    public void test3() {
        Lru s = new Lru(4);
        s.set(5, 13);  //5->13
        s.set(9, 6);   //5->13, 9->6
        s.set(4, 1);   //5->13, 9->6, 4->1
        assertEquals(1, s.get(4)); //5->13, 9->6, 4->1
        s.set(6, 1);  //5->13, 9->6, 4->1 6->1
        s.set(8, 11);  //9->6, 4->1 6->1 8->11
        assertEquals(-1, s.get(13));//1
        assertEquals(-1, s.get(1));//2
        s.set(12, 12); //4->1 6->1 8->11 12->12
        assertEquals(-1, s.get(10));//3
        s.set(15, 13); //6->1 8->11 12->12 15->13
        s.set(2, 13); //8->11 12->12 15->13 2->13
        s.set(7, 5);  //12->12 15->13 2->13 7->5
        s.set(10, 3);  //15->13 2->13 7->5 10->3
        assertEquals(-1, s.get(6));//4
    }

    @Test
    public void test4() {
        Lru s = new Lru(1);
        s.set(2, 1);  //2->1
        s.set(2, 2);   //2->2
        assertEquals(2, s.get(2));   //2->2
        s.set(1, 1); //1->1
        s.set(4, 1); //4->1
        assertEquals(-1, s.get(2));
    }


}