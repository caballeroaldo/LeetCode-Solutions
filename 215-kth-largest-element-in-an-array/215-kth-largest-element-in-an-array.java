class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickselect(int[] arr, int left, int right, int k) {
        if(left == right) {
            return arr[left];
        }
        
        int pivot = new Random().nextInt(right - left + 1)  + left;
        pivot = partition(arr, left, right, pivot);
        
        if(pivot == k) {
            return arr[k];
        } else if(pivot < k) {
            return quickselect(arr, pivot + 1, right, k);
        }
        return quickselect(arr, left, pivot - 1, k);
        
    }
    
    private int partition(int[] arr, int left, int right, int pIndex) {
        int pivot = arr[pIndex];
        swap(arr, pIndex, right);
        pIndex = left;
        
        for(int i = left; i <= right; i++ ) {
            if(arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        return pIndex - 1;
        
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}