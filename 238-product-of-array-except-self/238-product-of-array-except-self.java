class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // Prefix will be multiplied into result array and updated after
        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        
        // Postfix will multiple with the value in the result array 
        // and update after to include the next integer for the next integer
        int postfix = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            result[j] *= postfix;
            postfix *= nums[j];
        }
        
        return result;
    }
}