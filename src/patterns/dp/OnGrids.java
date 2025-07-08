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


}
