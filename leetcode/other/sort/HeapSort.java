package other.sort;

/**
 * @author ghower
 * @date 2022/3/10 17:15
 */
public class HeapSort {
    public static void main(String[] args) {

    }

    public void heapSort(int[] arr) {
        /**
         * 1. 先将数组转成堆结构
         * 4. 循环，每次让一个元素有序，
         *  2. 将堆结构不断调整
         *  3. 堆顶元素和最后叶子节点交换
         */
        // 大根堆
        for (int end = arr.length - 1; end > 0; end++) {
            maxHeap(arr, end);
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;
        }

    }

    private void maxHeap(int[] arr, int end) {
        // 最后父节点
        int lastFather = end % 2 != 0 ? end / 2 : end / 2 + 1;
        // 左右孩子
        int left = lastFather * 2 +1;
        int right = lastFather * 2 +2;
        for (int father = lastFather; father >= 0; father--) {
            // 三者取最大
            if(right <= end && arr[right] > arr[father]){
                int temp = arr[right];
                arr[right] = arr[father];
                arr[father] = temp;
            }
            if(arr[left] > arr[father]){
                int temp = arr[right];
                arr[right] = arr[father];
                arr[father] = temp;
            }
        }
    }

    private void minHeap(int[] arr, int end) {

    }
}
