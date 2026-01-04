class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // The minimum possible speed is 1 banana per hour.
        // The maximum useful speed is the size of the largest pile 
        // (eating faster than the largest pile doesn't save any hours).
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2; // mid represents our current speed 'k'

            if (canFinish(piles, h, mid)) {
                // If we can finish at speed 'mid', this might be the answer,
                // OR there might be a slower speed that also works. 
                // So we try smaller speeds (move right to mid).
                right = mid;
            } else {
                // If we cannot finish, 'mid' is too slow.
                // We must increase the speed.
                left = mid + 1;
            }
        }

        // When left meets right, we have found the minimum speed.
        return left;
    }

    // Helper function to check if Koko can finish all piles within 'h' hours at speed 'k'
    private boolean canFinish(int[] piles, int h, int k) {
        int hoursUsed = 0;
        for (int pile : piles) {
            // Calculate hours needed for this pile.
            // Math.ceil(pile / k) is equivalent to (pile + k - 1) / k using integer division
            hoursUsed += (pile + k - 1) / k;
        }
        return hoursUsed <= h;
    }
}