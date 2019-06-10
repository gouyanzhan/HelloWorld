package com.siwuxie095.forme.algorithm.chapter8th.question7th.answer1st;

/**
 * 在行列都排好序的矩阵中找数
 *
 * 题目：
 * 给定一个有 N*M 的整型矩阵 matrix 和一个整数 K，matrix 的每一行和每一列都是排好序的。
 * 实现一个函数，判断 K 是否在 matrix 中。
 *
 * 比如：
 * 0    1   2   5
 * 2    3   4   7
 * 4    4   4   8
 * 5    7   7   9
 * 如果 K 为 7，返回 true；如果 K 为 6，返回 false。
 *
 * 要求：
 * 时间复杂度为 O(N+M)，额外空间复杂度为 O(1)。
 *
 * 解答：
 * 符合要求的解法比较巧妙且易于理解。
 * 可以用以下步骤解决：
 * 1、从矩阵最右上角的数开始寻找（row = 0，col = M-1）。
 * 2、比较当前数 matrix[row][col] 与 K 的关系：
 * （1）如果与 K 相等，说明已找到，直接返回 true。
 * （2）如果比 K 大，因为矩阵每一列都已排好序，所以在当前数所在的列中，处于当前数下方的数都
 * 会比 K 大，则没有必要继续在第 col 列上寻找，令 col = col - 1，重复步骤 2。
 * （3）如果比 K 小，因为矩阵每一行都已排好序，所以在当前数所在的行中，处于当前数左方的数都
 * 会比 K 小，则没有必要继续在第 row 行上寻找，令 row = row + 1，重复步骤 2。
 * 3、如果找到越界都没有发现与 K 相等的数，则返回 false。
 *
 * 或者，也可以用以下步骤：
 * 1、从矩阵最左下角的数开始寻找（row = N-1，col = 0）。
 * 2、比较当前数 matrix[row][col] 与 K 的关系：
 * （1）如果与 K 相等，说明已找到，直接返回 true。
 * （2）如果比 K 大，因为矩阵每一行都已排好序，所以在当前数所在的行中，处于当前数右方的数都
 * 会比 K 大，则没有必要继续在第 row 行上寻找，令 row = row - 1，重复步骤 2。
 * （2）如果比 K 小，因为矩阵每一列都已排好序，所以在当前数所在的列中，处于当前数上方的数都
 * 会比 K 小，则没有必要继续在第 col 列上寻找，令 col = col + 1，重复步骤 2。
 * 3、如果找到越界都没有发现与 K 相等的数，则返回 false。
 *
 * @author Jiajing Li
 * @date 2019-05-27 16:48:27
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 5},
                {2, 3, 4, 7},
                {4, 4, 4, 8},
                {5, 7, 7, 9}
        };
        System.out.println(Matrix.isContains(matrix, 7));
        System.out.println(Matrix.isContains(matrix, 6));

    }

}
