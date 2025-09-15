import java.util.HashMap;

class LRUCache {

    // Doubly linked list node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> mpp;
    private int capacity;
    private Node head;
    private Node tail;

    // Constructor to initialize the LRU Cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        mpp = new HashMap<>();
        head = new Node(0, 0); // Dummy head node
        tail = new Node(0, 0); // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    // Deletes a node from the doubly linked list
    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Inserts a node right after the head
    private void insertAfterHead(Node node) {
        Node afterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = afterHead;
        afterHead.prev = node;
    }

    // Retrieves a value from the cache
    public int get(int key) {
        if (!mpp.containsKey(key)) {
            return -1;
        }
        
        Node node = mpp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    // Inserts or updates a value in the cache
    public void put(int key, int value) {
        if (mpp.containsKey(key)) {
            Node node = mpp.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (mpp.size() == capacity) {
                Node nodeToDelete = tail.prev;
                mpp.remove(nodeToDelete.key);
                deleteNode(nodeToDelete);
            }
            
            Node newNode = new Node(key, value);
            mpp.put(key, newNode);
            insertAfterHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */