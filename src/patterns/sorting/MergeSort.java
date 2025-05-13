package patterns.sorting;

public class MergeSort {

    public int[] sort(int[] arr) {
        mergeSort(arr);

        return arr;
    }

    private void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int k = 0;

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tmp[k++] = arr[left++];
            } else {
                tmp[k++] = arr[right++];
            }
        }

        while (left <= mid) tmp[k++] = arr[left++];
        while (right <= high) tmp[k++] = arr[right++];

        for (int i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }
    }
}
