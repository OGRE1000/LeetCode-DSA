import java.util.ArrayList;
import java.util.List;

class Solution {
    // Segment Tree arrays
    private int[] tree; // Stores the count of 1s
    private boolean[] lazy; // Stores pending flip operations
    private int n;

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        n = nums1.length;
        tree = new int[4 * n];
        lazy = new boolean[4 * n];

        // 1. Build the Segment Tree based on nums1
        build(nums1, 1, 0, n - 1);

        // 2. Calculate initial sum of nums2
        long sum2 = 0;
        for (int num : nums2) {
            sum2 += num;
        }

        List<Long> results = new ArrayList<>();

        // 3. Process Queries
        for (int[] q : queries) {
            int type = q[0];

            if (type == 1) {
                // Range Flip on nums1
                update(1, 0, n - 1, q[1], q[2]);
            } else if (type == 2) {
                // Update sum2 based on current 1s in nums1
                // Change = p * (total count of 1s in nums1)
                // tree[1] always holds the total count of 1s for the whole array
                long p = q[1];
                sum2 += p * tree[1];
            } else if (type == 3) {
                // Return current sum
                results.add(sum2);
            }
        }

        // Convert List to array for return type
        long[] ans = new long[results.size()];
        for (int i = 0; i < results.size(); i++) {
            ans[i] = results.get(i);
        }
        return ans;
    }

    // --- Segment Tree Methods ---

    // Build the tree
    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        build(nums, 2 * node, start, mid);
        build(nums, 2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Push lazy tags down to children
    private void push(int node, int start, int end) {
        if (lazy[node]) {
            int mid = (start + end) / 2;
            
            // Apply flip to left child
            tree[2 * node] = (mid - start + 1) - tree[2 * node];
            lazy[2 * node] = !lazy[2 * node];

            // Apply flip to right child
            tree[2 * node + 1] = (end - mid) - tree[2 * node + 1];
            lazy[2 * node + 1] = !lazy[2 * node + 1];

            // Reset current node lazy status
            lazy[node] = false;
        }
    }

    // Range Update (Flip)
    private void update(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return;
        }
        
        // If current range is fully within update range
        if (l <= start && end <= r) {
            tree[node] = (end - start + 1) - tree[node];
            lazy[node] = !lazy[node];
            return;
        }

        push(node, start, end); // Push down pending updates before processing children

        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r);
        update(2 * node + 1, mid + 1, end, l, r);
        
        // Update current node based on children
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}