package fb.helper;

public class SVNRepo {
    public static boolean isBadVersion(int k) {
        return k<10 ? false : true;
    }
}
