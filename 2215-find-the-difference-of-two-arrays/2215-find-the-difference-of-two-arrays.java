class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> m1 = new HashSet<>();
        Set<Integer> m2 = new HashSet<>();
        for(int n : nums1) m1.add(n);
        for(int n : nums2) m2.add(n);
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for(int n : m1){
            if(!m2.contains(n)) ans1.add(n);
        }

        for(int n : m2){
            if(!m1.contains(n)) ans2.add(n);
        }

        List<List<Integer>> ans = Arrays.asList(ans1,ans2);
        return ans;
    }
}