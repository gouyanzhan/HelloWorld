package com.siwuxie095.forme.designpattern.category.chapter14th.example17th;

/**
 * 原料
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:17:23
 */
class Material extends MenuComponent {

    /**
     * 原料名称
     */
    private String name;

    public Material(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void print() {
        System.out.println(name);
    }

    @Override
    void getState(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    String getIngredient() {
        return "原料的成分";
    }
}
