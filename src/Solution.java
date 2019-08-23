import java.util.*;

public class Solution {
    //    public List<Map.Entry<Integer, Double>> dicesSum(int sum) {
//class Solution {
//public:
//    int integerBreak(int n) {
//        vector<int> dp(n+1,0);
//        dp[1]=1;
//        for(int i=2;i<=n;i++){
//            for(int j=0;j<i;j++){
//                dp[i]=max(dp[i],max((i-j)*dp[j],(i-j)*j));
//            }
//        }
//        return dp.back();
//    }
//};1、子序列：不要求连续子序列，只要保证元素前后顺序一致即可；
//
//2、上升：这里的“上升”是“严格上升”，类似于 [2, 3, 3, 6, 7] 这样的子序列是不符合要求的；
//
//一个序列可能有多个最长上升子序列，题目中只要我们求这个最长的长度。如果使用回溯搜索，选择所有的子序列进行判断，时间复杂度为 $O( (2^n) * n )$。
//
//定义状态：LIS(i) 表示以第 i 个数字为结尾的最长上升子序列的长度。即在 [0, ..., i] 的范围内，选择以数字 nums[i] 结尾可以获得的最长上升子序列的长度。关键字是：以第 i 个数字为结尾，即我们要求 nums[i] 必须被选取。反正一个子序列一定要以一个数字结尾，那我就将状态这么定义，这一点是重要且常见的。
//
//状态转移方程：遍历到索引是 i 的数的时候，我们应该把索引是 [0, ... ,i - 1] 的 LIS 都看一遍，
// 如果当前的数 nums[i] 大于之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的 LIS 。把前面的 i 个数都看了， LIS[i] 就是它们的最大值加 $1$。即比当前数要小的那些里头，找最大的，然后加 $1$ 。
//
//状态转移方程即：LIS(i) = max( 1 + LIS(j) if j < i and nums[i] > nums[j])
//
//最后不要忘了，应该扫描一遍这个 LIS[i] 数组，其中最大的就是我们所求的。
//
//    }

    /**
     * dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     * 由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     * 对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     * 1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     * 数组尾部, 并将最长递增序列长度maxL加1
     * 2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     **/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 0) {
                        if (j == 0)
                            dp[i][j] = 1;
                        else {
                            dp[i][j] = dp[i][j - 1];
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 0) {
                        if (i == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length];

    }

    /*这题懂了就非常简单。首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。[0,0,1,1,1,2,2,3,3,4]

     * */


    public int romanToInt(String s) {
        int roman_int = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I': {
                    roman_int = roman_int + 1;
                    break;
                }
                case 'V':
                    roman_int = roman_int + 5;
                    break;
                case 'X':
                    roman_int = roman_int + 10;
                    break;
                case 'L':
                    roman_int = roman_int + 50;
                    break;
                case 'C':
                    roman_int = roman_int + 100;
                    break;
                case 'D':
                    roman_int = roman_int + 500;
                    break;
                case 'M':
                    roman_int = roman_int + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }
            if (i != 0) {
                if (s.charAt(i - 1) == 'V' || s.charAt(i - 1) == 'X' && s.charAt(i) == 'I') {
                    roman_int -= 1 * 2;
                }
            }
        }
        return roman_int;
    }

    public static String longestCommonPrefix0(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
//        strs[0].indexOf()
        String str1 = strs[0];
        String str2 = strs[1];
        String commonStr = "";
        int commonLen = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                commonLen++;
            } else {
                break;
            }
        }
        commonStr = str1.substring(0, commonLen);
        if (commonLen == 0) {
            return "";
        }

        for (int i = 2; i < strs.length; i++) {
            if (!strs[i].startsWith(commonStr)) {
                commonStr = commonStr.substring(0, commonStr.length() - 1);
                i--;
            }
            if (commonStr == "") {
                return "";
            }
        }

        return commonStr;
    }

    //数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
