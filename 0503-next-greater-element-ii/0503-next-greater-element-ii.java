import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int currIndex = i % n;

            while (!stack.isEmpty() && nums[currIndex] > nums[stack.peek()]) {
                result[stack.pop()] = nums[currIndex];
            }

            // Push index only during first pass
            if (i < n) {
                stack.push(currIndex);
            }
        }

        return result;
    }
}
