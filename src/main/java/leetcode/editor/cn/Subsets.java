package leetcode.editor.cn;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 644 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 78
 * Created by wujianchao
 */
public class Subsets{
    
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> path = new LinkedList<>();
            subsetsR(path, nums, 0);
            result.add(new ArrayList<>());
            return  result;
        }

        private void subsetsR(List<Integer> path, int[] nums, int firstChoiceIndex) {
            // 获得一个解
            if(!path.isEmpty()){
                List<Integer> r = new ArrayList<>(path);
                result.add(r);
            }
            if(path.size() == nums.length){
                return;
            }

            // skip this choice

            for(int i=firstChoiceIndex;i<nums.length;i++) {
                //过滤非法选择
                if(path.contains(nums[i])){
                    continue;
                }
                //做选择

                path.add(nums[i]);
                // 继续
                subsetsR(path, nums, ++firstChoiceIndex);
                // 回退选择
                path.remove(path.size() -1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

