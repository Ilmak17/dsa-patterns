package patterns.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    // 1. Classic Fibonacci - Memoization
    public int fibMemo(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }

    private int dfs(int n, Map<Integer, Integer> memo) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int res = dfs(n - 1, memo) + dfs(n - 2, memo);
        memo.put(n, res);
        return res;
    }

    // 2. Classic Fibonacci - Bottom-up
    public int fibBottomUp(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 3. Classic Fibonacci - Space Optimized
    public int fibOptimized(int n) {
        if (n <= 1) return n;
        int prev1 = 1, prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }

    // 4. Climbing Stairs - Same as fib, but base is 1, 1
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int first = 1, second = 1;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    // 5. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    // 6. House Robber
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    // 7. Decode Ways
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string
        dp[1] = 1; // first digit is valid

        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));

            if (one >= 1) dp[i] += dp[i - 1];
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }
}
