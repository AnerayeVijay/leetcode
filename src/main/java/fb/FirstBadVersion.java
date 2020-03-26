package fb;

import fb.helper.SVNRepo;

public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left)/2 ;
            if(!SVNRepo.isBadVersion(mid)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
