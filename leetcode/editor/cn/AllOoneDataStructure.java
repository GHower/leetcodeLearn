//[432]全 O(1) 的数据结构

//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMin
//Key"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 104 次 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 167 👎 0

package editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOoneDataStructure{
    public static void main(String[] args){
//        Solution solution = new AllOoneDataStructure().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class AllOne {
    // 双向链表 + 哈希表
    // 类LFU
    class Node{
        int cnt;
        Set<String> set = new HashSet<>();
        Node left,right;
        Node(int cnt){this.cnt = cnt;}
    }
    Node head,tail;
    Map<String,Node> map = new HashMap<>();

    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }
    private void clearNode(Node node) {
        if(node.set.size() == 0){
            node.right.left = node.left;
            node.left.right = node.right;
        }
    }
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            Node next = null;
            if(node.right.cnt == cnt + 1){
                next = node.right;
            }else{
                next = new Node(cnt+1);
                next.right = node.right;
                next.left = node;
                node.right.left = next;
                node.right = next;
            }
            next.set.add(key);
            map.put(key,next);
            clearNode(node);
        }else{
            Node node = null;
            if (head.right.cnt == 1) {
                node = head.right;
            }else{
                node = new Node(1);
                node.right = head.right;
                node.left = head;
                head.right.left = node;
                head.right = node;
            }
            node.set.add(key);
            map.put(key,node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.set.remove(key);
        int cnt = node.cnt;
        if (cnt==1) {
            map.remove(key);
        }else{
            Node pre = null;
            if(node.left.cnt == cnt -1){
                pre = node.left;
            }else{
                pre = new Node(cnt - 1);
                pre.right = node;
                pre.left = node.left;
                node.left.right = pre;
                node.left = pre;
            }
            pre.set.add(key);
            map.put(key,pre);
        }
        clearNode(node);
    }
    
    public String getMaxKey() {
        Node node = tail.left;
        for (String s : node.set) {
            return s;
        }
        return "";
    }
    
    public String getMinKey() {
        Node node = head.right;
        for (String s : node.set) {
            return s;
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
