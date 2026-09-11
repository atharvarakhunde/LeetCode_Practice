class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequency of each digit in the input array
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int validCount = 0;

        // Iterate through all 3-digit even numbers
        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100;       // Hundreds digit
            int d2 = (i / 10) % 10; // Tens digit
            int d3 = i % 10;        // Units digit

            // Count frequency required for the current number
            int[] currentCount = new int[10];
            currentCount[d1]++;
            currentCount[d2]++;
            currentCount[d3]++;

            // Check if input array has sufficient digits
            if (currentCount[d1] <= count[d1] &&
                currentCount[d2] <= count[d2] &&
                currentCount[d3] <= count[d3]) {
                validCount++;
            }
        }

        return validCount;
    }
}