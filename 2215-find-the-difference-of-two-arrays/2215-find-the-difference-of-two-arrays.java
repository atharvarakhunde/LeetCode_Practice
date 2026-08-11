class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
       List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        for(int i = 0 ; i < nums1.length;i++){
            boolean b = false;
            for(int j = 0 ; j< nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    b= true ;
                    break;
                }
            }
            if (!b && !list.get(0).contains(nums1[i])) {
                list.get(0).add(nums1[i]);
            }
        }
        for(int i = 0 ; i < nums2.length;i++){
            boolean b = false;
            for(int j = 0 ; j< nums1.length;j++){
                if(nums2[i]==nums1[j]){
                    b= true ;
                    break;
                }
            }
              if (!b && !list.get(1).contains(nums2[i])) {
                list.get(1).add(nums2[i]);
            }
        }
        return list ;
    }
}