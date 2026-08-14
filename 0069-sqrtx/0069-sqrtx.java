class Solution {
    public int mySqrt(int x) {
        // Base case for 0
        if (x == 0) return 0;
        
        int left = 1;
        int right = x;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use division instead of multiplication (mid * mid) to avoid integer overflow
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1; // The square root is greater than mid
            } else {
                right = mid - 1; // The square root is less than mid
            }
        }
        
        // When the loop ends, 'right' will be pointing to the rounded-down square root
        return right;
    }
}