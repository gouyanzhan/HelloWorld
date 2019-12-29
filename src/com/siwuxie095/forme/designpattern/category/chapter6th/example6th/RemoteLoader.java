package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * 遥控加载（客户）
 *
 * @author Jiajing Li
 * @date 2019-11-04 10:34:40
 */
class RemoteLoader {

    /**
     * 创建并加载遥控器
     */
    static RemoteControl createRemoteControl() {

        RemoteControl remoteControl = new RemoteControl();

        // 创建各种家电
        Light light = new Light();
        CeilingFan ceilingFan = new CeilingFan();
        TV tv = new TV();
        Stereo stereo = new Stereo();
        GarageDoor garageDoor = new GarageDoor();
        Sprinkler sprinkler = new Sprinkler();
        Hottub hottub = new Hottub();

        // 创建各种家电的命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        StereoOnWithDVDCommand stereoOnWithDVDCommand = new StereoOnWithDVDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

        SprinklerOnCommand sprinklerOnCommand = new SprinklerOnCommand(sprinkler);
        SprinklerOffCommand sprinklerOffCommand = new SprinklerOffCommand(sprinkler);

        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);
        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);

        // 有了全部命令后，加载到遥控器插槽中
        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(1, ceilingFanOnCommand, ceilingFanOffCommand);
        remoteControl.setCommand(2, tvOnCommand, tvOffCommand);
        remoteControl.setCommand(3, stereoOnWithDVDCommand, stereoOffCommand);
        remoteControl.setCommand(4, garageDoorOpenCommand, garageDoorCloseCommand);
        remoteControl.setCommand(5, sprinklerOnCommand, sprinklerOffCommand);
        remoteControl.setCommand(6, hottubOnCommand, hottubOffCommand);

        return remoteControl;
    }

}
