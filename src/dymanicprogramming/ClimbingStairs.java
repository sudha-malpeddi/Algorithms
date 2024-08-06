package dymanicprogramming;

public class ClimbingStairs {
    public static int findDistinctWays(int n){
        int x =1, y = 1;

        for(int i = 0; i< n-1; i++){
            int temp = x;
            x = x+y;
            y = temp;
        }
        return x;
    }
    public static void main(String[] args) {
        int n = 5;
        //Each time you can either climb 1 or 2 steps.
        // In how many distinct ways can you climb to the top?
        System.out.println(findDistinctWays(n));
    }
}
