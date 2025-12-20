class Solution {
    public int maxVowels(String s, int k) {

        int vowelCount = 0;
        int maxVowels = 0;

        // Count vowels in first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        maxVowels = vowelCount;

        // Sliding window
        for (int i = k; i < s.length(); i++) {

            // Add new character
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }

            // Remove old character
            if (isVowel(s.charAt(i - k))) {
                vowelCount--;
            }

            maxVowels = Math.max(maxVowels, vowelCount);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || 
               c == 'o' || c == 'u';
    }
}
