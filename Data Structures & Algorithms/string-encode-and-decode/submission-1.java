class Solution {

    public String encode(List<String> strs) {
        
        StringBuilder sb=new StringBuilder();
        int len=strs.size();
        sb.append(len).append('\0');
        for(String r:strs){
            int k=r.length();
            sb.append(k).append('\0').append(r);
        }
        return sb.toString();
    }   

    public List<String> decode(String str) {
        List<String> ls=new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return ls;
        }
        int i=0;
        while(str.charAt(i)!='\0'){
            i++;
        }
        int count=Integer.parseInt(str.substring(0,i));
        i++;
        int o,y;
        while(count>0){
            o=i;
            while(str.charAt(i)!='\0'){
                i++;
            }
            int u1=Integer.parseInt(str.substring(o,i++));
            ls.add(str.substring(i,i+u1));
            i=i+u1;
            count--;
        }
        return ls;
    }
}
