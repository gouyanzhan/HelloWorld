package com.siwuxie095.forme.designpattern.category.chapter7th.example3rd;

/**
 * 类适配器
 *
 * @author Jiajing Li
 * @date 2019-11-04 16:53:25
 */
class SpecificAdapter extends SpecificAdaptee implements Target  {

    @Override
    public void request() {
        specificRequest();
    }

}
