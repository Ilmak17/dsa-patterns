package patterns.binarysearch;

import java.util.Arrays;

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

}
