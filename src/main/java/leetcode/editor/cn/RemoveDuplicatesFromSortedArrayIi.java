package leetcode.editor.cn;

//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
// Related Topics 数组 双指针 
// 👍 249 👎 0

/**
 * LC 80
 * Created by wujianchao
 */
public class RemoveDuplicatesFromSortedArrayIi{
    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        int[] nums = new int[] {1,1,1};
        int len = solution.removeDuplicates(nums);
        System.out.println(len);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            // m = first occurance
            // n = second
            int m =0, n = 0;

            int removed = 0;
            int end = nums.length;

            for(int i=1;i<end;i++){

                // 判断结束
                if(i>=end-removed){
                    break;
                }

                //TODO last
                if(nums[m] == nums[i]){
                    continue;
                }
                n = i;

                int p = n-m -2;
                if(p>0){
                    // move
                    move(nums, n, p);
                    i-=p;
                    n-=p;
                    m = n;
                    removed+=p;
                } else {
                    m =n;
                }

            }

            return end-removed;

        }

        private void move(int[] nums, int n, int p) {
            for(int i=n;i<nums.length;i++){
                // new position
                int j = i-p;
                nums[j] = nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

