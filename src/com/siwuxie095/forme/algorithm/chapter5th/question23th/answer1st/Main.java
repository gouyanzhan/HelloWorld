package com.siwuxie095.forme.algorithm.chapter5th.question23th.answer1st;

/**
 * 字典树（前缀树）的实现
 *
 * 题目：
 * 字典树又称为前缀树或 Trie 树，是处理字符串常见的数据结构。假设组成所有单词的字符仅是 a~z，请实现字典树结构，
 * 并包含以下四个主要功能。
 * （1）void insert(String word)：添加 word，可重复添加。
 * （2）void delete(String word)：删除 word，如果 word 添加过多次，仅删除一个。
 * （3）boolean search(String word)：查询 word 是否在字典树中。
 * （4）int prefixNumber(String pre)：返回以字符串 pre 为前缀的单词数量。
 *
 * 解答：
 * 字典树的介绍。字典树是一种树形结构，优点是利用字符串的公共前缀来节约存储空间。
 * 字典树的基本性质如下：
 * （1）根节点没有字符路径。除根节点外，每一个节点都被一个字符路径找到。
 * （2）从根节点到某一节点，将路径上经过的字符连接起来，为扫过的对应字符串。
 * （3）每个节点向下所有的字符路径上的字符都不同。
 *
 * 在字典树上搜索添加过的单词的步骤为：
 * （1）从根节点开始搜索。
 * （2）取得要查找单词的第一个字母，并根据该字母选择对应的字符路径向下继续搜索。
 * （3）字符路径指向的第二层节点上，根据第二个字母选择对应的字符路径向下继续搜索。
 * （4）一直向下搜索，如果单词搜索完后，找到的最后一个节点是一个终止节点，说明字典树中含有这个单词，如果找到的
 * 最后一个节点不是一个终止节点，说明单词不是字典树中添加过的单词。如果单词没搜索完，但是已经没有后续的节点了，
 * 也说明单词不是字典树中添加过的单词。
 * 在字典树上添加一个单词的步骤同理，不再详述。
 *
 * 下面介绍有关字典树节点的类型。在 TrieNode 类中，path 表示有多少个单词共用这个节点，end 表示有多少个单词
 * 以这个节点结尾，map 是一个哈希表结构，key 代表该节点的一条字符路径，value 表示字符路径指向的节点，根据题
 * 目的说明，map 为长度为 26 的数组，在字符种类比较多的情况下，可以选择真实的哈希表结构实现 map。
 * 介绍完 TrieNode 后，下面介绍 Trie 树如何实现。
 * （1）void insert(String word)：假设单词 word 的长度为 N。从左到右遍历 word 中每个字符，并依次从头
 * 节点开始根据每一个 word[i]，找到下一个节点。如果找的过程中节点不存在，就建立新节点，记为 a，并令 a.path
 * = 1。如果节点存在，记为 b，令 b.path++。通过最后一个字符 word[N-1] 找到最后一个节点时记为 e，令 e.path++。
 * （2）boolean search(String word)：从左到右遍历 word 中的每个字符，并依次从头节点开始根据每一个 word[i]，
 * 找到下一个节点。如果找到过程中节点不存在，说明这个单词的整个部分没有添加进 Trie 树，否则不可能找的过程中节
 * 点不存在，直接返回 false。如果能通过 word[N-1] 找到最后一个节点，记为 e，如果 e.end != 0，说明有单词
 * 通过 word[N-1] 的字符路径，并以节点 e 结尾，返回 true，如果 e.end == 0，返回 false。
 * （3）void delete(String word)：先调用 search(word)，看 word 在不在 Trie 树中，若在，则执行后面的
 * 过程，若不在，则直接返回。从左到右遍历 word 中的每个字符，并依次从头节点开始根据每一个 word[i] 找到下一个
 * 的节点。在找的过程中，把扫过每一个节点的 path 值减 1。如果发现下一个节点的 path 剪完之后已经为 0，直接从
 * 当前节点的 map 中删除后续的所有路径，返回即可。如果扫到最后一个节点，，记为 e，令 e.path--，e.end--。
 * （4）int prefixNumber(String pre)：和查找操作同理，根据 pre 不断找到节点，假设最后的节点记为 e，返回
 * e.path 的值即可。
 *
 * @author Jiajing Li
 * @date 2019-05-14 16:51:48
 */
public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        System.out.println(trie.search("word"));
        System.out.println(trie.search("world"));
        System.out.println();

        trie.delete("word");
        System.out.println(trie.search("word"));
        System.out.println(trie.search("world"));
        System.out.println();

        trie.delete("world");
        System.out.println(trie.search("word"));
        System.out.println(trie.search("world"));
        System.out.println();

        System.out.println(trie.prefixNumber("h"));
        System.out.println(trie.prefixNumber("w"));
        System.out.println();
    }

}
