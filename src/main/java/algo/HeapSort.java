package algo;

/**
 * Created by wujianchao on 2020/6/23.
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[] {2, 1, 3,6};
        HeapSort sorter = new HeapSort();
        sorter.heapSortV2(arr);
        for(int e : arr) {
            System.out.println(e);
        }
    }

    public void heapSortV2(int[] arr) {
        for(int end=arr.length -1; end>0; end--){
            //大顶堆
            heap(arr, 0, end);
            //交换堆顶跟最后一个元素
            swap(arr, 0, end);
        }
    }


    // 交换数组值
    private void swap(int[] arr, int start, int i) {
        int tmp = arr[start];
        arr[start] = arr[i];
        arr[i] = tmp;
    }

    // 生成大顶堆
    private void heap(int[] arr, int start, int end) {
        // node is null
        if(isNull(start, end)) {
            return;
        }
        heap(arr, leftChildIndex(start), end);
        heap(arr, rightChildIndex(start), end);

        // 有左孩子
        if(leftChildIndex(start) <= end ) {
            if(arr[leftChildIndex(start)] > arr[start]) {
                swap(arr, leftChildIndex(start), start);
            }
        }
        // 有右孩子
        if(rightChildIndex(start) <= end) {
            if(arr[rightChildIndex(start)] > arr[start]) {
                swap(arr, rightChildIndex(start), start);
            }
        }

    }

    private int leftChildIndex(int start) {
        return 2*start +1;
    }
    private int rightChildIndex(int start) {
        return 2*start +2;
    }

    private boolean isNull(int start, int end) {
        return start >end;
    }


}
