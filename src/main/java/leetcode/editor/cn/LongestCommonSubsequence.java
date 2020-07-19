package leetcode.editor.cn;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 181 👎 0

import java.util.HashMap;

/**
 * LC 1143
 * Created by wujianchao
 */
public class LongestCommonSubsequence{
    
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        String text1= "addbhhc";
        String text2= "aublcp";
        int lcs = solution.longestCommonSubsequence(text1, text2);
        System.out.println(lcs);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        class Sub{
            int i;
            int j;
            public Sub(int i, int j){
                this.i = i;
                this.j = j;
            }

            @Override
            public boolean equals(Object o){
                if (o==null)
                    return false;
                if(!(o instanceof  Sub)){
                    return false;
                }
                Sub a = (Sub) o;
                return a.i == i && a.j==j;
            }

            @Override
            public int hashCode(){
                return i*31 + j;
            }

        }

        public int longestCommonSubsequence(String text1, String text2) {
            HashMap<Sub, Integer> memo = new HashMap<>();
            return dp(text1, text2, text1.length() -1, text2.length() -1, memo);
        }

        private int dp(String text1, String text2, int i, int j, HashMap<Sub, Integer> memo){
            // base case
            if(i==-1 || j==-1){
                return 0;
            }

            Sub sub = new Sub(i, j);
            if(memo.get(sub) != null){
                return memo.get(sub);
            }

            int r = -1;
            if(text1.charAt(i) == text2.charAt(j)){
                // 这边找到一个 lcs 的元素，继续往前找
                r = dp(text1, text2, i-1, j-1, memo) + 1;
            }else{
                // 否则取各自串后退一步的最大值
                r = Math.max(dp(text1, text2, i-1, j, memo),
                        dp(text1, text2, i, j-1, memo));
            }
            memo.put(sub, r);
            return r;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

