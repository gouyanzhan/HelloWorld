package com.siwuxie095.forme.designpattern.summary.pattern13th.state.example2nd;

/**
 * 状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 14:22:34
 */
interface State {

    /*
     * State 接口定义了一个所有具体状态的共同接口；
     * 任何状态都实现这个相同的接口，这样一来，状态
     * 之间可以互相替换。
     */

    void handle();

}
