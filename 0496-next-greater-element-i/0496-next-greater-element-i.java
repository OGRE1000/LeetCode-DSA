class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int indexInNums2 = -1;

            // Step 1: Find index of nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == target) {
                    indexInNums2 = j;
                    break;
                }
            }

            // Step 2: Scan to the right for next greater element
            int nextGreater = -1;
            for (int k = indexInNums2 + 1; k < nums2.length; k++) {
                if (nums2[k] > target) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}
