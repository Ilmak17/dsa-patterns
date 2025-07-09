package patterns.dp;

public class OnGrids {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    tmp[j] = 1;
                    continue;
                }
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? tmp[j - 1] : 0;

                tmp[j] = up + left;
            }
            prev = tmp;
        }

        return prev[n - 1];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal = Integer.MAX_VALUE;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal = Integer.MAX_VALUE;
                }

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }

    public int minTriangleSum(int[][] triangle) {
        int n = triangle.length;
        int[] front = new int[n];

        int[] cur = new int[n];

        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];

                cur[j] = Math.min(down, diagonal);
            }
            front = cur.clone();
        }

        return front[0];
    }


}
