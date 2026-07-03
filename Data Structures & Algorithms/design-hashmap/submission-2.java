class MyHashMap {
    
    // 1. The upgraded Node class
    class Node {
        int key, value;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // 2. The bucket array and modulo
    private static final int MOD = 769;
    private Node[] buckets;
    
    public MyHashMap() {
        buckets = new Node[MOD];
        for (int i = 0; i < MOD; i++) {
            // Dummy head to make traversal and removal perfectly safe!
            buckets[i] = new Node(-1, -1);
        }
    }
    
    private int hash(int key) {
        return key % MOD;
    }
    
    // YOUR TURN: Implement the 3 core methods!
    public void put(int key, int value) { 
        int hash=hash(key);
        Node curr=buckets[hash];
        
        while(curr.next!=null){
            if(curr.next.key==key){
                curr.next.value=value;
                return;
            }
            curr=curr.next;
        }
        
        Node nn=new Node(key,value);
        curr.next=nn;

     }
    public int get(int key) { 

        int hash=hash(key);
        Node curr=buckets[hash];
        
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
        Node curr=buckets[hash];
        while(curr.next!=null){
            if(curr.next.key==key){
                
                curr.next=curr.next.next;
                return;
            }
            curr=curr.next;
        }

     }
}