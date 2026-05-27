class Solution {
    public int removeElement(int[] nums, int val) {
        int h=0,t=nums.length-1,temp,count=0;
        while(t>=h){
            if(nums[h]==val){
                temp=nums[h];
                nums[h]=nums[t];
                nums[t]=temp;
                t--;
                count++;
            }
            else{
            h++;
            }
        }
        return nums.length-count;
    }
}