package stack;

import java.util.Stack;

import static java.lang.Math.max;

public class AreaInHistogram {
    public static class Pair{
        int index, height;
        Pair(int index, int height){
            this.height = height;
            this.index = index;
        }
    }
    public static int largestRectangleArea(int[] heights){
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();

        for(int i =0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && heights[i] <= stack.peek().height){
                Pair pair = stack.pop();
                int height = pair.height;
                int index = pair.index;
                maxArea = max(maxArea, height * (i-index));
                start = index;
            }
            stack.push(new Pair(start, heights[i]));
        }

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int height = pair.height;
            int index = pair.index;
            maxArea = max(maxArea, height * (heights.length-index));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
