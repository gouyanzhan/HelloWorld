package com.siwuxie095.forme.algorithm.chapter9th.question25th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-21 16:16:30
 */
public class MedianHolder {

    private MyHeap<Integer> minHeap;

    private MyHeap<Integer> maxHeap;

    public MedianHolder() {
        this.minHeap = new MyHeap<>(new MinHeapComparator());
        this.maxHeap = new MyHeap<>(new MaxHeapComparator());
    }

    public void addNumber(Integer num) {
        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
            return;
        }
        if (this.maxHeap.getHead() >= num) {
            this.maxHeap.add(num);
        } else {
            if (this.minHeap.isEmpty()) {
                this.minHeap.add(num);
                return;
            }
            if (this.minHeap.getHead() > num) {
                this.maxHeap.add(num);
            } else {
                this.minHeap.add(num);
            }
        }
        this.modifyTwoHeapsSize();
    }

    public Integer getMedian() {
        long maxHeapSize = this.maxHeap.getSize();
        long minHeapSize = this.minHeap.getSize();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
        Integer maxHeapHead = this.maxHeap.getHead();
        Integer minHeapHead = this.minHeap.getHead();
        if (((maxHeapHead + minHeapHead) & 1) == 0) {
            return (maxHeapHead + minHeapHead) / 2;
        } else {
            return minHeapHead;
        }
    }

    private void modifyTwoHeapsSize() {
        if (this.maxHeap.getSize() == this.minHeap.getSize() + 2) {
            this.minHeap.add(this.maxHeap.popHead());
        }
        if (this.minHeap.getSize() == this.maxHeap.getSize() + 2) {
            this.maxHeap.add(this.minHeap.popHead());
        }
    }

}
