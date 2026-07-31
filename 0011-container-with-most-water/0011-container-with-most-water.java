class Solution {
    public int maxArea(int[] height) {
         int left = 0;
         int result = 0;
            int right = height.length-1 ;
            int temp = 0;
        while ( left < right)
        {
           temp = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, temp);

           if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result ;
    }
}