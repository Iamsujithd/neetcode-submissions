class Solution {
    public String longestCommonPrefix(String[] strs) {
        String init=strs[0];
        int l=init.length();
        
        for(int i=0;i<strs.length;i++){
            while(strs[i].indexOf(init)!=0){
                init=init.substring(0,l--);
            }

        }
        return init;
    }
}