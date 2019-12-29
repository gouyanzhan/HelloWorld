package com.siwuxie095.forme.designpattern.category.chapter14th.example3rd;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:48:58
 */
class Client {

    private AbstractBuilder builder;

    Client(AbstractBuilder builder) {
        this.builder = builder;
    }

    VacationPlanner constructVacationPlanner() {
        builder.buildDay(1);
        builder.addHotel("某某旅馆");
        builder.addSpecialEvent("无");
        builder.addTicket("某某门票");
        return builder.getVacationPlanner();
    }

}
