package leetcode.editor.cn;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 332 👎 0

/**
 * LC 208
 * Created by wujianchao
 */
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie solution = new ImplementTriePrefixTree().new Trie();
    }

    //---------------------------------//

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        class Node {
            char val;

            Node[] child = new Node[26];
            boolean isValue;

            Node(char val){
                this.val = val;
            }

            Node(char val, boolean isValue){
                this.val = val;
                this.isValue = isValue;
            }

            public Node addChild(char val) {
                if(child[val-'a'] == null) {
                    child[val-'a'] = new Node(val);
                }
                return child[val-'a'];
            }

            public Node getChild(char val) {
                return child[val-'a'];
            }

        }

        Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node((char) -1);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node cursor = root;
            for(int i =0 ;i<word.length(); i++) {
                cursor = cursor.addChild(word.charAt(i));
            }
            cursor.isValue = true;
        }


        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node cursor = root;
            for(int i =0 ;i<word.length(); i++) {
                cursor = cursor.getChild(word.charAt(i));
                if(cursor == null){
                    return false;
                }
            }
            if(cursor.isValue){
                return true;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node cursor = root;
            for(int i =0 ;i<prefix.length(); i++) {
                cursor = cursor.getChild(prefix.charAt(i));
                if(cursor == null){
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)


}

