import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {

        int n = arr.length;

        // Step 1: Frequency count
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Max Heap of frequencies
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : freqMap.values()) {
            maxHeap.offer(freq);
        }

        // Step 3: Greedy removal
        int removed = 0;
        int setSize = 0;

        while (removed < n / 2) {
            removed += maxHeap.poll();
            setSize++;
        }

        return setSize;
    }
}