//public int removeElement(int[] nums, int val) {
//    int i = 0;
//    for (int j = 0; j < nums.length; j++) {
//        if (nums[j] != val) {
//            nums[i] = nums[j];
//            i++;
//        }
//    }
//    return i;
//}
//
//作者：LeetCodepublic int removeDuplicates(int[] nums) {
//    if (nums.length == 0) return 0;
//    int i = 0;
//    for (int j = 1; j < nums.length; j++) {
//        if (nums[j] != nums[i]) {
//            i++;
//            nums[i] = nums[j];
//        }
//    }
//    return i + 1;
//}
//
//作者：LeetCode
//链接：https://leetcode-cn.com/problems/two-sum/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//链接：https://leetcode-cn.com/problems/two-sum/solution/yi-chu-yuan-su-by-leetcode/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//当我们遇到 nums[j] \neq nums[i]nums[j]
// =nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]。然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast++];
            }
        }
        return ++slow;
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }// 3223
        return slow;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() < 1) {
            return 0;
        }// aaa b
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j > haystack.length()) {
                        return -1;
                    }
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return i;
            }
        }
        return -1;
    }

    //"mississippi"
    //"issip"
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[0]) {
                return 0;
            }
            if (target > nums[nums.length - 1]) {
                return nums.length;
            }
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return 0;
    }

//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length < 1) {
//            return 0;
//        }
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++) {
//                if (prices[j] > prices[i]) {
//                    if (max < prices[j] - prices[i]) {
//                        max = prices[j] - prices[i];
//                    }
//                } else {
//                    continue;
//                }
//            }
//        }
//        return max;
//    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (0 < prices[i] - min) {
                max += prices[i] - min;
            } else {
                max = max;
            }
            min = prices[i];
        }
        return max;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows + 1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    List<Integer> listPre = lists.get(i - 2);
                    list.add(listPre.get(j) + listPre.get(j - 1));
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

//    public ListNode removeElements(ListNode head, int val) {
//        ListNode newHead = new ListNode(-1);
//        newHead.next = head;
//        cur =  newHead;
//        while (cur.next != null) {
//            if (cur.next.val == val) {
//                cur.next = cur.next.next;
//            }else {
//                cur = cur.next;
//            }
//        }
//        return newHead.next;
//    }
//    [1,2,6,3,4,5,6]
//     6
//    public List<Integer> getRow2(int rowIndex) {
//        int[] arr = new int[rowIndex + 1];
//        for (int i = 0; i <= rowIndex; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    if (arr[i] == 1) {
//                        continue;
//                    }
//                    arr[i] = 1;
//                } else {
//                    if (j >= 2) {
//                        int pre2 = arr[j - 2];
//                        arr[j] = arr[j] + arr[j-1] -pre2;
//                        continue;
//                    }
//                    arr[j] = arr[j] + arr[j - 1];
//                }
//            }
//        }
////        List<Integer> res = Arrays.asList(dp);
////        return res;
//    }
    /*
    *  vector<int> getRow(int rowIndex) {
        vector<int> res(rowIndex+1,0);
        res[0]=1;
        for(int i=1;i<rowIndex+1;i++)
        {
            for(int j=i;j>=1;j--)
                res[j]+=res[j-1];
        }

        return res;
    }
    * for (int i = 1; i < rowIndex; i++) {
            result.add(1);
            for (int j = 0; j < i; j++) {
                result.add(result.get(0) + result.get(1));
                result.remove(0);
            }
            result.add(1);
            result.remove(0);
        }

        return result;
    * */
//            1
//            1 1
//            1 2 1
//            1 3 3 1
//            1 4 6 4 1
    /*输入: [7,1,5,3,6,4]
输出: 7      0 0 4 4 5 5
输入: [1,2,3,4,5]
输出: 4
动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
记录【今天之前买入的最小值】
计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
比较【每天的最大获利】，取最大值即可
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
    dp[n] = dp[n+1] - res[n]
    dp[n] = res[max] - res[n]
    * 示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    * */

    //输入: [1,3,5,6], 7
    //输入: [1,3,5,6], 0
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        int count = 0;
        int[] res = new int[2];
        for (int i = 1; i < prices.length; i++) {
            int firstProfit = prices[i] - min;
            if (0 < firstProfit) {
                count++;
            }
            if (count > 0) {
                if (firstProfit > res[0]) {
                    res[0] = firstProfit;
                } else if (firstProfit > res[1]) {
                    res[1] = firstProfit;
                }
            }
            min = prices[i];
        }
        if (count == prices.length - 1) {
            return prices[prices.length - 1] - prices[0];
        }
        return res[0] + res[1];
    }

