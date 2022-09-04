class Solution {
    public int orangesRotting(int[][] grid) {
        // Breadth First Search
        // Go through the entire grid to know where the Fresh and Rotten Oranges are
        int fresh = 0;
        Queue<int[]> track = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    track.offer(new int[] {i,j});
                }
            }
        }
        
        int time = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while(!track.isEmpty() && fresh != 0) {
            time++;
            int session = track.size();
            for(int i = 0; i < session; i++) {
                int[] rotten = track.poll();
                int row = rotten[0];
                int col = rotten[1];
                for(int[] dir: dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length &&
                       grid[x][y] == 1) {
                        grid[x][y] = 2;
                        track.offer(new int[] {x,y});
                        fresh--;
                    }
                }
            }
        }
        
        return fresh == 0 ? time : -1;
    }
}