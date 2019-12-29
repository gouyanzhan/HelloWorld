package com.siwuxie095.forme.designpattern.summary.pattern16th.builder.example1st;

/**
 * 具体生成器
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:52:08
 */
class ConcreteBuilder extends AbstractBuilder {

    private VacationPlanner vacationPlanner = new VacationPlanner();

    @Override
    void buildDay(int day) {
        vacationPlanner.setDay(day);
    }

    @Override
    void addHotel(String hotel) {
        vacationPlanner.setHotel(hotel);
    }

    @Override
    void addSpecialEvent(String specialEvent) {
        vacationPlanner.setSpecialEvent(specialEvent);
    }

    @Override
    void addTicket(String ticket) {
        vacationPlanner.setTicket(ticket);
    }

    @Override
    VacationPlanner getVacationPlanner() {
        return vacationPlanner;
    }
}
