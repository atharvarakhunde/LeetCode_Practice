class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set1 = new HashSet<>();        
        for(int i =0 ; i< arr.length ; i++){
            if(arr[i]== Integer.MIN_VALUE){
                continue;
            }
            int temp =1;
            for(int j =i+1 ; j< arr.length ; j++){
                
                if(arr[i] == arr[j]){
                    temp++;
                     arr[j] = Integer.MIN_VALUE;
                }
            }
            if(set1.contains(temp)){
                return false;
            }else{
                set1.add(temp);
            }
        } 
        return true ;
    }
}