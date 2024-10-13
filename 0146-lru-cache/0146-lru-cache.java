class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity;
    Map<Integer,Node> trackMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(trackMap.containsKey(key)){
            Node node = trackMap.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (trackMap.containsKey(key)) {
            // If key exists, update its value and move to the front
            Node node = trackMap.get(key);
            node.value = value;
            remove(node);  // Remove from the current position
            insert(node);  // Insert it at the head (most recently used)
        } else {
            // If new key, we might need to evict the least recently used node
            if (trackMap.size() == capacity) {
                // Remove the least recently used node (node before tail)
                remove(tail.prev);
            }
            // Insert the new key-value pair at the front
            insert(new Node(key, value));
        }
    }

    public void remove(Node node){
        trackMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        trackMap.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */