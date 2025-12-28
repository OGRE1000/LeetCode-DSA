class Solution {
    public int nextGreaterElement(int n) {

        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        // Step 1: Find the pivot
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // No next permutation exists
        if (i < 0) {
            return -1;
        }

        // Step 2: Find the successor
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse suffix
        reverse(digits, i + 1, len - 1);

        // Step 5: Convert to integer safely
        long result = Long.parseLong(new String(digits));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
