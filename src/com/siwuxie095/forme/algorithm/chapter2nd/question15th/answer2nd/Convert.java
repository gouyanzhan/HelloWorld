package com.siwuxie095.forme.algorithm.chapter2nd.question15th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-24 10:54:05
 */
public class Convert {

    public static Node convert(Node head) {
        if (null == head) {
            return null;
        }
        Node tail = process(head);
        /*
         * 解除特殊结构，恢复正常结构
         */
        head = tail.right;
        tail.right = null;
        return head;
    }

    private static Node process(Node head) {
        if (null == head) {
            return null;
        }
        // 左子树的尾节点 left end
        Node leftE = process(head.left);
        // 右子树的尾节点 right end
        Node rightE = process(head.right);
        // 左子树的头节点 left start
        Node leftS = (leftE != null) ? leftE.right : null;
        // 右子树的头节点 right start
        Node rightS = (rightE != null) ? rightE.right : null;

        /*
         * 左右子树均不为空
         */
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        /*
         * 左子树不空，右子树空
         */
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        /*
         * 右子树不空，左子树空
         */
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        /*
         * 左右子树均空
         */
        } else {
            head.right = head;
            return head;
        }
    }

}
