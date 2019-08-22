public class Test42 {
    // 1,-2,3,10,-4,7,2,-5
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
                continue;
            }
            dp[i] = dp[i - 1] + nums[i];
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -10, 7, 2, -5};
        System.out.println(new Test42().FindGreatestSumOfSubArray(arr));

    }
}
