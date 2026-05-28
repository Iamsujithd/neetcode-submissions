class MyHashMap {

    public class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Node[] map;
    private static final int mod=2069;
    public int hash(int key){
        return key%mod;
    }
    public MyHashMap() {
        map=new Node[mod];
        for(int i=0;i<map.length;i++){
            map[i]= new Node(-1,-1);
        }
    }
    
    public void put(int key, int value) {
        int hash=hash(key);
        Node curr=map[hash];
        while(curr.next!=null){
            if(curr.next.key==key){
                curr.next.value=value;
                return;
            }
            curr=curr.next;
        }
        curr.next=new Node(key,value);
        return;
    }
    
    public int get(int key) {
        int hash=hash(key);
        Node curr=map[hash];
        while(curr.next!=null){
            if(curr.next.key==key){
                return curr.next.value;
            }
            curr=curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash=hash(key);
        Node curr=map[hash];
        while(curr.next!=null){
            if(curr.next.key==key){
                curr.next=curr.next.next;
                return;
            }
            curr=curr.next;
        }
        return;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */