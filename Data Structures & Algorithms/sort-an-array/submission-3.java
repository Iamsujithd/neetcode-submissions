class Solution {
    public int[] sortArray(int[] nums) {

        int N=nums.length;
        for(int i=N/2-1;i>=0;i--){
            heapify(nums,i,N);
        }

        for(int i=N-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,0,i);
        }
        return nums;
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public void heapify(int[] nums,int root,int size){
        int max=root;
        int leftnode=2*root+1;
        int rightnode=2*root+2;

        if( leftnode<size && nums[max]<nums[leftnode] ){
            max=leftnode;
        }
        if( rightnode<size && nums[max]<nums[rightnode] ){
            max=rightnode;
        }

        if(root!=max){
            swap(nums,max,root);
            heapify(nums,max,size);

        }
        
    }

}