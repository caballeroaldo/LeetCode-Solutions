class Solution {
    public int search(int[] nums, int target) {
        return recurse(nums, target, 0, nums.length - 1);
    }
    
    private int recurse(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if(start > end) {
            return -1;
        }
        if(target == nums[mid]) {
            return mid;
        } 
        if (target < nums[mid]) {
            return recurse(nums, target, start, mid -1); 
        } 
        if(target > nums[mid]) {
            return recurse(nums, target, mid +1, end);
        }
        
        return -1;
    }
}