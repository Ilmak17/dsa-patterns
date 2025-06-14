package patterns.dp;

public class Knapsack {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        for (int c = wt[0]; c <= W; c++) {
            dp[c] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                int taken = 0;
                if (j >= wt[i]) {
                    taken = val[i] + dp[j - wt[i]];
                }
                dp[j] = Math.max(dp[j], taken);
            }
        }

        return dp[W];
    }

    public int knapsackUnbounded(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        for (int c = wt[0]; c <= W; c++) {
            dp[c] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                int taken = 0;
                if (j >= wt[i]) {
                    taken = val[i] + dp[j - wt[i]];
                }
                dp[j] = Math.max(dp[j], taken);
            }
        }

        return dp[W];
    }
}
