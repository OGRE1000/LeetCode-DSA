class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0; // position for next non-zero element

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // Fill remaining positions with zero
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
