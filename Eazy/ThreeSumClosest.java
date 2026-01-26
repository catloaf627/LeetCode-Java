import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[][] minGaps = new int[nums.length-2][2]; // the second place stores the absolute of the first place
        for (int i=0; i<nums.length-2; i++) { // The i-th value is the smallest among the triplet
            int l = i+1;
            int r = nums.length-1;
            int minGap = Integer.MAX_VALUE;
            int abs_minGap = Integer.MAX_VALUE;
            while (l<r) {
                int gap = nums[i] + nums[l] + nums[r] - target;
                int abs_gap = Math.abs(gap);
                if (abs_gap < abs_minGap) {
                    minGap = gap;
                    abs_minGap = abs_gap;
                }
                if (nums[l]+nums[r] < target-nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
            minGaps[i][0] = minGap;
            minGaps[i][1] = abs_minGap;
        }
        Arrays.sort(minGaps, (a, b) -> Integer.compare(a[1], b[1]));
        System.out.println(Arrays.deepToString(minGaps));
        return minGaps[0][0] + target;
    }
    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int result = sol.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
