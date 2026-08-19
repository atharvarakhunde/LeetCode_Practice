class Solution {
    public void sortColors(int[] nums) {
    //Dutch national flag problem 
    // in this problem we make a range and according to the values we add them into their range 
    // like for 0's we make start to low-1
    // for 1's we have low to mid 
    // for 2's we have high to end 
    // Now you are able to solve it easily 
    int high = nums.length-1;
    int low = 0;
    int mid =0;

    while (mid <= high){
        if(nums[mid]== 0){
            swap(nums , low , mid);
            low++;
            mid++;
        } else if (nums[mid] == 1){
            mid++;
        }
        else{
            swap(nums, mid , high);
            high--;
        }
    }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
  
}