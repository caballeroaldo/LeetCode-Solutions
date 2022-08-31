class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    perimeter += getPerimeter(grid, i, j); 
                }
            }
        }
        return perimeter;
    }
    
    private int getPerimeter(int[][] grid, int r, int c) {
        int count = 4 - (isLand(grid, r-1, c) +
                        isLand(grid, r, c-1) +
                        isLand(grid, r+1, c) +
                        isLand(grid, r, c+1));
        
        return count;
    }
    
    private int isLand(int[][] g, int r, int c) {
        if(r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == 0) {
            return 0;
        }
        
        return g[r][c];
    }
}