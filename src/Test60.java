//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class Test60 {
//
//
//    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
//        final int face = 6;
//        final int pointNum = face * n;
//        long[][] dp = new long[n + 1][pointNum + 1];
//
//        for (int i = 1; i <= face; i++)
//            dp[1][i] = 1;
//
//        for (int i = 2; i <= n; i++)
//            for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
//                for (int k = 1; k <= face && k <= j; k++)
//                    dp[i][j] += dp[i - 1][j - k];
//
//        final double totalNum = Math.pow(6, n);
//        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
//        for (int i = n; i <= pointNum; i++)
//            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
//
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        List<Map.Entry<Integer, Double>> entries = new Test60().dicesSum(5);
//        System.out.println(entries.toString());
//    }
//}
