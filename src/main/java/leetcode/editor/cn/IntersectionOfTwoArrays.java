package leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 198 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * LC 349
 * Created by wujianchao
 */
public class IntersectionOfTwoArrays{
    
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] build = null;
        int[] probe = null;
        if(nums1.length < nums2.length){
            build =nums1;
            probe = nums2;
        }else{
            build =nums2;
            probe = nums1;
        }

        Set<Integer> hash = new HashSet<>();

        for(int i : build){
            hash.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for(int i:probe){
            if(hash.contains(i)){
                result.add(i);
            }
        }
        int[] r = new int[result.size()];
        int i = 0;
        for(int e : result){
            r[i++] = e;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

