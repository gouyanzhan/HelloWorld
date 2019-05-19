package com.siwuxie095.forme.algorithm.chapter5th.question12th.answer2nd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiajing Li
 * @date 2019-04-22 09:49:00
 */
public class Record {

    private HashMap<String, HashMap<String, Integer>> record;

    /**
     * 构造函数：建立记录的过程
     */
    public Record(String[] strArr) {
        record = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i != strArr.length; ++i) {
            String currStr = strArr[i];
            update(indexMap, currStr, i);
            indexMap.put(currStr, i);
        }
    }

    private void update(HashMap<String, Integer> indexMap, String str, int i) {
        if (!record.containsKey(str)) {
            record.put(str, new HashMap<>());
        }
        HashMap<String, Integer> strMap = record.get(str);
        for (Map.Entry<String, Integer> lastEntry : indexMap.entrySet()) {
            String key = lastEntry.getKey();
            int index = lastEntry.getValue();
            if (!key.equals(str)) {
                HashMap<String, Integer> lastMap = record.get(key);
                int currMin = i - index;
                if (strMap.containsKey(key)) {
                    int preMin = strMap.get(key);
                    if (currMin < preMin) {
                        strMap.put(key, currMin);
                        lastMap.put(str, currMin);
                    }
                } else {
                    strMap.put(key, currMin);
                    lastMap.put(str, currMin);
                }
            }
        }
    }

    /**
     * 单次查询的方法
     */
    public int minDistance(String str1, String str2) {
        if (null == str1 || null == str2) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        if (record.containsKey(str1) && record.get(str1).containsKey(str2)) {
            return record.get(str1).get(str2);
        }
        return -1;
    }

}
