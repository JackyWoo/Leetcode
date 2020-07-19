package algo;

/**
 * Created by wujianchao on 2020/6/23.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 3,6};
        new QuickSort().sort(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr) {
        sortR(arr, 0, arr.length -1);
    }

    private void sortR(int[] arr, int start, int end) {
        //当一次排序所有的值都小于pivot时，pivot没有变动，此时start可能大于end
        if(start >= end) {
            return;
        }
        int pivot = start;
        // 确定pivot位置

        for(int i=start+1; i<=end; i++) {
            if(arr[pivot]>arr[i]){
                //交换
                swap(arr, pivot, i);
                pivot = i;
            }
        }

        // sort left
        sortR(arr, start, pivot-1 );
        sortR(arr, pivot+1, end);
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
