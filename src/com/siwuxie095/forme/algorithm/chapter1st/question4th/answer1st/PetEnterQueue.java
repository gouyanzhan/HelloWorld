package com.siwuxie095.forme.algorithm.chapter1st.question4th.answer1st;

/**
 * 猫狗队列中存放的元素
 *
 * @author Jiajing Li
 * @date 2019-01-09 15:51:55
 */
public class PetEnterQueue {

    /**
     * 用于接收不同的子类实例
     */
    private Pet pet;
    /**
     * 用于给不同的子类实例盖上时间戳（先后顺序）
     */
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return pet.getType();
    }

}
