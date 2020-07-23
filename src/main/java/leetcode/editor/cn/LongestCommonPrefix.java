package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1174 👎 0

/**
 * LC 14
 * Created by wujianchao
 */
public class LongestCommonPrefix{
    
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "flight";
        System.out.println(solution.longestCommonPrefix(strs));
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minStrLen = Integer.MAX_VALUE;
        for(String s :strs){
            minStrLen = Math.min(s.length(), minStrLen);
        }
        if(minStrLen == 0 || minStrLen == Integer.MAX_VALUE){
            return "";
        }

        int maxMatchIndex = minStrLen -1;
        boolean find = false;
        for(int i=0;i<minStrLen && !find;i++){
            char pre = (char) -1;
            for(String s : strs){
                if(pre == (char)-1 || (s.charAt(i) == pre)){
                    pre = s.charAt(i);
                } else {
                    maxMatchIndex = i - 1;
                    find = true;
                    break;
                }
            }
        }

        return maxMatchIndex == -1 ? "" : strs[0].substring(0, maxMatchIndex + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

