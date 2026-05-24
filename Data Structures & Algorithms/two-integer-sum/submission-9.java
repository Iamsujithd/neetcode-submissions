class Solution {
    public int[] twoSum(int[] nums, int target) {
        
int capacity = (int) (nums.length / 0.75f) + 1;
Map<Integer, Integer> numToIndex = new HashMap<>(capacity);
        

        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int comp=target-curr;
            if(numToIndex.containsKey(comp)){
                return new int[] {numToIndex.get(comp),i};
            }
            numToIndex.put(curr,i);

        }
        throw new IllegalArgumentException("Error arg1");
    }
}