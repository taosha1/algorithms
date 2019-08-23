import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test48 {

    public int longestSubStringWithoutDuplication(String str) {
        if (str.length() < 1 || str == null) {
            return 0;
        }
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int index = str.substring(0, i).lastIndexOf(str.charAt(i));
            if (index == -1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int d = i - index;
                if (d <= dp[i - 1]) {
                    dp[i] = d;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }




    public static void main(String[] args) {
        System.out.println(new Test48().lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(new Test48().lengthOfLongestSubstring3("arabcacfr"));
    }
}
