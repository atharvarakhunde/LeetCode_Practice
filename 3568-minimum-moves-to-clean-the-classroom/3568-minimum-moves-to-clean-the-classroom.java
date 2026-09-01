import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int maxEnergy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        List<int[]> litterList = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterList.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitter = litterList.size();
        if (totalLitter == 0) return 0; // No litter to collect
        
        int targetMask = (1 << totalLitter) - 1;
        
        // Map litter positions to indices for easy bitmask manipulation
        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(litterIdx[i], -1);
        for (int i = 0; i < totalLitter; i++) {
            litterIdx[litterList.get(i)[0]][litterList.get(i)[1]] = i;
        }
        
        // 3D array for state pruning: max energy recorded at (r, c, mask)
        int[][][] bestEnergy = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        // Queue for BFS: {row, col, mask, current_energy}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0, maxEnergy});
        bestEnergy[startX][startY][0] = maxEnergy;
        
        int steps = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], mask = curr[2], e = curr[3];
                
                if (mask == targetMask) {
                    return steps;
                }
                
                if (e == 0) continue; // Out of energy, cannot move further
                
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        char cell = classroom[nr].charAt(nc);
                        int nextMask = mask;
                        
                        if (cell == 'L') {
                            int idx = litterIdx[nr][nc];
                            nextMask |= (1 << idx);
                        }
                        
                        int nextEnergy = e - 1;
                        if (cell == 'R') {
                            nextEnergy = maxEnergy; // Reset energy to full capacity
                        }
                        
                        // Prune state if we reached (nr, nc, nextMask) with less or equal energy
                        if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                            bestEnergy[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}