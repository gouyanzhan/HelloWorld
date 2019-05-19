package com.siwuxie095.forme.algorithm.chapter5th.question23th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-14 16:51:33
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (null == word) {
            return;
        }
        char[] charArr = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            index = charArr[i] - 'a';
            if (null == node.map[index]) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word)) {
            char[] charArr = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < charArr.length; i++) {
                index = charArr[i] - 'a';
                if (node.map[index].path-- == 1) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }

    public boolean search(String word) {
        if (null == word) {
            return false;
        }
        char[] charArr = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            index = charArr[i] - 'a';
            if (null == node.map[index]) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNumber(String pre) {
        if (null == pre) {
            return 0;
        }
        char[] charArr = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            index = charArr[i] - 'a';
            if (null == node.map[index]) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }

}
