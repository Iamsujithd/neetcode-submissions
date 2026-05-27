class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> AnaMap=new HashMap<>();

        for(String s:strs){

            char[] nn=new char[s.length()];
            nn=s.toCharArray();
            Arrays.sort(nn);
            
            String temp=new String(nn);

            AnaMap.computeIfAbsent(temp,k->new ArrayList<>()).add(s);

        }
        return new ArrayList<>(AnaMap.values());
    }
}
