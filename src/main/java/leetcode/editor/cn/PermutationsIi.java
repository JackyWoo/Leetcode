package leetcode.editor.cn;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 343 👎 0

import com.sun.xml.internal.ws.encoding.ContentTypeImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 47
 * Created by wujianchao
 */
public class PermutationsIi{
    
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] a = new int[]{1,1,1};
        List<List<Integer>> result = solution.permuteUnique(a);
        for(List<Integer> r :result){
            System.out.println(r);
        }
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            LinkedList<Integer> path = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            //排序便于去重
            Arrays.sort(nums);
            permuteUniqueR(path, nums, used);
            return result;
        }

        private void permuteUniqueR(LinkedList<Integer> path, int[] choice, boolean[] used) {
            //发现一个解
            if(path.size() == choice.length){
                List<Integer> r = new LinkedList<>(path);
                result.add(r);
                return;
            }

            int pre = Integer.MAX_VALUE;
            for(int i=0;i<choice.length;i++) {

                //获得choice
                if(used[i]){
                    continue;
                }

                // 解空间剪枝，去掉相同的choice
                if(pre != Integer.MAX_VALUE && pre == choice[i]){
                    continue;
                }
                pre = choice[i];

                // 做选择
                path.add(choice[i]);
                used[i] = true;
                //继续
                permuteUniqueR(path, choice, used);
                //回退选择
                path.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

