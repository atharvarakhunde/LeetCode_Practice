class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // A linked list must have at least 3 nodes to form a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            // Check for local maxima or local minima
            boolean isMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (isMaxima || isMinima) {
                if (firstIndex == -1) {
                    firstIndex = index;
                } else {
                    minDistance = Math.min(minDistance, index - prevIndex);
                }
                prevIndex = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Return [-1, -1] if fewer than two critical points were found
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
    }
}