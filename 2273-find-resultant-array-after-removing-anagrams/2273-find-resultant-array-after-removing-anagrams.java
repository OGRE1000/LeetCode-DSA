import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String lastSig = null;

        for (String w : words) {
            String sig = signature(w);
            if (lastSig == null || !lastSig.equals(sig)) {
                result.add(w);
                lastSig = sig;
            }
            // else: w is an anagram of the previous kept word -> skip it
        }

        return result;
    }

    // Build a canonical signature from letter counts: "#c0#c1#c2...#c25"
    private String signature(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder(52);
        for (int c : cnt) {
            sb.append('#').append(c);
        }
        return sb.toString();
    }
}