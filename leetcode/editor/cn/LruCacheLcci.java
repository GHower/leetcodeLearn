//[面试题 16.25]LRU 缓存

//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 134 👎 0

package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCacheLcci{
    public static void main(String[] args){
//        Solution solution = new LruCacheLcci().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    /**
     * 1. 构建节点类Node
     * 2. 针对Node的私有操作方法
     *     2.1 moveToHead 添加到队首
     *     2.2 removeNode 删除节点
     * 3. 初始化和构造真实对外方法
     */
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail;
    private Map<Integer,Node> cacheMap = new HashMap<Integer,Node>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cacheMap.get(key);
        if(node==null){
            return -1;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(get(key) == -1){
            Node newNode = new Node(key, value);
            if(cacheMap.size() >= capacity){
                // 超出容量
                int reKey = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                cacheMap.remove(reKey);
            }
            cacheMap.put(key,newNode);
            moveToHead(newNode);
        }else{
            cacheMap.get(key).value = value;
        }
    }

    private void moveToHead(Node cur){
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
    private void removeNode(Node cur){
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
