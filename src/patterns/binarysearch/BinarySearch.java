package patterns.binarysearch;

import java.util.Arrays;

public class BinarySearch {

    // -------------------------------------------------
    // 1. Classic Binary Search
    // -------------------------------------------------
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

    // -------------------------------------------------
    // 2. Lower Bound (First element >= target)
    // -------------------------------------------------
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


    // -------------------------------------------------
    // 3. Upper Bound (First element > target)
    // -------------------------------------------------
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


    // -------------------------------------------------
    // 4. Search in Rotated Sorted Array
    // -------------------------------------------------
    public int searchInRotatedArray(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == k) return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= k && k < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < k && nums[right] >= k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // -------------------------------------------------
    // 5. Binary Search on Answer – Koko Eating Bananas
    // -------------------------------------------------
    public int minimumRateToEatBananas(int[] nums, int h) {
        int maxVal = Integer.MIN_VALUE;

        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }
        int low = 1;
        int high = maxVal;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = getHours(nums, mid);

            if (hours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int getHours(int[] nums, int num) {
        int sum = 0;

        for (int n : nums) {
            sum += (int) Math.ceil((double) n / num);
        }

        return sum;
    }

    // -------------------------------------------------
    // 6. Binary Search on Answer – Aggressive Cows
    // -------------------------------------------------
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 1;
        int high = nums[nums.length - 1] - nums[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(nums, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canPlace(int[] nums, int dist, int k) {
        int last = nums[0];
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= dist) {
                cnt++;
                last = nums[i];
            }
            if (cnt >= k) return true;
        }

        return false;
    }

    // -------------------------------------------------
    // 7. Find Peak Element
    // -------------------------------------------------
    public int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // -------------------------------------------------
    // 8. Median of Two Sorted Arrays (Hard)
    // -------------------------------------------------
    public double medianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;

        if (n1 > n2) return medianOfTwoSortedArrays(arr2, arr1);

        int n = n1 + n2;

        int left = (n1 + n2 + 1) / 2;

        int low = 0, high = n1;
        while (low <= high) {

            int mid1 = (low + high) >>> 1;

            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }


    // -------------------------------------------------
    // 9. Binary Search in 2D Matrix
    // -------------------------------------------------
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == target) return true;
            else if (mat[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

}
