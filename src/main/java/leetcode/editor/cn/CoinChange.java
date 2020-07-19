package leetcode.editor.cn;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 698 👎 0

import java.util.HashMap;

/**
 * LC 322
 * Created by wujianchao
 */
public class CoinChange{
    
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();

        int[] coins = new int[]{1,2,5,10};
        int r = solution.coinChange(coins, 99);
        System.out.println(r);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {
            HashMap<Integer, Integer> memo = new HashMap<>();
//            int[] memo = new int[amount];
            return dp(coins, amount, memo);
        }

        /**
         * 备忘录使用哈希表
         */
        private int dp(int[] coins, int amount, HashMap<Integer, Integer> memo) {
            if(memo.get(amount) != null){
                return memo.get(amount);
            }
            // 找到一个解
            if(amount == 0){
                return 0;
            }
            // 没找到解
            if(amount<0){
                return -1;
            }

            int r = Integer.MAX_VALUE;
            for(int coin : coins){

                int sub = dp(coins, amount - coin, memo);
                if(sub == -1){
                    continue;
                }
                r = Math.min(r, sub+1);
            }

            // 没有解
            if(r == Integer.MAX_VALUE){
                r = -1;
            }
            memo.put(amount, r);
            return r;
        }

        /**
         * 备忘录使用数组
         */
        private int dp0(int[] coins, int amount, int[] memo) {
            // 找到一个解
            if(amount == 0){
                return 0;
            }
            // 没找到解
            if(amount<0){
                return -1;
            }

            if(memo[amount -1] != 0){
                return memo[amount -1];
            }

            int r = Integer.MAX_VALUE;
            for(int coin : coins){

                int sub = dp0(coins, amount - coin, memo);
                if(sub == -1){
                    continue;
                }
                r = Math.min(r, sub+1);
            }

            // 没有解
            if(r == Integer.MAX_VALUE){
                r = -1;
            }
            memo[amount -1] = r;
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

