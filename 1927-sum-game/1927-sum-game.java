class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumL = 0, sumR = 0;
        int qL = 0, qR = 0;
        
        // Calculate sums and '?' counts for the left half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                qL++;
            } else {
                sumL += num.charAt(i) - '0';
            }
        }
        
        // Calculate sums and '?' counts for the right half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                qR++;
            } else {
                sumR += num.charAt(i) - '0';
            }
        }
        
        // If the difference in sums can't be perfectly balanced by the difference in '?', Alice wins.
        return 2 * (sumL - sumR) != 9 * (qR - qL);
    }
}