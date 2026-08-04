class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>(nums.length);
        // List<Integer> list = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        for (int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        
        while(min<=max){
            if(set.contains(min)){
                set.remove(min);
                
            }else{
                set.add(min);
            }
            min++;
        }

        // for(int i=min; i<=max; i++){
        //     if(!set.contains(i)){
        //         list.add(i);
        //     }
        // }
        // return list;

        return new ArrayList<>(set);

    }
}