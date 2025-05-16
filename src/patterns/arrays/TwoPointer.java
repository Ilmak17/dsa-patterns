package patterns.arrays;

public class TwoPointer {

    public boolean isPalindromeNumber(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public int trappingRainWater(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int total = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return total;
    }
}
