class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reservedMap = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            int mask = reservedMap.getOrDefault(row, 0);
            
            if (col >= 2 && col <= 5) {
                mask |= 1;
            }
            if (col >= 4 && col <= 7) {
                mask |= 2;
            }
            if (col >= 6 && col <= 9) {
                mask |= 4;
            }
            
            reservedMap.put(row, mask);
        }
        
        int maxGroups = (n - reservedMap.size()) * 2;
        
        for (int mask : reservedMap.values()) {
            if ((mask & 1) == 0 && (mask & 4) == 0) {
                maxGroups += 2;
            } else if ((mask & 1) == 0 || (mask & 2) == 0 || (mask & 4) == 0) {
                maxGroups += 1;
            }
        }
        
        return maxGroups;
    }
}