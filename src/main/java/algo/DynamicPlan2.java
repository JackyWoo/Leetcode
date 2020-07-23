package algo;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2464 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * LC 5
 * Created by wujianchao
 */
public class DynamicPlan2 {
    
    public static void main(String[] args) {
        Solution solution = new DynamicPlan2().new Solution();
//        String s = "aba";
        String s = "anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
        String ss = solution.longestPalindrome(s);
        System.out.println(ss);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)

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
            if(!(o instanceof Sub)){
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

    class Solution {

        public String longestPalindrome(String s) {
//            return longestPalindromeWithDP(s);
            return longestPalindromeWithExpandAroundCenter(s);
        }

        /**
         * 思路一： 动态规划
         *
         * 1. 如果对于字符串中的所有子串，都判断出它是否是回文串，然后取出最长的一个子串，则问题可解。
         * 2. 如果一个字符串s是回文串，那么它首尾两个字符相等，并且子串也是回文串，很明显子问题具有最优子结构特性。
         */
        public String longestPalindromeWithDP(String s) {
            HashMap<Sub, Boolean> memo = new HashMap<>();
            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){
                    dp(s, i, j, memo);
                }
            }
            Sub maxSub = null;
            for(Map.Entry<Sub, Boolean> entry : memo.entrySet()){
                if(entry.getValue()){
                    Sub cur = entry.getKey();
                    if(maxSub == null || maxSub.j-maxSub.i < cur.j - cur.i){
                        maxSub = cur;
                    }
                }
            }
            return maxSub == null ? "" : s.substring(maxSub.i, maxSub.j+1);
        }

        private boolean dp(String s, int i, int j, HashMap<Sub, Boolean> memo){
            Sub sub = new Sub(i, j);
            if(memo.get(sub) != null){
                return memo.get(sub);
            }
            boolean result = false;
            if(i==j) {
                result = true;
            }else if(j-i==1){
                result = s.charAt(i) == s.charAt(j);
            } else if(s.charAt(j) == s.charAt(i)){
                result = dp(s, i+1, j-1, memo);
            }
            memo.put(sub, result);
            return result;
        }

        /**
         * 思路二： 中心扩散
         *
         * 1. 依次假设i是回文串的中心节点，然后依次向两边扩散直到两边的字符不相等，至此直到一个回文串
         * 2. 回文的中心点有两种情况 1. “a"; 2. "aa"
         */
        public String longestPalindromeWithExpandAroundCenter(String s) {
            if(s==null || s.isEmpty()){
                return "";
            }

            int start = 0;
            int end = 0;
            int maxLen = 1;

            for(int i=0;i<s.length();i++){
                // case  a
                int[] pos1 = expandAroundCenter(s, i, i);
                int[] pos2 = expandAroundCenter(s, i, i+1);

                int[] pos = pos1[1] - pos1[0] > pos2[1] - pos2[0] ? pos1 : pos2;
                int maxI = pos[1] - pos[0] + 1;

                if(maxI > maxLen){
                    maxLen = maxI;
                    start = pos[0];
                    end = pos[1];
                }
            }

            return s.substring(start, end + 1);
        }

        /**
         * @return expand length
         */
        private int[] expandAroundCenter(String s, int left, int right){
            if(right==s.length()){
                return new int[]{left, left};
            }
            if(s.charAt(left) != s.charAt(right)){
                return new int[]{left, left};
            }

            int l=left, r=right;
            while(l>=0 && r<s.length()){
                if(s.charAt(l) != s.charAt(r)){
                    break;
                }
                l--;
                r++;
            }

            int[] result = new int[2];
            result[0] = l + 1;
            result[1] = r - 1;
            return result;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

