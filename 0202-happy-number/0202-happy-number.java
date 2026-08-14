class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);       
            n = digsquare(n);  
        }
        return n == 1;
    }
    public int digsquare(int n){
        int sum =0;
        while(n != 0){
            sum += Math.pow(n%10,2);
            n /=10 ;
        }
        return sum;
    }
}