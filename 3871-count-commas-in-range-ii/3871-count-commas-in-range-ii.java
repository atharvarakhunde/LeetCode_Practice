class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long threshold = 1000;
        
        while (n >= threshold) {
            ans += (n - threshold + 1);
            
            // Check for overflow before multiplying threshold by 1000
            if (threshold > Long.MAX_VALUE / 1000) {
                break;
            }
            threshold *= 1000;
        }
        
        return ans;
    }
}