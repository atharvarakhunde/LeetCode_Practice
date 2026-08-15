class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();
        int n = senate.length();
        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rad.offer(i);
            } else {
                dir.offer(i);
            }
        }
        while (!rad.isEmpty() && !dir.isEmpty()) {
            int r_index = rad.poll();
            int d_index = dir.poll();
            
            if (r_index < d_index) {
                rad.offer(r_index + n);
            } else {
                dir.offer(d_index + n);
            }
        }
        
        return rad.isEmpty() ? "Dire" : "Radiant";
    }
}