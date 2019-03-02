package com.siwuxie095.forme.algorithm.chapter2nd.question1st.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-13 22:23:58
 */
public class Common {

    public static void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part:");
        while (null != head1 && null != head2) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + "  ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

}
