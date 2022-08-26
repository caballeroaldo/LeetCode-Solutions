class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Initialize empty list for subsets
        res.add(new ArrayList<>());
        
        // Goes through every integer in array
        for(int i = 0; i < nums.length; i++) {
            int n = res.size();
            // Based on the current size of the res list, add current number to set
            for(int j = 0; j < n; j++) {
                List<Integer> set = new ArrayList<>(res.get(j));
                set.add(nums[i]);
                res.add(set);
            }
            
        }
        
        return res;
        
    }
}