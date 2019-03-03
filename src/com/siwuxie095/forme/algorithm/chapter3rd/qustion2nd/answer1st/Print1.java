package com.siwuxie095.forme.algorithm.chapter3rd.qustion2nd.answer1st;

/**
 * 标准一
 *
 * @author Jiajing Li
 * @date 2019-03-03 19:36:23
 */
public class Print1 {

    public static void printEdge(Node head) {
        if (null == head) {
            return;
        }
        // 获取树的高度
        int height = getHeight(head, 0);
        // height 行 2 列的二维数组，用于存储每一层的最左节点和最右节点
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边界（正序打印）
        for (int i = 0; i != edgeMap.length; ++i) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        // 打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);
        // 打印右边界，但不是左边界但节点（倒序打印，因为这样才是一个逆时针）
        for (int i = edgeMap.length - 1; i != -1; --i) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][1].value + " ");
            }
        }
    }

    /**
     * 获取树的高度
     */
    private static int getHeight(Node head, int height) {
        if (null == head) {
            return height;
        }
        return Math.max(getHeight(head.left, height + 1), getHeight(head.right, height + 1));
    }

    /**
     * 设置每一层的最左节点和最右节点
     */
    private static void setEdgeMap(Node head, int height, Node[][] edgeMap) {
        if (null == head) {
            return;
        }
        /*
         * 根据递归，会先将 edgeMap[height][0] 设置最左节点，同时将 edgeMap[height][1]
         * 给赋值成了最左节点。最后会将 edgeMap[height][1] 重新赋值成最右节点。
         */
        edgeMap[height][0] = (null == edgeMap[height][0]) ? head : edgeMap[height][0];
        edgeMap[height][1] = head;
        setEdgeMap(head.left, height + 1, edgeMap);
        setEdgeMap(head.right, height + 1, edgeMap);
    }

    /**
     * 打印不在 edgeMap 中的叶子节点
     */
    private static void printLeafNotInMap(Node head, int height, Node[][] edgeMap) {
        if (null == head) {
            return;
        }
        // 左右孩子为空（即为叶子节点），且不在 edgeMap 中
        if (null == head.left && null == head.right && head != edgeMap[height][0] && head != edgeMap[height][1]) {
            System.out.print(head.value + " ");
        }
        printLeafNotInMap(head.left, height + 1, edgeMap);
        printLeafNotInMap(head.right, height + 1, edgeMap);
    }

}
