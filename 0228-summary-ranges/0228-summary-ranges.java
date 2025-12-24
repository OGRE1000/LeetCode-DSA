import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        int left = 0;

        while (left < n) {
            int right = left;

            // Extend the range while consecutive numbers exist
            while (right + 1 < n && nums[right + 1] == nums[right] + 1) {
                right++;
            }

            // Build the range string
            if (nums[left] == nums[right]) {
                result.add(String.valueOf(nums[left]));
            } else {
                result.add(nums[left] + "->" + nums[right]);
            }

            // Move to next range
            left = right + 1;
        }

        return result;
    }
}
