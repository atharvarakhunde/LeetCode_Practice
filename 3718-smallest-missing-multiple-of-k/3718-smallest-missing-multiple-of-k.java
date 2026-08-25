class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set =  new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int temp = k ;
        while(true){
            System.out.println(k);
            if(!set.contains(k)){
                return k;
            }
            k += temp ;
            
        }

    }
}