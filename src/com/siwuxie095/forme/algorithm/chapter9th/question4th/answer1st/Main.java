package com.siwuxie095.forme.algorithm.chapter9th.question4th.answer1st;

/**
 * 判断一个点是否在矩形内部
 *
 * 题目：
 * 在二维坐标系中，所有的值都是 double 类型，那么一个矩形可以由 4 个点来代表，(x1, y1) 为最左的点、
 * (x2, y2) 为最上的点、(x3, y3) 为最下的点、(x4, y4) 为最右的点。给定 4 个点代表的矩形，再给定
 * 一个点 (x, y)，判断 (x, y) 是否在矩形中。
 *
 * 解答：
 * 本题的解法有很多种，这里提供的解法先解决如果矩形的边不是平行于 x 轴就是平行于 y 轴的情况下，该如何
 * 判断 (x, y) 是否在其中。
 * 这种情况是比较简单的，因为矩形的边不是平行于 x 轴就是平行于 y 轴，所以判断该点是否完全在矩形的左侧、
 * 右侧、上侧、下侧，如果都不是，就一定在其中。如果矩形的边不平行于坐标轴呢？也非常简单，就是高中数学的
 * 知识，通过坐标变换把矩阵转成平行的情况，在旋转时所有的点跟着转动就可以。旋转完成后，再用上面的方式进
 * 行判断。
 *
 * @author Jiajing Li
 * @date 2019-06-15 20:49:51
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Judge.isInside(0, 4, 4, 0, 2, 2));
        System.out.println(Judge.isInside(0, 4, 4, 8, 4, 0, 8, 4, 4, 4));
    }

}
