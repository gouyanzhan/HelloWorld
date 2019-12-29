package com.siwuxie095.forme.designpattern.category.chapter11th.example9th;

/**
 * 人（主题）
 *
 * @author Jiajing Li
 * @date 2019-11-09 17:58:30
 */
interface PersonBean {

    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);

}
