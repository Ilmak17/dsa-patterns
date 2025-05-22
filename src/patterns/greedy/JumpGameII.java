package patterns.greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
