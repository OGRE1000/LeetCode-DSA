class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // If current element is 0, increase zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zero count exceeds k, shrink window from left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update maximum window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
