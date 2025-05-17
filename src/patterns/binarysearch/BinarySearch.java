package patterns.binarysearch;

public class BinarySearch {

    private int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public int lowerBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int upperBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
