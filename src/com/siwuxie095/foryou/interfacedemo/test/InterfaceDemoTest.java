package com.siwuxie095.foryou.interfacedemo.test;

import com.siwuxie095.foryou.interfacedemo.api.InterfaceDemo;
import com.siwuxie095.foryou.interfacedemo.impl.InterfaceDemoImpl;
import com.siwuxie095.foryou.interfacedemo.impl.InterfaceDemoImpl0;
import org.junit.Assert;
import org.junit.Test;

/**
 * 接口测试类
 *
 * @author Jiajing Li
 * @date 2019-09-16 23:17:23
 */
public class InterfaceDemoTest {

    @Test
    public void testGetDemoV1() {
        /*
         * 类似抽象类，接口不能实例化。同样按照 is-a 的关系去理解。
         */
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        int param = 3;
        String result = interfaceDemo.getDemo(param);
        //result = "1";
        Assert.assertEquals(String.valueOf(param), result);
    }

    @Test
    public void testGetDemoV2() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl0();
        int param = 3;
        String result = interfaceDemo.getDemo(param);
        //result = "1";
        Assert.assertEquals(String.valueOf(param), result);
    }

    @Test
    public void testSetDemoV1() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        int param = 5;
        interfaceDemo.setDemo(param);
    }

    @Test
    public void testSetDemoV2() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl0();
        int param = 5;
        interfaceDemo.setDemo(param);
    }

    @Test
    public void testSaveDemoV1() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        String param = "123";
        boolean result = interfaceDemo.saveDemo(param);
        Assert.assertTrue(result);
        //Assert.assertFalse(result);
    }

    @Test
    public void testSaveDemoV2() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl0();
        String param = "123";
        boolean result = interfaceDemo.saveDemo(param);
        Assert.assertTrue(result);
        //Assert.assertFalse(result);
    }

    @Test
    public void testDeleteDemoV1() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        double param = 0.1;
        interfaceDemo.deleteDemo(param);
    }

    @Test
    public void testDeleteDemoV2() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl0();
        double param = 0.1;
        interfaceDemo.deleteDemo(param);
    }

    @Test
    public void testUpdateDemoV1() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        float param = 0.5f;
        interfaceDemo.updateDemo(param);
    }

    @Test
    public void testUpdateDemoV2() {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl0();
        float param = 0.5f;
        interfaceDemo.updateDemo(param);
    }

}
