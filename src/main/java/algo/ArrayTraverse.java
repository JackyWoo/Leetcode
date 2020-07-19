package algo;

import org.junit.Test;

/**
 * Created by wujianchao on 2020/6/26.
 */
public class ArrayTraverse {

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5};
        traverse(arr, 0);
    }

    private void traverse(int[] nums, int i) {
        if(i>=nums.length) return;
        System.out.println(nums[i]);
        traverse(nums, i*2 + 1);
        traverse(nums, i*2 + 2);
    }
}
