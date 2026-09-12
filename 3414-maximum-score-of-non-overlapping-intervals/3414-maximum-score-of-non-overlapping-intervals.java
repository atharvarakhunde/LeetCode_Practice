import java.util.*;

class Solution {
    // Custom class to manage maximum weight and lexicographically smallest indices
    static class State {
        long weight = 0;
        List<Integer> indices = new ArrayList<>();

        State() {}

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = new ArrayList<>(indices);
        }

        // Returns true if 'this' state is strictly better than 'other'
        boolean isBetterThan(State other) {
            if (this.weight != other.weight) {
                return this.weight > other.weight; // Maximize sum of weights
            }
            // Tie-break: lexicographically smaller indices list
            int len = Math.min(this.indices.size(), other.indices.size());
            for (int i = 0; i < len; i++) {
                if (!this.indices.get(i).equals(other.indices.get(i))) {
                    return this.indices.get(i) < other.indices.get(i);
                }
            }
            return this.indices.size() < other.indices.size();
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // Store original indices and sort them by right endpoint
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> Integer.compare(intervals.get(a).get(1), intervals.get(b).get(1)));

        int[] rights = new int[n];
        for (int i = 0; i < n; i++) {
            rights[i] = intervals.get(order[i]).get(1);
        }

        State[] prev = new State[n + 1];
        for (int i = 0; i <= n; i++) prev[i] = new State();

        // Pick at most 4 non-overlapping intervals
        for (int k = 1; k <= 4; k++) {
            State[] cur = new State[n + 1];
            cur[0] = new State();

            for (int p = 1; p <= n; p++) {
                int i = order[p - 1];
                int l = intervals.get(i).get(0);
                long w = intervals.get(i).get(2);

                // Binary search for largest index j such that rights[j] < l
                int j = binarySearch(rights, l);

                // Option 1: Pick interval i
                State take = new State(prev[j].weight + w, prev[j].indices);
                take.indices.add(i);
                Collections.sort(take.indices);

                // Option 2: Skip interval i
                State skip = cur[p - 1];

                cur[p] = take.isBetterThan(skip) ? take : skip;
            }
            prev = cur;
        }

        List<Integer> bestIndices = prev[n].indices;
        int[] result = new int[bestIndices.size()];
        for (int i = 0; i < bestIndices.size(); i++) {
            result[i] = bestIndices.get(i);
        }

        return result;
    }

    private int binarySearch(int[] rights, int target) {
        int low = 0, high = rights.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (rights[mid] < target) {
                ans = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}