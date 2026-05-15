class Solution {
    public boolean hasDuplicate(int[] nums) {
        int flag=0;
        for(int i=1;i<nums.length;i++){
            for(int k=0;k<i;k++){
                if (nums[i]==nums[k]){
                    return true;
                }
            }
        }
        return false;
    }
}