import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        for (int i=0; i<nums.length-2; i++) { // The i-th value is the smallest among the triplet
            int l = i+1;
            int r = nums.length-1;
            int i_minGap = Integer.MAX_VALUE;
            while (l<r) {
                int gap = nums[i] + nums[l] + nums[r] - target;
                if (Math.abs(gap) < Math.abs(i_minGap)) {
                    i_minGap = gap;
                    if (i_minGap == 0) return target;
                }
                if (nums[l]+nums[r] < target-nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
            if (Math.abs(i_minGap) < Math.abs(minGap)) {
                minGap = i_minGap;
            }
        }
        return minGap + target;
    }
    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int result = sol.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
