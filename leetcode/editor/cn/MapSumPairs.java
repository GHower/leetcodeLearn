//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 181 👎 0

//[677]键值映射
package editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs{
    public static void main(String[] args){
        MapSum solution = new MapSumPairs().new MapSum();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    // 字典树,用来找前缀
    class Trie{
        int val = 0;
        Trie[] next = new Trie[26];
    }

    Trie root;
    Map<String, Integer> map;

    public MapSum() {
        root = new Trie();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        // 得到增量
        int delta = val - map.getOrDefault(key, 0);
        map.put(key,val);
        Trie trie = root;
        for (char c : key.toCharArray()) {
            if (trie.next[c - 'a'] == null) {
                trie.next[c - 'a'] = new Trie();
            }
            trie = trie.next[c - 'a'];
            trie.val += delta;
        }
    }
    
    public int sum(String prefix) {
        Trie trie = root;
        for (char c : prefix.toCharArray()) {
            if(trie.next[c - 'a'] == null){
                return 0;
            }
            trie = trie.next[c - 'a'];
        }
        return trie.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
