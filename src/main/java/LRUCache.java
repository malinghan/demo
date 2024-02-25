import java.util.HashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2022-03-22
 */
public class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int size;

    class Node {
        Integer key;
        Integer value;
        Node next;
        Node prev;
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int size) {
        this.size = size;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void put(Integer key, Integer value) {
        //如果map中有值，更新即可
        if (map.containsKey(key)) {
            //
        } else if (size >= map.size()) {
            deleteNode(tail.prev);
            map.remove(tail.prev.key);
            addToHead(new Node(key, value));
        } else {
            addToHead(new Node(key, value));
        }
        map.put(key, new Node(key, value));
    }

    public Integer get(Integer key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node != null) {
                deleteNode(node);
                appendTail(node);
                return node.value;
            }
        }
        return -1;
    }

    private void appendTail(Node n) {
        n.next = tail;
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
    }

    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.next = head;
        head = node;
    }

    void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
