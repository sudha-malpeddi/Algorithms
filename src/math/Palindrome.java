package math;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isNumberPalindrome(1321));
    }

    private static boolean isNumberPalindrome(int num) {
        int div = 1;
        while(num > div * 10){
            div *= 10;
        }

        while(num != 0){
            int right = num % 10;
            int left = num / div ;
            if(right != left)
                return false;

            num = num % div;
            num = num/10;
            div = div/100;
        }
        return true;
    }
}
