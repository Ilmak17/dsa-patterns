package patterns.heap;

public class Heap {

    public void heapify(int[] nums, int ind, int val) {
        if (nums[ind] > val) {
            nums[ind] = val;
            heapifyUp(nums, ind);
        } else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }

    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length;

        int smallest_Ind = ind;

        int leftChild_Ind = 2 * ind + 1;
        int rightChild_Ind = 2 * ind + 2;

        if (leftChild_Ind < n && arr[leftChild_Ind] < arr[smallest_Ind]) {
            smallest_Ind = leftChild_Ind;
        }

        if (rightChild_Ind < n && arr[rightChild_Ind] < arr[smallest_Ind]) {
            smallest_Ind = rightChild_Ind;
        }

        if (smallest_Ind != ind) {
            int temp = arr[smallest_Ind];
            arr[smallest_Ind] = arr[ind];
            arr[ind] = temp;

            heapifyDown(arr, smallest_Ind);
        }
    }

    private void heapifyUp(int[] arr, int ind) {
        int parent_Ind = (ind - 1) / 2;

        if (ind > 0 && arr[ind] < arr[parent_Ind]) {
            int temp = arr[ind];
            arr[ind] = arr[parent_Ind];
            arr[parent_Ind] = temp;

            heapifyUp(arr, parent_Ind);
        }
    }
}
