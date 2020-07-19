package leetcode.editor.cn;

//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组 
// 👍 139 👎 0

import java.util.HashMap;

/**
 * LC 509
 * Created by wujianchao
 */
public class FibonacciNumber{
    
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int N) {
            HashMap<Integer, Integer> memo = new HashMap<>();
            return dpFib(N, memo);
        }

        /**
         * 状态转移方程（也就是暴力求解的方式）：
         *      f(n) = 1, n=1,2
         *           = f(n-1) + f(n-2), n>2
         *
         *
         * @param n
         * @param memo 备忘录，可以记录重叠子问题的解，以便重叠子问题可以直接求出解
         * @return
         */
        private int dpFib(int n, HashMap<Integer, Integer> memo){
            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            if(memo.get(n) != null){
                // 重叠子问题只有一次，所以可以及时删除
                return memo.remove(n);
            }
            int a = dpFib(n-1, memo);
            int b = dpFib(n-2, memo);
            int r = a + b;
            memo.put(n, r);
            return r;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

