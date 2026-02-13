import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

    public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) { // Four indexes: m, n, i, j
            if(nums.length < 4) return new ArrayList<>();
            Arrays.sort(nums);
            Set<String> strSet = new HashSet<>();
            for (int m=0; m<nums.length-3; m++) {
                for (int n=m+1; n<nums.length-2; n++) {
                    long twoSumTarget = (long)target - nums[m] - nums[n]; // avoid overflow
                    int i = n+1;
                    int j = nums.length-1;
                    while (i<j) {
                        int sum = nums[i]+nums[j];
                        if (sum<twoSumTarget) {
                            i++;
                        }
                        if (sum>twoSumTarget) {
                            j--;
                        }
                        if (sum==twoSumTarget) { //Found one!
                            int[] quadruplets = new int[4];
                            quadruplets[0] = nums[m];
                            quadruplets[1] = nums[n];
                            quadruplets[2] = nums[i];
                            quadruplets[3] = nums[j];
                            Arrays.sort(quadruplets);
                            String str = String.valueOf(quadruplets[0]) + "|" + String.valueOf(quadruplets[1])+ "|" + String.valueOf(quadruplets[2])+ "|" + String.valueOf(quadruplets[3]);
                            strSet.add(str);
                            i++; //Or j--; whatever
                        }
                    }
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            for (String str : strSet) {
                String[] fourParts = str.split("\\|");
                List<Integer> comb = new ArrayList<>();
                comb.add(Integer.parseInt(fourParts[0]));
                comb.add(Integer.parseInt(fourParts[1]));
                comb.add(Integer.parseInt(fourParts[2]));
                comb.add(Integer.parseInt(fourParts[3]));
                res.add(comb);
            }
            return res;
        }

        public static void main(String[] args) {
            FourSum sol = new FourSum();
            int[] input = {1000000000,1000000000,1000000000,1000000000};
            int target = -294967296;
            List<List<Integer>> output = sol.fourSum(input, target);
            System.out.println(output);
        }
    
}
