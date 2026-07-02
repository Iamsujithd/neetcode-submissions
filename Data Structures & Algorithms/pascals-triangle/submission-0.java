class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans =new ArrayList<>();
        int j;
        List<Integer> t;
        for(int i=0;i<numRows;i++){
            List<Integer> l=new ArrayList<>();
            if(i==0){
                l.add(1);
                ans.add(l);
                continue;
            }
            t=ans.get(ans.size()-1);
            for(j=0;j<i+1;j++){
                if(j%i==0){
                    l.add(1);
                    continue;
                }
                l.add(t.get(j-1)+t.get(j));
            }
            ans.add(l);
        }
        return ans;
    }
}