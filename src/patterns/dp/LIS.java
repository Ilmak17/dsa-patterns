package patterns.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public int lis(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                temp.set(ind, nums[i]);
            }
        }

        return temp.size();
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        return maxLength;
    }
}
