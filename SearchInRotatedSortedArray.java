import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // edge case 1: nums = {}
        if (nums.length == 0) {
            return -1;
        }
        // edge case 2: nums = {3,1,2}
        if (nums.length <= 3) {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        // MAIN
        // Sorted
        if (nums[0] < nums[nums.length-1]) {
            return binarySearchOnSortedArray(nums, 0, nums.length-1, target);
        }
        // Rotated
        int l = 0;
        int r = nums.length-1;
        while (l<r) {
            System.out.printf("l=%d, r=%d \n", l, r);
            int mid = (l+r)/2;
            if (nums[mid] == target) {
                return mid;
            }
            boolean leftPartIsSorted = nums[l] <= nums[mid] ? true : false;
            boolean rightPartIsSorted = nums[mid+1] <= nums[r] ? true : false;
            if (leftPartIsSorted) {
                if (nums[l] <= target && target <= nums[mid]) {
                    System.out.printf("LEFT: nums = %s, mid+1 = %d, r = %d\n", Arrays.toString(nums), l, mid);
                    return binarySearchOnSortedArray(nums, l, mid, target);
                } else {
                    l = mid+1; // target in right side 
                }
            }
            if (rightPartIsSorted) {
                if (nums[mid+1] <= target && target <= nums[r]) {
                    System.out.printf("RIGHT: nums = %s, mid+1 = %d, r = %d\n", Arrays.toString(nums), mid+1, r);
                    return binarySearchOnSortedArray(nums, mid+1, r, target);
                } else {
                    r = mid; // target in left side 
                }
            }
            // DO NOT EXIST CONDITION THAT BOTH SIDE ARE NOT SORTED
        }
        return -1;
    }

    public int binarySearchOnSortedArray(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = (start+end)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) { // target on left
                end = mid-1;
            } else { // target on right
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // LC 33
        int[] nums = {3,4,5,6,1,2};
        int target = 2;
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        int result = sol.search(nums, target);
        System.out.println("The result is " + result);
    }
}
