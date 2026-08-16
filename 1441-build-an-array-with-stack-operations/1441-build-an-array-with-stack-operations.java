class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : target) {
            set.add(num);
        }
         n = target[target.length - 1];
        for(int i =1 ; i <= n ; i++ ){
            list.add("Push");
            if(!set.contains(i)){
                list.add("Pop");
            }
        }
        return list ; 
    }
}