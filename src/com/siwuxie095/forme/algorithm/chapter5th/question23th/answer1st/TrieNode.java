package com.siwuxie095.forme.algorithm.chapter5th.question23th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-14 16:51:42
 */
public class TrieNode {

    public int path;

    public int end;

    public TrieNode[] map;

    public TrieNode() {
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }
}
