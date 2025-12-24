import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // If duplicate found inside window
            if (set.contains(nums[right])) {
                return true;
            }

            set.add(nums[right]);

            // Shrink window if size exceeds k
            if (right - left >= k) {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
