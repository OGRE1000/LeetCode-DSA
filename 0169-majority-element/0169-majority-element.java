class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];   // majorityElement = null;
        int count = 1;      // count = 0;
        for (int i = 1; i < nums.length; i++){      // i = 0;
            if(count == 0){
                majorityElement = nums[i];
                count = 1;
            } else if(nums[i] == majorityElement){
                count++;
            } else {
                count--;
            }
        }
        return majorityElement;
    }
}

// Boyer Moore Algorithm