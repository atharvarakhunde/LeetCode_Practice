class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int balance = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0)
                balance--;
            else
                balance++;

            if (map.containsKey(balance)) {
                count = Math.max(count, i - map.get(balance));
            } else {
                map.put(balance, i);
            }
        }

        return count;
    }
}