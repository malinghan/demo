package data.leetcode.c146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 * 1. 定义一个DListNode,存储cache中的 key value 和 双向指针 prev, next
 * 2. 定义一个LinkedList<DListNode>,维护缓存的顺序，为LRU的主要实现方式
 * 3. 定义一个map,存储KV数据, key 存放 原始key；value封装成DListNode
 * 4. 定义capacity,为缓存的容量，当大于这个容量时，需要删除不经常访问的元素
 * 5. 定义size,为元素的容量，size当大于capacity时，需要删除不经常访问的元素
 * 6. 定义head和tail指针，方便取数, 初始化为头尾相连
 * 7. get操作
 *  7.1 先判断map中是否存在, 不存在返回-1
 *  7.2 如果存在，将其移到头节点(moveToHead); 然后返回value
 * 8 put操作
 * 8.1 如果不存在, 创建一个node, addToHead; 如果size超出capacity,删除尾部节点(removeTail)
 * 8.2 如果存在，moveToHead,修改值
 * 9 moveToHead逻辑
 *    9.1 removeNode
 *    9.2 addToHead
 * 10 addToHead
 *   - node.prev = head;
 *   - node.next = head.next;
 *   - head.next.prev = node;
 *   - head.next = node;
 * 11 removeTail
 *   removeNode(tail.prev)
 * 12 removeNode
 *   - node.prev.next = node.next;
 *   - node.next.prev = node.prev;
 */
class LRUCache1 {

    class DListNode {
        int key;
        int value;
        DListNode prev;
        DListNode next;
        public DListNode() {}
        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DListNode> map = new HashMap<>();
    int capacity;
    int size;
    DListNode head;
    DListNode tail;


    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DListNode();
        this.tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        DListNode node = map.get(key);
        if (node == null) {
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            size++;
            addToHead(newNode);
            if (size > capacity) {
                DListNode tailNode = removeTail();
                map.remove(tailNode.key);
                size --;
            }
            // addToHead(newNode);
        } else {
            node.value = value;
            // map.put(key,node);
            moveToHead(node);
        }
    }

    private void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DListNode removeTail() {
        DListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}