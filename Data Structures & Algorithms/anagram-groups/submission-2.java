class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> AnaMap=new HashMap<>();

        for(String s:strs){

            char[] carr=new char[26];
            for(int i=0;i<s.length();i++){
                carr[s.charAt(i)-'a']++;
            }

            String temp=new String(carr);

            AnaMap.computeIfAbsent(temp,k->new ArrayList<>()).add(s);

        }
        return new ArrayList<>(AnaMap.values());
    }
}
