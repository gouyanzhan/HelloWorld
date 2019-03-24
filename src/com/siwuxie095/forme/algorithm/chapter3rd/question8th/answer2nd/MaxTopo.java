package com.siwuxie095.forme.algorithm.chapter3rd.question8th.answer2nd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiajing Li
 * @date 2019-03-21 22:39:59
 */
public class MaxTopo {

    public static int bstTopoSize(Node head) {
        Map<Node, Record> map = new HashMap<>();
        return postOrder(head, map);
    }

    private static int postOrder(Node head, Map<Node, Record> map) {
        if (null == head) {
            return 0;
        }
        int leftSize = postOrder(head.left, map);
        int rightSize = postOrder(head.right, map);
        modifyMap(head.left, head.value, map, true);
        modifyMap(head.right, head.value, map, false);
        Record leftRecord = map.get(head.left);
        Record rightRecord = map.get(head.right);
        int leftBST = (null == leftRecord) ? 0 : leftRecord.l + leftRecord.r + 1;
        int rightBST = (null == rightRecord) ? 0 : rightRecord.l + rightRecord.r + 1;
        map.put(head, new Record(leftBST, rightBST));
        return Math.max(leftBST + rightBST + 1, Math.max(leftSize, rightSize));
    }

    private static int modifyMap(Node curr, int headValue, Map<Node, Record> map, boolean flag) {
        if (null == curr || !map.containsKey(curr)) {
            return 0;
        }
        Record record = map.get(curr);
        if ((flag && curr.value > headValue) || (!flag && curr.value < headValue)) {
            map.remove(curr);
            return record.l + record.r + 1;
        } else {
            int minus = modifyMap(flag ? curr.right : curr.left, headValue, map, flag);
            if (flag) {
                record.r = record.r - minus;
            } else {
                record.l = record.l - minus;
            }
            map.put(curr, record);
            return minus;
        }
    }

}
