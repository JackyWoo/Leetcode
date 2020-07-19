package leetcode.editor.cn;

//给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 提示：你可以假定这些字符串都是格式良好的： 
//
// 
// 字符串非空 
// 字符串不包含空格 
// 字符串只包含数字0-9、[、-、,、] 
// 
//
// 
//
// 示例 1： 
//
// 给定 s = "324",
//
//你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 给定 s = "[123,[456,[789]]]",
//
//返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
// Related Topics 栈 字符串 
// 👍 38 👎 0

import leecode.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * LC 385
 * Created by wujianchao
 */
public class MiniParser{
    
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
        String s = "[123,[456,[789]]]";
        NestedInteger ni  = solution.deserialize(s);
        System.out.println(ni);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
    class Solution {
        public NestedInteger deserialize(String s) {
            List<String> tokens = parseTokens(s);

            NestedInteger root = new NestedInteger();

            // case "123"
            if(tokens.size() == 1){
                root.setInteger(Integer.parseInt(tokens.get(0)));
                return root;
            }

            // case "[]"
            if(tokens.size() == 2){
                return root;
            }


            String cur = tokens.get(0);
            Stack<NestedInteger> niStack = new Stack<>();
            niStack.push(root);

            // 指向栈顶
            NestedInteger current = root;

            int i = 0;

            while (!niStack.isEmpty()){
                i++;

                if(i>=tokens.size()){
                    throw new IllegalArgumentException("illegal string");
                }
                cur = tokens.get(i);

                if(cur.equals("[")){
                    // 开始一个ni

                    NestedInteger newCurrent = new NestedInteger();
                    current.add(newCurrent);

                    niStack.push(newCurrent);
                    current = newCurrent;

                } else if(cur.equals("]")){
                    // 结束一个ni
                    niStack.pop();
                    if(!niStack.isEmpty()){
                        current = niStack.peek();
                    }else{
                        // 空栈了
                    }

                } else{
                    // 数字
                    current.setInteger(Integer.parseInt(cur));
                }

            }

            return root;
        }

    private List<String> parseTokens(String s) {
            List<String > r = new LinkedList<>();
            // case "123"
            if(!s.startsWith("[")){
                r.add(s);
                return r;
            }
            String[] arr = s.split(",");
            // case "[]"
            if(arr.length == 1){
                r.add(s.substring(0, 1));
                r.add(s.substring(1, 2));
                return r;
            }
            for(String a : arr){
                while (a.charAt(0) == '['){
                    r.add("[");
                    a = a.substring(1, a.length());
                }

                Stack<String> stack = new Stack<>();
                while (a.charAt(a.length() -1) == ']'){
                    stack.push("]");
                    a = a.substring(0, a.length() -1);
                }
                stack.push(a);
                while(!stack.isEmpty()){
                    r.add(stack.pop());
                }
            }
            return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

