class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies using a Hash Map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buck=new List[nums.length+1];

        for(int key:frequencyMap.keySet()){
            if(buck[frequencyMap.get(key)]==null){
                buck[frequencyMap.get(key)]=new ArrayList<>();
            }
            buck[frequencyMap.get(key)].add(key);
        }
        int[] ans=new int[k];
        int p=0;
        for(int i=nums.length;i>=0;i--){
            if(buck[i]!=null){
                for(int j: buck[i] ){
                    ans[p++]=j;
                }
                if(p>=k) break;
            }
        }
        return ans;
    }
}