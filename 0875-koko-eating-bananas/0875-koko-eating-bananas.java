class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long hoursNeeded = 0;

            for (int pile : piles) {
                hoursNeeded += (pile + mid - 1) / mid; // ceil division
            }

            if (hoursNeeded <= h) {
                answer = mid;       // possible answer
                high = mid - 1;     // try smaller speed
            } else {
                low = mid + 1;      // speed too slow
            }
        }

        return answer;
    }
}