//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                return true;
//            }
//        }
//        return false;
//    }

    /*解题思路：分两个步骤，首先通过快慢指针的方法判断链表是否有环；接下来如果有环，则寻找入环的第一个节点。具体的方法为，
    首先假定链表起点到入环的第一个节点A的长度为a【未知】，到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。
    现在我们想知道a的值，注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，如果只走a个长度就能回到节点A。但
    是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，
    那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，相遇的地方必然是入环的第一个节点A。
    文字有点绕，画个图就一目了然了~~ `` public class Solution { public ListNode detectCycle(ListNode head) { if (head == null) return null;


     * */


//    public ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        boolean flag = false;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                flag = true;
//            }
//        }
//        ListNode cur = head;
//        if (flag) {
//            while (cur != slow) {
//                cur = cur.next;
//                slow = slow.next;
//            }
//            return cur;
//        }
//        return null;
//    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while (n >= 2) {
            if ((n & 1) != 0) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int fast = 0;
        int slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) {
                break;
            }
        }
        int cur = 0;
        while (cur != fast) {
            cur = nums[cur];
            fast = nums[fast];
            if (cur == fast) {
                break;
            }
        }
        return fast;
    }

    //输入: [7,1,5,3,6,4]
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i - 1 == -1) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                    continue;
                }
                if (j == 0) {
                    dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
                } else if (j == 1) {
                    dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
                    //注意 k 的限制，我们在选择 buy 的时候，把 k减小了 1 当k为0时 dp[i][0][0] = 0
//                    dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
                }
            }
        }
        return dp[prices.length - 1][0];
    }


    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int sum = 0, sum2 = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
            if (i == nums.length) {
                break;
            }
            sum2 += nums[i];
        }
        return sum - sum2;
    }

    //F(n) = max {i * F(n - i)}，i = 1，2，...，n - 1

    public int integerBreak(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * integerBreak(n - i));
        }
        return max;
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[j] = 1;
                } else if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }


    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else
                    dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum2(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else
                    dp[j] = Math.min(dp[j] + grid[i][j], dp[j - 1] + grid[i][j]);
            }
        }
        return dp[grid[0].length - 1];
    }


    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max <= 0) {
                max = num;
            } else {
                max += num;
            }
            res = Math.max(res, max);

        }
        return res;

    }

    /**
     * class Solution {
     * public:
     * int rob(vector<int>& nums) {
     * if(nums.size()==1)
     * return nums[0];
     * int n=nums.size();
     * vector<int>a(n+1),b(n+1);
     * for(int i=2;i<n+1;i++){
     * a[i]=max(a[i-1],a[i-2]+nums[i-2]);
     * b[i]=max(b[i-1],b[i-2]+nums[i-1]);
     * }
     * return max(a[n],b[n]);
     * }
     * };
     * };
     */

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;

    }



    /*笔记】三指针法。一部分是丑数数组，另一部分是权重2，3，5。下一个丑数，定义为丑数数组中的数乘以权重，所得的最小值。

    那么，2该乘以谁？3该乘以谁？5该乘以谁？

    其一，使用三个指针idx[3]，告诉它们。比如，2应该乘以ugly[idx[0]]，即数组中的第idx[0]个值。（权重2，3，5分别对应指针，idx[0],idx[1],idx[2]）

    其二，当命中下一个丑数时，说明该指针指向的丑数 乘以对应权重所得积最小。此时，指针应该指向下一个丑数。（idx[]中保存的是丑数数组下标）

    其三，要使用三个并列的if让指针指向一个更大的数，不能用if-else。因为有这种情况：
    丑数6，可能由于丑数2乘以权重3产生；也可能由于丑数3乘以权重2产生。
    丑数10，... 等等。
    public int nthUglyNumber(int n) {
        if(n==1) return n;
        int[] num=new int[n];
        num[0]=1;
        int x2=0;
        int x3=0;
        int x5=0;
        for(int i=1;i<n;i++){
            num[i]=Math.min(Math.min(num[x2]*2,num[x3]*3),num[x5]*5);
            if(num[i]==num[x2]*2) x2++;
            if(num[i]==num[x3]*3) x3++;
            if(num[i]==num[x5]*5) x5++;
        }
        return num[n-1];
    }
    int nthUglyNumber(int n) {
    vector<int> ugly(n, 1), idx(3, 0);
    for (int i = 1; i < n; ++i){
        int a = ugly[idx[0]]*2, b = ugly[idx[1]]*3, c = ugly[idx[2]]*5;
        int next = std::min(a, std::min(b, c));
        if (next == a){
            ++idx[0];
        }
        if (next == b){
            ++idx[1];
        }
        if (next == c){
            ++idx[2];
        }
        ugly[i] = next;
    }
    return ugly.back();
}输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
分析思路: 看题目最小XXX很容易想到动态规划，仔细看下最后的状态可以分解为多个子状态，动态规划无疑。

确定状态：m*n的最小路径可以看成m-1*n-1的最小路径，m-1*n-1的到m*n有两种可能，向下或者向右，由此我们可以得出转移方程。

//转移方程: f(m,n)=min(f(m,n-1)+grid(m,n),f(m-1,n)+grid(m,n))
//
//初始条件: m=0的时候，只能向右走，即f(m,n)=f(0,n-1)+grid(m,n); n=0的时候，只能向下走，即f(m,n)=f(m-1,0)+grid(m,n);
//
计算顺序： 顺序计算到f(m,n)
    * */

    int nthUglyNumber(int n) {
        int[] arr = new int[n];
        int x2 = 0;
        int x3 = 0;
        int x5 = 0;
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(Math.min(arr[x2] * 2, arr[x3] * 3), arr[x5] * 5);
            if (arr[i] == arr[x2] * 2)
                x2++;
            if (arr[i] == arr[x3] * 3) x3++;
            if (arr[i] == arr[x5] * 5) x5++;
        }
        System.out.println(Arrays.toString(arr));
        return arr[n - 1];
    }


//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int val = root.val;
//        int norootVal = rob(root.left) + rob(root.right);
//
//        if (root.left != null) {
//            val += rob(root.left.left);
//            val += rob(root.left.right);
//        }
//        if (root.right != null) {
//            val += rob(root.right.left);
//            val += rob(root.right.right);
//        }
//        return Math.max(val, norootVal);
//
//    }
//
//    private int doRob(TreeNode node) {
//        if (node == null)
//            return 0;
//        int include = node.val;
//        int exclude = doRob(node.left) + doRob(node.right);
//        if (node.left != null) {
//            include += doRob(node.left.left);
//            include += doRob(node.left.right);
//        }
//        if (node.right != null) {
//            include += doRob(node.right.left);
//            include += doRob(node.right.right);
//        }
//        return Math.max(include, exclude);
//    }



    /*Line 23: error: method toArr in class Solution cannot be applied to given types;
Line 13: error: method toArr in class Solution cannot be applied to given types;
        List<Integer> l = toArr(root, list);
                          ^
  required: TreeNode
  found: TreeNode,List<Integer>
  reason: actual and formal argument lists differ in length
    * */

    //1 2 3 1
    //[2,7,9,3,1]  11 3 1
    // 1 2 1 1
    // 1 1 1 2
//    public int rob(int[] nums) {
//        // 0 -> n-2  1 -> n-1
//        if (nums == null) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
//
//    }

    public void test1() {
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (x == nums1.length) {
                arr[i] = nums2[y];
                y++;
                continue;
            }
            if (y == nums2.length) {
                arr[i] = nums1[x];
                x++;
                continue;
            }
            if (nums1[x] < nums2[y]) {
                arr[i] = nums1[x];
                x++;
            } else {
                arr[i] = nums2[y];
                y++;
            }
        }
        return (arr.length & 1) == 1 ? arr[arr.length / 2] : (arr[arr.length / 2] + arr[(arr.length - 1) / 2]) / 2.0;

    }

    public int maxProfit20(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2 + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
            }
        }
        return dp[n - 1][2][0];

    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        if (k > n / 2) {
            return maxProfit(prices);
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {
//        int[] a1 = {1, 2, 3, 4, 5};
        int[] a1 = {7, 1, 5, 3, 6, 4};
//        int[] a1 = {3,3,5,0,0,3,1,4};
//        int[] a1 = {6, 1, 3, 2, 4, 7};
//        int[] a1 = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
//        System.out.println(new Solution().findDuplicate(a1));
        new Solution().getRow(3);
        System.out.println(new Solution().maxProfit(2, a1));
        "mississippi".indexOf("issipi");
        new Solution().strStr("mississippi", "issipi");
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        };
        new Solution().removeDuplicates(nums);
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix0(strings));
        int[][] arr = {
                {1, 2, 5},
                {3, 2, 1},
        };
        System.out.println(new Solution().uniquePaths(10, 10));
        System.out.println(new Solution().integerBreak(4));
    }
}
