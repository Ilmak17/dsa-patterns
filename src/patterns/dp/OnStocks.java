package patterns.dp;

public class OnStocks {

    public int stockBuySell(int[] arr, int n) {
        int min = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            profit = Math.max(profit, arr[i] - min);
            min = Math.min(arr[i], min);
        }

        return profit;
    }



}
