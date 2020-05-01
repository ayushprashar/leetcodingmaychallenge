public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
            return innerFBV(1,n);
    }
    private int innerFBV(int start, int end) {
        int mid = (start + end)/2;
        boolean isBad = isBadVersion(mid);
        if(isBad) {
            if(mid - 1 > 0 && !isBadVersion(mid-1))
                return mid;
            if(mid == 1)
                return 1;
            return innerFBV(start, mid -1);
        } else {
            if(mid + 1<=end && isBadVersion(mid+1)) {
                return mid+1;
            } else
                return innerFBV(mid+1, end);
        }
    }
}