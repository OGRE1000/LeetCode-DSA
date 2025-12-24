import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            long value = 1;  // C(i,0)

            for (int j = 0; j <= i; j++) {
                row.add((int) value);
                value = value * (i - j) / (j + 1);
            }

            triangle.add(row);
        }

        return triangle;
    }
}
