package leetcode.editor.cn;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 460 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 51
 * Created by wujianchao
 */
public class NQueens{
    
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            List<String> path = new LinkedList<>();
            solveNQueensR(path, n);
            return result;
        }

        private void solveNQueensR(List<String> path, int n) {

            // 获得一个解
            if(path.size() == n){
                List<String > r = new ArrayList<>(path);
                result.add(r);
                return;
            }

            for(int i=0;i<n;i++) {
                // 过滤非法选项

                if(path.size() != 0){
                    String last = path.get(path.size() -1);
                    // 去掉同行列的和上一列斜相邻的
                    if(notChoose(path, n, i)){
                        continue;
                    }
                }

                // 做选择
                String choice = buildChoiceStr(n, i);
                path.add(choice);

                // 继续backtrack
                solveNQueensR(path, n);

                // 回退选择
                path.remove(path.size()-1);
            }
        }

        private boolean notChoose(List<String> path, int n, int i) {
            for(String p :path){
                if(i == queuePosition(p)){
                    return true;
                }
            }

            String last = path.get(path.size() -1);
            int lastQueuePosition = queuePosition(last);

            if(lastQueuePosition != -1){
                if(i+1==lastQueuePosition || i-1==lastQueuePosition){
                    return true;
                }
            }
            return false;
        }

        private int queuePosition(String s){
            for(int i =0; i<s.length(); i++){
                if(s.charAt(i) == 'Q'){
                    return i;
                }
            }
            return -1;
        }


        private String buildChoiceStr(int n, int j) {
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<n;i++){
                sb.append(j==i?"Q":".");
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

