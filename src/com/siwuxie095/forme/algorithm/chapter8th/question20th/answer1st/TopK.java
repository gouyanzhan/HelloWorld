package com.siwuxie095.forme.algorithm.chapter8th.question20th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-09 21:37:55
 */
public class TopK {

    public static void printTopK(int[][] matrix, int topK) {
        int heapSize = matrix.length;
        HeapNode[] heap = new HeapNode[heapSize];
        for (int i = 0; i != heapSize; i++) {
            int index = matrix[i].length - 1;
            heap[i] = new HeapNode(matrix[i][index], i, index);
            heapInsert(heap, i);
        }
        System.out.println("TOP " + topK + " : ");
        for (int i = 0; i != topK; i++) {
            if (heapSize == 0) {
                break;
            }
            System.out.print(heap[0].value + " ");
            if (heap[0].index != 0) {
                heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
            } else {
                swap(heap, 0, --heapSize);
            }
            heapify(heap, 0, heapSize);
        }
    }

    private static void heapInsert(HeapNode[] heap, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[parent].value < heap[index].value) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private static void heapify(HeapNode[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (heap[left].value > heap[index].value) {
                largest = left;
            }
            if (right < heapSize && heap[right].value > heap[largest].value) {
                largest = right;
            }
            if (largest != index) {
                swap(heap, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void swap(HeapNode[] heap, int index1, int index2) {
        HeapNode tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

}
