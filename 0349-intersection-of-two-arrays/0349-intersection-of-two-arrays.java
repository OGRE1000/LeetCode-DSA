import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);

                int val = nums1[i];
                // Skip duplicates in nums1
                while (i < nums1.length && nums1[i] == val) i++;
                // Skip duplicates in nums2
                while (j < nums2.length && nums2[j] == val) j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert list to array
        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }
}
