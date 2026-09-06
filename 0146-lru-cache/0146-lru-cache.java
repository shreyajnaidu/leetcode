class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();

    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node n = new Node(0, 0);
    Node temp = n;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {

            Node temp1 = map.get(key);

            // If already MRU, nothing to move
            if (temp1 != temp) {

                // Remove temp1 from its current position
                Node temp2 = temp1.prev;
                Node temp3 = temp1.next;

                temp2.next = temp3;
                temp3.prev = temp2;

                // Put temp1 at the end
                temp1.prev = temp;
                temp1.next = null;

                temp.next = temp1;
                temp = temp1;
            }

            return temp1.value;

        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node temp1 = map.get(key);

            // Update value
            temp1.value = value;

            // If already MRU, nothing to move
            if (temp1 != temp) {

                // Remove from current position
                Node temp2 = temp1.prev;
                Node temp3 = temp1.next;

                temp2.next = temp3;
                temp3.prev = temp2;

                // Put at end
                temp1.prev = temp;
                temp1.next = null;

                temp.next = temp1;
                temp = temp1;
            }

        } else {

            Node temp4 = new Node(key, value);

            // Put new node at end
            temp4.prev = temp;
            temp4.next = null;

            temp.next = temp4;
            temp = temp4;

            map.put(key, temp4);

            // Remove LRU if capacity exceeded
            if (map.size() > capacity) {

                Node lru = n.next;

                map.remove(lru.key);

                n.next = lru.next;

                if (lru.next != null) {
                    lru.next.prev = n;
                }
            }
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */