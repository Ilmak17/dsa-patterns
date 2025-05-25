package patterns.slidingwindow;

public class FixedWindow {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxSum = total;

        for (int i = 1; i <= k; i++) {
            total = total - cardPoints[k - i] + cardPoints[n - i];
            maxSum = Math.max(total, maxSum);
        }

        return maxSum;
    }
}
