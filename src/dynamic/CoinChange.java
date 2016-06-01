package dynamic;

/**
 * Created by rahul.ka on 10/05/16.
 */
public class CoinChange {

    int count( int S[], int m, int n ) {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is consturcted
        // in bottom up manner using the base case (n = 0)
        int table[] = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            table[i] = 0;
        }

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }



    public static void main(String[] args) {

        int arr[] = {1, 2, 3};
        CoinChange c = new CoinChange();
        System.out.println(c.count(arr, arr.length, 4));

    }
}
