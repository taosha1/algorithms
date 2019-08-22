public class Test47 {

    public int getMost(int[][] values) {
        if (values == null || values.length < 1 || values[0].length < 1) {
            return 0;
        }
        int[][] dp= new int[values.length][values[0].length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = values[i][j];
                    }else {
                        dp[i][j] = dp[i][j-1] + values[i][j];
                    }

                } else if (j == 0) {
                    if (i > 0) {
                        dp[i][j] = dp[i-1][j] + values[i][j];
                    }
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];

                }
            }
        }
        return dp[values.length - 1][dp[0].length - 1];

    }
}
