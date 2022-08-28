class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) {
            return nums[left];
        }
        
        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);
        if(pIndex == k) {
            return nums[pIndex];
        } else if(pIndex < k) {
            return quickSelect(nums, pIndex + 1, right, k);
        }
        return quickSelect(nums, left, pIndex - 1, k);
    }
    
    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, right, pIndex);
        pIndex = left;
        for(int i = left; i <= right; i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        
        return pIndex -1;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}