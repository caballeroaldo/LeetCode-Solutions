class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int i : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += i;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
        
    }
}