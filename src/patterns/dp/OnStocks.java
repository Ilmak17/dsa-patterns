package patterns.dp;

public class OnStocks {

    public int stockBuySell1(int[] arr, int n) {
        int min = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            profit = Math.max(profit, arr[i] - min);
            min = Math.min(arr[i], min);
        }

        return profit;
    }

    private int func(int[] arr, int n) {
        int[] ahead = new int[2];
        int[] cur = new int[2];

        ahead[0] = ahead[1] = 0;

        int profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max(0 + ahead[0], (-1)*arr[ind] + ahead[1]);
                }
                if (buy == 1) {
                    profit = Math.max(0 + ahead[1], arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }
            ahead = cur;
        }

        return cur[0];
    }

    public int stockBuySell2(int[] arr, int n){
        return func(arr, n);
    }

    private int func2(int[] arr, int n) {
        /* Declaring a 3D DP array of
        size [n+1][2][3] initialized to 0*/
        int[][][] dp = new int[n + 1][2][3];

        /* Base case: dp array is already i
        nitialized to 0, covering the base case.*/

        // Iterate backwards through the prices array
        for (int ind = n - 1; ind >= 0; ind--) {

            // buy can be 0 (buying) or 1 (selling)
            for (int buy = 0; buy <= 1; buy++) {

                /* cap represents the number of
                transactions completed (can be 1 or 2)*/
                for (int cap = 1; cap <= 2; cap++) {
                    // We can buy the stock
                    if (buy == 0) {
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                (-1)*arr[ind] + dp[ind + 1][1][cap]);
                    }
                    // We can sell the stock
                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                arr[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        /* The result is stored in dp[0][0][2] which
        represents maximum profit after the final transaction.*/
        return dp[0][0][2];
    }

    // Function to find the maximum profit
    public int stockBuySell3(int[] arr, int n) {
        // Return the answer
        return func2(arr, n);
    }

}
