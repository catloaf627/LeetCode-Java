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
            // System.out.printf("⭐️nums[i] = %d , nums[l] = %d, nums[r] = %d\n", nums[i], nums[l], nums[r]);
            System.out.println("For loop");
            while (l<r) {
                int gap = nums[i] + nums[l] + nums[r] - target;
                int abs_gap = Math.abs(gap);
                if (abs_gap < abs_minGap) {
                    minGap = gap;
                    abs_minGap = abs_gap;
                }
                // System.out.printf("🌸gap = %d, nums[i] = %d , nums[l] = %d, nums[r] = %d\n",gap, nums[i], nums[l], nums[r]);
                System.out.println("While loop");
                if (nums[l]+nums[r] < target-nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
            minGaps[i][0] = minGap;
            minGaps[i][1] = abs_minGap;
            // System.out.printf("i=%d, the sum which closest to target = %d\n", i, minGaps[i][0]+target);
        }
        Arrays.sort(minGaps, (a, b) -> Integer.compare(b[1], a[1]));
        System.out.printf("closest sum is %d, minGap is %d\n", minGaps[0][0] + target, minGaps[0][0]);
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
