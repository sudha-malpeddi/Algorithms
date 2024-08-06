package twopointers;

public class ContainerWithWater {
    public static int findLargestArea(int[] heights){
        int l = 0, r = heights.length-1;
        int maxArea = 0;
        while(l < r){
            int width = r-l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {1,7,2,5,4,7,3,6};
        System.out.println(findLargestArea(heights));
    }
}
