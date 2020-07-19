package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 209 👎 0

/**
 *
 * 思路：按照一行一行的粒度遍历，从最后一行开始，每次遍历计算出下一次遍历的start位置。
 * start位置如何计算？对于一个行进行二分查找如果能找到值，则直接返回，如果找不到，计算start。
 * 在二分查找结束的位置查肯定就是接近target的位置了，在此位置附近查找小于target的最大值，
 * 以此作为下一个遍历的start。
 *
 * LC 74
 * Created by wujianchao
 */
public class SearchA2dMatrix{
    
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();

        int[][] matrix = new int[4][];
        int base = 1;
        for(int i=0;i<4;i++){
            int[] a = new int[3];
            a[0] = base * 10 + 0;
            a[1] = base * 10 + 1;
            a[2] = base * 10 + 2;
            matrix[i] = a;
            base ++;
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        boolean r = solution.searchMatrix(matrix, 1);
        System.out.println(r);
    }
    
    //---------------------------------//
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int len1 = matrix.length;
        if(len1==0){
            return false;
        }
        int len2 = matrix[0].length;
        if(len2==0){
            return false;
        }

        int start = 0;
        for(int r=len1 -1;r>=0;r--){
            int index = binarySearch(matrix[r], start, len2-1, target);
            if(index == -1){
                // 下一个数组的起始位置
                start = 0;
            }else if(matrix[r][index] == target){
                return true;
            }else {
                // 下一个数组的起始位置
                start = index;
            }
        }
        return false;
    }

    private int binarySearch(int[] a, int start, int end, int target){
        if(start > end){
            // 找到比target小的最大值的index，该值就在start附近
            int r = (start + end)/2;
            if(r+1<a.length && a[r+1]<target){
                r = r + 1;
            }else if(a[r]<target){

            } else {
                r = r - 1;
            }
            return r;
        }

        int r;

        int mid = (start + end)/2;
        if(a[mid] == target){
            return mid;
        } else if(a[mid] > target){
            return binarySearch(a, start, mid -1, target);
        } else {
            return binarySearch(a,  mid +1, end, target);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
}

