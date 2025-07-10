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

}
