import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {

        int teamsCount = votes[0].length();
        int[][] freq = new int[26][teamsCount];

        // Build frequency matrix
        for (String vote : votes) {
            for (int i = 0; i < teamsCount; i++) {
                char team = vote.charAt(i);
                freq[team - 'A'][i]++;
            }
        }

        // List of teams
        List<Character> teams = new ArrayList<>();
        for (char c : votes[0].toCharArray()) {
            teams.add(c);
        }

        // Custom sort
        Collections.sort(teams, (a, b) -> {
            for (int i = 0; i < teamsCount; i++) {
                if (freq[a - 'A'][i] != freq[b - 'A'][i]) {
                    return freq[b - 'A'][i] - freq[a - 'A'][i]; // higher first
                }
            }
            return a - b; // alphabetical order
        });

        // Build result
        StringBuilder result = new StringBuilder();
        for (char team : teams) {
            result.append(team);
        }

        return result.toString();
    }
}
