package com.siwuxie095.forme.algorithm.chapter1st.question4th.answer1st;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列的实现
 *
 * @author Jiajing Li
 * @date 2019-01-09 15:52:38
 */
public class CatDogQueue {

    private Queue<PetEnterQueue> catQ;
    private Queue<PetEnterQueue> dogQ;
    private long count;

    public CatDogQueue() {
        catQ = new LinkedList<PetEnterQueue>();
        dogQ = new LinkedList<PetEnterQueue>();
        count = 0;
    }

    /**
     * 入队，从队尾插入新元素
     */
    public void add(Pet pet) {
        if (pet.getType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("err, not cat or dog");
        }
    }

    /**
     * 出队，返回整队的队头元素，并删除
     */
    public Pet pollAll() {
        if (!catQ.isEmpty() && !dogQ.isEmpty()) {

            if (catQ.peek().getCount() < dogQ.peek().getCount()) {
                return catQ.poll().getPet();
            } else {
                return dogQ.poll().getPet();
            }

        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    /**
     * 出队，返回猫队的队头元素，并删除
     */
    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    /**
     * 出队，返回狗队的队头元素，并删除
     */
    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    /**
     * 判断整队是否为空
     */
    public boolean isEmpty() {
        return catQ.isEmpty() && dogQ.isEmpty();
    }

    /**
     * 判断猫队是否为空
     */
    public boolean isCatQueueEmpty() {
        return catQ.isEmpty();
    }

    /**
     * 判断狗队是否为空
     */
    public boolean isDogQueueEmpty() {
        return dogQ.isEmpty();
    }

}
