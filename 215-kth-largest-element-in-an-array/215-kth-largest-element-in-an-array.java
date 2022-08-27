class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int kth) {
        if(left == right) {
            return nums[left];
        }
        
        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);
        
        if(pIndex == kth) {
            return nums[pIndex];
        } else if(pIndex < kth) {
            return quickSelect(nums, pIndex + 1, right, kth);
        }
        return quickSelect(nums, left, pIndex - 1, kth);
        
    }
    
    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;
        
        for(int i = left; i <= right; i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        
        return pIndex -1;
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
}