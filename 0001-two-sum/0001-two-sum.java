import java.util.Arrays;

class Solution {
    static class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Pair[] arr = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> a.value - b.value);

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left].value + arr[right].value;

            if (sum == target) {
                return new int[] { arr[left].index, arr[right].index };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
}
