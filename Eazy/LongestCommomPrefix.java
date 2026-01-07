public class LongestCommomPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // O(n), find longest string
        String longestStr = strs[0];
        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            if (strs[i].length() > longestStr.length()) {
                longestStr = strs[i];
            }
        }
        // For each string, trim the common prefix little by little 
        String commonPrefix = longestStr;
        for (int i=0; i<strs.length; i++) {
            String currentStr = strs[i];
            int sameLength = currentStr.length() < commonPrefix.length() ? currentStr.length() : commonPrefix.length(); // shorter length
            currentStr = currentStr.substring(0, sameLength);
            commonPrefix = commonPrefix.substring(0, sameLength);
            for (int j=0; j<sameLength; j++) {
                if (commonPrefix.charAt(j) != currentStr.charAt(j)) {
                    commonPrefix = commonPrefix.substring(0, j);
                    break;
                }
            }
        }

        return commonPrefix;
    }

    public static void main(String[] args) {
        LongestCommomPrefix sol = new LongestCommomPrefix();

        // 0014
        String[] input = {"abn","a"};
        String result = sol.longestCommonPrefix(input);
        System.out.println(result);
        
    }
    
}
