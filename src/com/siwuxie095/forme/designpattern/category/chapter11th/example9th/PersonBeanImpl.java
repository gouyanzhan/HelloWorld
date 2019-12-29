package com.siwuxie095.forme.designpattern.category.chapter11th.example9th;

/**
 * 人的实现（真正的主题）
 *
 * @author Jiajing Li
 * @date 2019-11-09 18:01:40
 */
class PersonBeanImpl implements PersonBean {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 兴趣
     */
    private String interests;

    /**
     * 评鉴的总分值（HotOrNot 的总评分）
     */
    private int rating;

    /**
     * 评鉴次数（HotOrNot 的评分次数）
     */
    private int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return rating / ratingCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        if (rating >= 1 && rating <= 10) {
            this.rating += rating;
            ratingCount++;
        }
    }
}
