class Solution {
    public String longestCommonPrefix(String[] strs) {
        String init=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<init.length() && j<strs[i].length() && init.charAt(j)==strs[i].charAt(j)){
                j++;
            }
            init=init.substring(0,j);
        }
        return init;
    }
}