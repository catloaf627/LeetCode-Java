import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

    public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if(nums.length < 4) return new ArrayList<>();

            Set<String> strSet = new HashSet<>();
            for (int split=2; split<nums.length-1; split++) {
                // First part
                HashMap<Integer, List<List<Integer>>> map1 = new HashMap<>();
                for (int i=0; i<split-1; i++) {
                    for (int j=i+1; j<split; j++) {
                        Integer key = nums[i]+nums[j];
                        List<List<Integer>> valueList = new ArrayList<>();
                        if (map1.containsKey(key)) {
                            valueList = map1.get(key);
                        }
                        List<Integer> newPair = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j]));
                        valueList.add(newPair);
                        map1.put(key, valueList);
                    }
                }
                System.out.println("split= " + split + ", map1 is " + map1);
                // Second part
                HashMap<Integer, List<List<Integer>>> map2 = new HashMap<>();
                for (int i=split; i<nums.length-1; i++) {
                    for (int j=i+1; j<nums.length; j++) {
                        Integer key = nums[i]+nums[j];
                        List<List<Integer>> valueList = new ArrayList<>();
                        if (map2.containsKey(key)) {
                            valueList = map2.get(key);
                        }
                        List<Integer> newPair = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j]));
                        valueList.add(newPair);
                        map2.put(key, valueList);
                    }
                }
                System.out.println("split= " + split + ", map2 is " + map2);
                // Check
                for (int key1 : map1.keySet()) {
                    for (int key2 : map2.keySet()) {
                        if (key1 + key2 == target) {
                            for (List<Integer> firsttwo: map1.get(key1)) {
                                for (List<Integer> lasttwo: map2.get(key2)) {
                                    int[] fourNums = new int[4];
                                    fourNums[0] = firsttwo.get(0);
                                    fourNums[1] = firsttwo.get(1);
                                    fourNums[2] = lasttwo.get(0);
                                    fourNums[3] = lasttwo.get(1);
                                    Arrays.sort(fourNums);
                                    String quadrupletsStr = String.valueOf(fourNums[0]) + "|" + String.valueOf(fourNums[1]) + "|" + String.valueOf(fourNums[2]) + "|" + String.valueOf(fourNums[3]);                       
                                    strSet.add(quadrupletsStr);
                                }
                            }
                        }
                    }
                }

            }
            // System.out.println(strSet);
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
            int[] input = {1,0,-1,0,-2,2};
            int target = 0;
            List<List<Integer>> output = sol.fourSum(input, target);
            System.out.println(output);
        }
    
}
