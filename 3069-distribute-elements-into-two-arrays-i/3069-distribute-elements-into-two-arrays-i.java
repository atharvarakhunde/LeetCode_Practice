class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int x = 2 ;
        while(x<nums.length){
            if(list1.getLast() > list2.getLast()){
                list1.add(nums[x]);
            }else{
                list2.add(nums[x]);
            }
            x++;
        }
        list1.addAll(list2);
        int[] res = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            res[i] = list1.get(i);
        }
        return res;
    }
}