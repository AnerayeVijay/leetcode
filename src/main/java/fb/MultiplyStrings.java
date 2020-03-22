package fb;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int result = 0;

        if (num1 == null || num2 == null) return sb.toString();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        for (int j = l2; j >= 0; j--) {
            int result2 = 0;
            int carry = 0;
            for (int i = l1; i >= 0; i--) {
                int c1 = num1.charAt(i) - '0';
                int c2 = num2.charAt(j) - '0';
                int mult = c1 * c2;
                result2 = carry + result2 * 10 + (mult) % 10;
                carry = mult / 10;
            }
            if(carry>0){
                result2+=carry;
            }
            result += result2;
        }
        return "" + result;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
