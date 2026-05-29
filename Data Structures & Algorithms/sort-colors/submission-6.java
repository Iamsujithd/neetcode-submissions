class Solution {

public void swap(int[] nums,int a,int b){
    int temp=nums[a];
    nums[a]=nums[b];
    nums[b]=temp;
}

    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1,curr=0;
        while( curr<=right){
            if(nums[curr]==0){
                swap(nums,curr,left);
                left++;
                curr++;
            }
            else if(nums[curr]==1){
                curr++;
            }
            else if(nums[curr]==2){
                swap(nums,curr,right);
                
                right--;
            }
        }
        return;
    }
}