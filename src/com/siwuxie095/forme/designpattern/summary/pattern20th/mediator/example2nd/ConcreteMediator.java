package com.siwuxie095.forme.designpattern.summary.pattern20th.mediator.example2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者
 *
 * @author Jiajing Li
 * @date 2019-11-11 20:41:46
 */
class ConcreteMediator extends Mediator {

    private List<Colleague> colleagueList = new ArrayList<>();

    @Override
    void register(Colleague colleague) {
        if (!colleagueList.contains(colleague)) {
            colleagueList.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    void relay(Colleague colleague) {
        for (Colleague colleague0 : colleagueList) {
            if (!colleague0.equals(colleague)) {
                colleague0.receive();
            }
        }
    }
}
