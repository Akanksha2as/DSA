//https://leetcode.com/problems/first-bad-version/submissions/1674304105/?envType=problem-list-v2&envId=binary-search
class VersionControl {
    boolean isBadVersion(int version) {
        return version >= 8; 
    }
}

public class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        BadVersion sol = new BadVersion();
        int n = 10;
        System.out.println("First Bad Version: " + sol.firstBadVersion(n));
    }
}
