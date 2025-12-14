class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            // if current digit is less than 9, just add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // if digit is 9, turn it into 0 and carry over
            digits[i] = 0;
        }

        // if all digits were 9, we need an extra place
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
