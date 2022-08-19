/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Binary Search
        int start = 1;
        int end = n;
        int answer = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}