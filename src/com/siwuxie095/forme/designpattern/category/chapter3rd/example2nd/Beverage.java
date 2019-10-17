package com.siwuxie095.forme.designpattern.category.chapter3rd.example2nd;


/**
 * 饮料
 *
 * @author Jiajing Li
 * @date 2019-10-09 20:28:01
 */
class Beverage {

    /**
     * 饮料描述
     */
    private String description;

    public String getDescription() {
        return description;
    }

    /**
     * 是否有蒸奶
     */
    private boolean steamedMilk;

    /**
     * 蒸奶价格
     */
    private double steamedMilkCost = 0.5;

    /**
     * 是否有豆浆
     */
    private boolean soy;

    /**
     * 豆浆价格
     */
    private double soyCost = 1.5;

    /**
     * 是否有摩卡
     */
    private boolean mocha;

    /**
     * 摩卡价格
     */
    private double mochaCost = 2.5;

    /**
     * 是否有奶泡
     */
    private boolean whip;

    /**
     * 奶泡价格
     */
    private double whipCost = 3.5;

    public boolean hasSteamedMilk() {
        return steamedMilk;
    }

    public void setSteamedMilk(boolean steamedMilk) {
        this.steamedMilk = steamedMilk;
    }

    public boolean hasSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean hasMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean hasWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }

    public double cost() { 
        // 调料价格
        double condimentCost = 0;
        if (hasSteamedMilk()) {
            condimentCost += steamedMilkCost;
        }
        if (hasSoy()) {
            condimentCost += soyCost;
        }
        if (hasMocha()) {
            condimentCost += mochaCost;
        }
        if (hasWhip()) {
            condimentCost += whipCost;
        }
        return condimentCost;
    }
}
