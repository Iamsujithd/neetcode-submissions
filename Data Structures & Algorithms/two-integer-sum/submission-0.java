class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if (nums[i]+nums[j]==target && i!=j){
                    int[] n=new int[2];
                    n[0]=i;n[1]=j;
                    return n;
                }
            }
        }
        int[] u={-1};
        return u;
    }
}
