package patterns.dp;

public class MCM {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int length = 2; length < n; length++) {
            for (int i = 1; i <= n - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }
}
