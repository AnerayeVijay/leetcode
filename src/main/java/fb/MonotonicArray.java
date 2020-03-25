package fb;

public class MonotonicArray {

    public static boolean isMonotonic(int[] A) {
        boolean incresing = true;
        boolean decresing = true;
        if(A.length <2 ) return true;

        for(int i=1; i<A.length; i++) {
            if(A[i]>=A[i-1]) {
                decresing =false;
            }else {
                incresing =false;
            }
        }
        return incresing || decresing;
    }

    public static void main(String[] args) {
        int A[] = {1,2,2,3};
        System.out.println(isMonotonic(A));
    }
}
