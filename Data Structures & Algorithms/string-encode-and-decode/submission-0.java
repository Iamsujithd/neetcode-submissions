class Solution {

    public String encode(List<String> strs) {
        StringBuilder str=new StringBuilder();
        for(String s:strs){
            int size=s.length();
            str.append(size+"#"+s);
        }
        String result=str.toString();
        return result;
    }

    public List<String> decode(String str) {
        List<String> ans=new ArrayList<>();
        int i=0,j,size;
        while(i<str.length()){
            j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            size=Integer.parseInt(str.substring(i,j));

            String word = str.substring(j+1,j+1+size);
            ans.add(word);
            i=j+1+size;
        }
        return ans;
    }
}
