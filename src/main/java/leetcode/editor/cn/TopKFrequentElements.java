package leetcode.editor.cn;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 391 👎 0

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 347
 * Created by wujianchao
 */
public class TopKFrequentElements{
    
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class Node {
            int val;
            //频率
            int frq;
            Node left;
            Node right;

            Node(int val, int frq){
                this.val =val;
                this.frq =frq;
            }

        }

    public int[] topKFrequent(int[] nums, int k) {

        // 构建hash表，value为出现的频率
        Map<Integer, Integer> hash = new HashMap<>();

        for(int i :nums){
            if(hash.containsKey(i)){
                hash.put(i, hash.get(i) + 1);
            }else{
                hash.put(i, 1);
            }
        }

        //哈希表翻转，并排序
        Node[] pairs = new Node[hash.size()];
        int index=0;
        for(Map.Entry<Integer, Integer> e:hash.entrySet()){
            pairs[index] = new Node(e.getKey(), e.getValue());
            index++;
        }

        // 堆排序，排k次
        // TODO
        headSort(pairs, k, 0, pairs.length -1);

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = pairs[i].val;
        }
        return result;
    }

    private void headSort(Node[] nodes , int times, int start, int end){

    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
}

