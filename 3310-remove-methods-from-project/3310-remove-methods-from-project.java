class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList();
        for(int i=0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] inv : invocations){
            graph.get(inv[0]).add(inv[1]);
        }
        boolean[] isSuspicioous = new boolean[n];
        Queue <Integer> queue = new LinkedList<>();
        queue.add(k);
        isSuspicioous[k] = true ;
        // Finish BFS traversal to mark all suspicious nodes
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (!isSuspicioous[neighbor]) {
                    isSuspicioous[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // Check if any healthy node invokes a suspicious node
        boolean canRemove = true;
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
            if (!isSuspicioous[u] && isSuspicioous[v]) {
                canRemove = false;
                break;
            }
        }

        // Build and return the final result list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (canRemove) {
                if (!isSuspicioous[i]) {
                    result.add(i);
                }
            } else {
                result.add(i);
            }
        }

        return result;
    }
}