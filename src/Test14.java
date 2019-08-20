public class Test14 {

    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int times_3 = n / 3;
        if (n - times_3 * 3 == 1) {
            times_3--;
        }
        int times_2 = (n - times_3 * 3) / 2;
        return (int) (Math.pow(3, times_3) * Math.pow(2, times_2));

    }

    public static void main(String[] args) {
        new Test14().integerBreak2(7);
    }
    public int integerBreak2(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
        return dp[n];
    }
}
