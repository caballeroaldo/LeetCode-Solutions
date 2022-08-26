class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Queue will keep track of order for which num and location to be added
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        
        // Iterate through nums adding until permutations are 
        // same length as input array nums
        for(int currentNum : nums) {
            int n = permutations.size();
            for(int i = 0; i < n; i++) {
                List<Integer> oldPerm = permutations.poll();
                for(int j = 0; j <= oldPerm.size(); j++) {
                    // Copy old list into new one to insert currentNum at index j
                    List<Integer> newPerm = new ArrayList<Integer>(oldPerm);
                    newPerm.add(j,currentNum);
                    if(newPerm.size() == nums.length) {
                        res.add(newPerm);
                    } else {
                        permutations.add(newPerm);
                    }
                }
            }            
        }
        return res;
        
    }
}