class Solution {
    public boolean isAnagram(String s, String t) {
       if(s==null || t==null || (s.length()!=t.length()))
       {
            return false;
        }
        
        Map<Character,Integer> ch=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            ch.put(curr,ch.getOrDefault(curr,0)+1);
            

        }
        for(int i=0;i<t.length();i++){
            char curr=t.charAt(i);
            Integer current=ch.get(curr);
            if(current==null||current==0) return false;
            ch.put(curr,current-1);
        }
        return true;
    }
}
