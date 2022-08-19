class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(sums.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = sums.get(target - nums[i]);
            } else {
                sums.put(nums[i], i);
            }
        }
        return res;
        
        
    }
}