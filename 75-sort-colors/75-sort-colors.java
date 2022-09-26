class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                swap(nums, i, zeros);
                zeros++;
            }
        }
        
        int ones = zeros;
        for(int j = ones; j < nums.length; j++ ) {
            if(nums[j] == 1) {
                swap(nums,j,ones);
                ones++;
            }
        }
        int twos = ones;
        for(int k = twos; k < nums.length && twos < nums.length; k++) {
            if(nums[k] == 2 ) {
                swap(nums,k,twos);
                twos++;
            }
        }
    }
    
    private void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
        
    }
}