class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Initializes the min Heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> 
            Integer.compare((a[0]*a[0]+a[1]*a[1]), (b[0]*b[0]+b[1]*b[1])));
        
        // Adds the points from input matrix to heap
        for(int[] p : points) {
            queue.add(p);
        }
        
        // Initializes Matrix set to have k rows of 2 columns (x,y) coordinates
        // Will the k points closest to the origin (0,0)
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] curr = queue.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
        }
        
        return ans;
        
    }
}