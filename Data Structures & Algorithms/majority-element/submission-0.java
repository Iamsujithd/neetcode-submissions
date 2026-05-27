class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> nm = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            
            // Add the number to the map, or increment its count if it's already there
            nm.put(currentNum, nm.getOrDefault(currentNum, 0) + 1);
            
            // 
            if (nm.get(currentNum) > n / 2) {
                return currentNum;
            }
        }
        
        return -1; 
    }
}