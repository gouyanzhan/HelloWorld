package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-01-24 18:44:52
 */
public class TankTest {

    public static void main(String[] args) {
        Tank tank1 = new Tank("001");
        tank1.shoot();
        Tank.totalShellCount = 6;
        tank1.shoot();
        tank1.shoot();
        tank1.shoot();

        Tank tank2 = new Tank("002");
        tank2.shoot();
        tank2.shoot();

        Tank tank3 = new Tank("003");
        tank3.shoot();
        tank3.shoot();
        Tank.addShell(3);
        tank3.shoot();
        Tank tank4 = new Tank("004");
        tank4.shoot();
    }

}
