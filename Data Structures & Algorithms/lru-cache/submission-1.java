class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        insertAtHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            cache.remove(key);
        }

        if (cache.size() == capacity) {
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }
        
        Node node = new Node(key, value);
        cache.put(key, node);
        insertAtHead(node);
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
