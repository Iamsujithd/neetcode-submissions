class MyHashSet {

    public class Node{
        int key;
        Node nextNode;
        Node(int key){
            this.key=key;
        }
    }
    private static final int mod=769;
    private Node[] buckets;
    public MyHashSet() {
        buckets=new Node[mod];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new Node(-1);
        }

    }
    public int hash(int key){
        return key%mod;
    }
    
    public void add(int key) {
        int hash=hash(key);
        Node curr=buckets[hash];
        while(curr.nextNode!=null){
            if(curr.nextNode.key==key) return;
            curr=curr.nextNode;
            
        }
        curr.nextNode=new Node(key);

    }
    
    public void remove(int key) {
        int hash=hash(key);
        Node curr=buckets[hash];

        while(curr.nextNode!=null){
            if(curr.nextNode.key==key){
                curr.nextNode=curr.nextNode.nextNode;
                return;
            }
            curr=curr.nextNode;
        }


    }
    
    public boolean contains(int key) {
        int hash=hash(key);
        Node curr=buckets[hash].nextNode;

        while(curr!=null){
            if(curr.key==key){
                return true;
            }
            curr=curr.nextNode;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */