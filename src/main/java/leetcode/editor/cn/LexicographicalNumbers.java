package leetcode.editor.cn;

//给定一个整数 n, 返回从 1 到 n 的字典顺序。 
//
// 例如， 
//
// 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。 
//
// 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。 
// 👍 103 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * LC 386
 * Created by wujianchao
 */
public class LexicographicalNumbers{
    
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
        solution.lexicalOrder(15);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class TrieNode{
            byte val;
            TrieNode[] child=new TrieNode[10];
            boolean isEnd;
            TrieNode(byte val){
                this.val = val;
            }
        }

        class Trie{
            TrieNode root = new TrieNode((byte) -1);
            public void add(int n){

                int i=n/10;
                int j=n%10;

                // n除了个位的位数
                int level =0;
                for(;i!=0;){
                    i=i/10;
                    level++;
                }

                TrieNode node = root;

                //非个位
                for(;level>0; level--){
                    int pow = (int) Math.pow(10, level);
                    byte a = (byte) (n/pow);
                    if(node.child[a] == null){
                        node.child[a] = new TrieNode(a);
                        node = node.child[a];
                    }
                    n=n%pow;
                }

                // 个位
                if(n != 0) {
                    if(node.child[n] == null){
                        node.child[n]=new TrieNode((byte) n);
                    }
                    node.child[n].isEnd =true;
                }

            }


           public List<Integer> traverse(){
                if(root.val == -1){
                    return new ArrayList<>();
                }
                return traverseR(root, 0);
            }

            //
            private List<Integer> traverseR(TrieNode root, int pre) {
                if(root.val == -1){
                    return new ArrayList<>();
                }
                List<Integer> result =new ArrayList<>();

                if(root.isEnd){
                    result.add(pre*10 + root.val);
                }

                for(int i=0;i<root.child.length;i++){
                    TrieNode node = root.child[i];
                    result.addAll(traverseR(node, pre*10+node.val));
                }

                return result;
            }

        }

        public List<Integer> lexicalOrder(int n) {

            Trie trie = new Trie();
            for(int i=1;i<=n;i++){
                trie.add(i);
            }

            return trie.traverse();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

