package code.array.good;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rahul.ka on 16/10/16.
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
 * Can try c++ solution also
 */
public class MaxProfitWithLimit {
    public int maxProfit(final List<Integer> a) {
        if (a.isEmpty()) return 0;
        List<Integer> minFromStart = new ArrayList<>();
        List<Integer> maxFromEnd = new ArrayList<>();
        List<Integer> buy = new ArrayList<>();
        List<Integer> sell = new ArrayList<>();
        int min = a.get(0);
        int max = a.get(a.size()-1);
        for (int i=0; i < a.size(); ++i) {
            min = Math.min(min, a.get(i));
            minFromStart.add(min);
        }
        //System.out.println("min array: " + minFromStart);
        for (int i = a.size()-1; i >= 0; --i) {
            max = Math.max(max, a.get(i));
            maxFromEnd.add(max);
        }
        Collections.reverse(maxFromEnd);
        //System.out.println("max array: " + maxFromEnd);

        int profit = 0;
        buy.add(profit);// dummy value for  last value
        for (int i = a.size()-2; i >= 0; --i) {
            profit = Math.max(profit, (maxFromEnd.get(i)-a.get(i)));
            buy.add(profit);
        }
        Collections.reverse(buy);
        //System.out.println("buy : " + buy);

        profit = 0;
        sell.add(profit); // dummy value for start
        for (int i = 1; i < a.size(); ++i) {
            profit = Math.max(profit, (a.get(i)-minFromStart.get(i)));
            sell.add(profit);
        }
        //System.out.println("sell: " + sell);

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); ++i) {
            result = Math.max(result, buy.get(i) + sell.get(i));
        }
        return result;
    }
}
