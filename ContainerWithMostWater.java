public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = w * h;
            maxArea = area > maxArea ? area : maxArea;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        // int[] input = {1,8,6,2,5,4,8,3,7};
        int[] input = {1,8,9};

        int result = sol.maxArea(input);
        System.out.println(result);
    }
}
