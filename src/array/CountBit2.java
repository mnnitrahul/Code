package array;

/**
 * Created by rahul.ka on 03/05/16.
 */
public class CountBit2 {
    private int leftmost(int num) {
        int res = 0;
        num = num>>1;
        while(num > 0) {
            num = num>>1;
            res++;
        }
        return res;
    }
    private int pow2(int n) {
        return n*(1<<(n-1)) + 1;
    }
    public int countBit(int num) {
        int sum = 0;
        while (num > 0) {
            int n = leftmost(num);
            sum += pow2(n);
            num -= 1<<n;
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountBit2 bit2 = new CountBit2();
        System.out.println("ans is " + bit2.countBit(0));
    }
}
