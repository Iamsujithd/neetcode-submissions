class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. Keep a deep copy of the original array to find the indices later
        int[] original = nums.clone(); 
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int val1 = 0, val2 = 0;
        
        // 2. Find the two values that add up to the target
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                val1 = nums[left];
                val2 = nums[right];
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        // 3. Find the original indices of those two values
        int[] ind = new int[2];
        boolean foundFirst = false;
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] == val1 && !foundFirst) {
                ind[0] = i;
                foundFirst = true; // Prevents issues if val1 and val2 are the exact same number
            } 
            else if (original[i] == val2) {
                ind[1] = i;
            }
        }
        
        // 4. Ensure indices are returned in ascending order (Expected by the platform)
        if (ind[0] > ind[1]) {
            int temp = ind[0];
            ind[0] = ind[1];
            ind[1] = temp;
        }
        
        return ind;
    }
}