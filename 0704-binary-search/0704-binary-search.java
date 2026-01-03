class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevent integer overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // target found
            } 
            else if (nums[mid] < target) {
                left = mid + 1; // search right half
            } 
            else {
                right = mid - 1; // search left half
            }
        }

        // target not found
        return -1;
    }
}
