package algo;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 782 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 46
 * Created by wujianchao
 *
 * 回溯问题
 *
 * 使用于：全排列、组合、N皇后等问题
 *
 *
 * 框架：
 *
 * for 选择 in 选择列表:
 *     # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径, 选择列表)
 *     # 撤销选择
 *     路径.remove(选择)
 *     将该选择再加入选择列表
 *
 */
public class BackTrack {
    
    public static void main(String[] args) {
        Solution solution = new BackTrack().new Solution();
        int[] a = new int[]{1,2,3};
        List<List<Integer>> result = solution.permute(a);
        for(List<Integer> r :result){
            System.out.println(r);
        }
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> path = new LinkedList<>();
            permuteR(path, nums);
            return result;
        }


        private void permuteR(LinkedList<Integer> path, int[] choice) {
            // 获得一个解
            if(choice.length == path.size()){
                List<Integer> r = new ArrayList<>();
                for(int e : path){
                    r.add(e);
                }
                result.add(r);
                return;
            }

            for(int i=0;i<choice.length;i++){

                //剔除非法的choice
                if(path.contains(choice[i])){
                    continue;
                }
                //做选择
                path.add(choice[i]);
                //继续
                permuteR(path, choice);
                // 回退
                path.removeLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

