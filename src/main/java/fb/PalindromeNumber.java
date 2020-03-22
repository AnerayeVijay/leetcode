package fb;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 *
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if(x<0) return true;
        if(x>0 && x<10) return true;
        int reverse =0;
        int number =x;
        while(x!=0){
            reverse = reverse *10 + x%10;
            x=x/10;
        }
        return number==reverse ? true :false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}