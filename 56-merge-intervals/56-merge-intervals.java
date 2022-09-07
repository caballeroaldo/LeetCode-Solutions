class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        answer.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int prevStart = answer.get(answer.size() -1)[0];
            int currentStart = intervals[i][0];
            
            if(currentStart <= answer.get(answer.size() - 1)[1]) {
                answer.get(answer.size() - 1)[1] =
                    Math.max(answer.get(answer.size() - 1)[1], intervals[i][1]);
            } else {
                answer.add(intervals[i]);
            }
        }
        int[][] result = new int[answer.size()][2];
        answer.toArray(result);
        return result;
        
    }
}