class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i<intervals.length){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }

            list.add(new int[]{start, end});
            i++;
            }
    
        return list.toArray(new int [list.size()][]);
    }
}