package leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 309 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 77
 * Created by wujianchao
 */
public class Combinations{
    
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            List<Integer> path = new LinkedList<>();
            backTrack(path, n, 1, k);
            return result;
        }

        private void backTrack(List<Integer> path, int n, int firstChoice, int k) {
            // 发现一个解
            if(path.size() == k){
                result.add(new LinkedList<>(path));
                return;
            }
            for(int i=1;i<=n; i++) {
                // 过滤非法选择
                if(path.contains(i) || i<firstChoice){
                    continue;
                }

                // 做选择
                path.add(i);
                // 继续回溯
                backTrack(path, n, ++firstChoice, k);
                // 回退选择
                path.remove(path.size() -1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

