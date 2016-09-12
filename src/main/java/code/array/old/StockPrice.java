package code.array.old;

import java.util.ArrayList;
import java.util.Arrays;


public class StockPrice {
	public StockPrice() {
	}
	public int maxGain(ArrayList<Integer> prices) {
		int max = 0;
		int localMax = 0;
		int min = prices.get(0);
		for (int price : prices) {
			if (price < min) {
				max += localMax;
				min = price;
				localMax = 0;
			} else {
				if (localMax < (price-min)) {
					localMax = price-min;
				}
			}
		}
		max += localMax;
		return max;
	}

	public static void main(String[] args) {
	//	Integer price[] = {100, 180, 260, 310, 40, 535, 695};
		Integer price[] = {100, 200, 50, 20};
		ArrayList<Integer> prices = new ArrayList<Integer>(Arrays.asList(price));
		StockPrice stockPrice = new StockPrice();
		int max = stockPrice.maxGain(prices);
		System.out.println("result is " + max);
	}
}	
