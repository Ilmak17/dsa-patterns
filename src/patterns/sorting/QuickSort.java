package patterns.sorting;

import java.util.Random;

public class QuickSort {
    private final Random random = new Random();

    public int partition(int[] arr, int low, int high) {
        int randomIndex = low + random.nextInt(high - low + 1);
        int temp = arr[low];
        arr[low] = arr[randomIndex];
        arr[randomIndex] = temp;

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }
        }

        int temp3 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp3;

        return j;
    }

    public void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pIndex - 1);
            quickSortHelper(arr, pIndex + 1, high);
        }
    }

    public int[] quickSort(int[] nums) {
        int n = nums.length;

        quickSortHelper(nums, 0, n - 1);

        return nums;
    }
}
