public class Test46 {


    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1; //将递归法的结束条件初始化为 1
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;

        }
        return dp[0];
    }



    public static void main(String[] args) {
        System.out.println(new Test46().numDecodings("6165812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
        System.out.println(new Test46().numDecodings("1065"));
        System.out.println(new Test46().numDecodings("01"));
        System.out.println(new Test46().numDecodings("00"));
        System.out.println(new Test46().numDecodings("0"));
        System.out.println(new Test46().numDecodings("10"));
    }


}
