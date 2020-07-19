package leetcode.editor.cn;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 508 👎 0

import java.util.*;

/**
 * LC 18
 * Created by wujianchao
 */
public class FourSum {

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();

    }

    //---------------------------------//

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int left = target;

            for(int i=0;i<nums.length;i++){
                left = left-nums[i];
                for(int j=0;j<nums.length&j!=i;j++){
                    left = left-nums[i];
                    //toSum
                    List<List<Integer>> twoSum = twoSum(nums, left);
                    for(List<Integer> r : twoSum){
                        if(!r.contains(i)&&!r.contains(j)) {
                            r.add(i);
                            r.add(j);
                            r.sort((a, b) -> a - b);
                            result.add(r);
                        }
                    }
                }
            }

            // index => value

            for(List<Integer> r : result){
                for(int i=0;i<r.size();i++){
                    r.set(i, nums[i]);
                }
            }

            // 去重
            Map<List<Integer>, Integer> hash = new HashMap<>();
            for(List<Integer> r : result){
                hash.put(r, 0);
            }
            Iterator<List<Integer>>  itr = result.iterator();
            for(;itr.hasNext();){
                hash.containsKey(itr.next());
                itr.remove();
            }
            return result;
        }


        public List<List<Integer>> twoSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>( );
            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hash.put(target - nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                Integer ano = hash.get(nums[i]);
                if (ano != null) {
                    if(i != ano) {
                        List<Integer> t = new ArrayList<>();
                        t.add(i);
                        t.add(ano);
                        result.add(t);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}

