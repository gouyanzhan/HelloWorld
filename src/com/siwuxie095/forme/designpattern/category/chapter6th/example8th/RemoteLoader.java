package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

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
        TV tv = new TV();
        Stereo stereo = new Stereo();
        Hottub hottub = new Hottub();

        // 创建各种家电的命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        StereoOnWithDVDCommand stereoOnWithDVDCommand = new StereoOnWithDVDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);
        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);

        // 两个数组，一组用来记录开启命令，一组用来记录关闭命令
        Command[] partyOn = {lightOnCommand, stereoOnWithDVDCommand, tvOnCommand, hottubOnCommand};
        Command[] partyOff = {lightOffCommand, stereoOffCommand, tvOffCommand, hottubOffCommand};
        // 创建宏命令来持有这两个数组
        MacroCommand partyOnMacroCommand = new MacroCommand(partyOn);
        MacroCommand partyOffMacroCommand = new MacroCommand(partyOff);

        // 加载宏命令到遥控器中的某个插槽
        remoteControl.setCommand(0, partyOnMacroCommand, partyOffMacroCommand);

        return remoteControl;
    }

}
