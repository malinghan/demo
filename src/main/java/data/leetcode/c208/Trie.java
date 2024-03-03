package data.leetcode.c208;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 * 实现Trie树
 */
public class Trie {
    Trie[] child;
    //只是用来标识是单词还是前缀，search方法需要用到
    //中间节点的isEnd也可能是true
    boolean isEnd;
    public Trie() {
        child = new Trie[26];
        //默认是false, isEnd由下面的函数自己维护
        isEnd = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            if (trie.child[x] == null) {
                trie.child[x] = new Trie();
            }
            // trie.isEnd = false;
            trie = trie.child[x];
        }
        //不用管中间节点是true还是false
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            //不用管中间节点是true还是false
            if (trie.child[x] == null) {
                return null;
            }
            trie = trie.child[x];
        }
        return trie;
    }
}
