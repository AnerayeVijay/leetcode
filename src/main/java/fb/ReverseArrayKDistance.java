package fb;

import java.util.Arrays;

/**
 * reverse an array for k distance.
 * [2,3,1,5,4] and k =3
 * output : [2,3,1,5,4]
 * method
 * void reverse(int[] arr, k)
 *
 * this method will only reverse the array
 *
 * write another method which will sort the array by incorporating reverse method inside sort.
 *
 * You must have to call reverse(arr,k) method to sort the array. You are not allowed to modify the reverse method
 */
public class ReverseArrayKDistance {

    public static int[] reverse( int []arr,int k) {
        int totalOp = (int)Math.floor(k / 2);

        for (int i = 0; i < totalOp; i++) {
            int newIndex = k - 1 - i;
            if (arr[i] < arr[newIndex]) {
                continue;
            }

            // swap
            int temp = arr[newIndex];
            arr[newIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,6,4,5};
        int k = 3;
        Arrays.stream(reverse(array, k)).forEach( t -> System.out.println(t));
    }

}
