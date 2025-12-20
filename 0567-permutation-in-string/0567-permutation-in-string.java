class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Frequency of s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int windowSize = s1.length();

        // Initial window in s2
        for (int i = 0; i < windowSize; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(freq1, freq2)) {
            return true;
        }

        // Sliding window
        for (int i = windowSize; i < s2.length(); i++) {

            // Add new character
            freq2[s2.charAt(i) - 'a']++;

            // Remove old character
            freq2[s2.charAt(i - windowSize) - 'a']--;

            if (matches(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
