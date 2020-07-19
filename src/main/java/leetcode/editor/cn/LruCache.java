package leetcode.editor.cn;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 732 👎 0

import java.util.HashMap;

/**
 * LC 146
 * Created by wujianchao
 */
public class LruCache {

    public static void main(String[] args) {
        LRUCache cache = new LruCache().new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

    //---------------------------------//

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class Node {
            int k;
            int v;
            Node(int k, int v){
                this.k = k;
                this.v = v;
            }

            Node pre = null;
            Node next = null;
        }

        class List{
            Node head = new Node(-2, -2);
            Node tail = new Node(-2, -2);

            int len = 0;

            List(){
                head.next = tail;
                tail.pre = head;
            }
        }

        int capacity;
        HashMap<Integer, Node> data = new HashMap<>();
        List lru = new List();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node n = find(key);
            if(n==null){
                return -1;
            }
            // move to head
            moveToHead(n);
            return n.v;
        }

        private Node find(int key){
            return data.get(key);
        }


        public void put(int key, int value) {
            Node n = find(key);
            if(n != null){
                n.v=value;
                // move to head
                moveToHead(n);
            }else{
                n = new Node(key, value);
                data.put(key, n);
                // add to head
                addToHead(n);

                // reach cap
                removeTail();
            }
        }

        private void removeTail(){
            if(lru.len>capacity) {
                Node toRemove = lru.tail.pre;
                toRemove.pre.next = lru.tail;
                lru.tail.pre = toRemove.pre;
                lru.len--;
                data.remove(toRemove.k);
            }
        }

        private void addToHead(Node n){
            Node next = lru.head.next;
            lru.head.next = n;
            n.pre = lru.head;
            n.next = next;
            next.pre=n;
            lru.len++;
        }

        private void moveToHead(Node n){
            Node pre = n.pre;
            Node next = n.next;

            if(n.pre == lru.head ){
                return;
            }

            pre.next = next;
            next.pre = pre;

            Node headNext = lru.head.next;
            lru.head.next = n;
            n.pre = lru.head;
            n.next = headNext;
            headNext.pre=n;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


}

