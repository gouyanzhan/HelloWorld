package com.siwuxie095.forme.designpattern.category.chapter11th.example2nd;


/**
 * @author Jiajing Li
 * @date 2019-11-08 19:18:11
 */
public class Main {

    /**
     * 远程方法调用的过程
     *
     * 假如想要设计一个系统，能够调用本地的某个对象（代理对象），然后将每个请求转发到远程对象（服务对象）
     * 上进行，要如何设计？此时，就需要一些辅助对象，帮助我们真正进行沟通。
     *
     * （1）辅助对象分为：客户辅助对象 和 服务辅助对象。
     * （2）客户对象和客户辅助对象在客户端的堆中，服务对象和服务辅助对象在服务器端的堆中。
     *
     * 这些辅助对象使客户就像在调用本地对象的方法一样。客户调用客户辅助对象上的方法，仿佛客户辅助对象就是
     * 真正的服务。客户辅助对象再负责为我们转发这些请求。
     *
     * 换句话说，客户对象以为它调用的是远程服务上的方法，因为客户辅助对象乔装成服务对象，假装自己有客户所
     * 要调用的方法。
     *
     * 但是客户辅助对象不是真正的远程对象。虽然操作看起来很像（因为具有服务所宣称的相同的方法），但是并不
     * 真正拥有客户所期望的方法逻辑。客户辅助对象会联系服务器，传送方法调用信息（方法名、变量等），然后等
     * 待服务器的返回。
     *
     * 在服务器端，服务辅助对象从客户辅助对象中接收请求（通过 socket 连接），将调用的信息解包，然后调用
     * 真正服务对象上的真正方法。所以，对于服务对象来说，调用是本地的，且来自服务辅助对象，而不是远程客户。
     *
     * 服务辅助对象从服务中得到返回值，将它打包，然后运回到客户辅助对象（通过网络 socket 的输出流），客
     * 户辅助对象对信息解包，最后将返回值交给客户对象。
     *
     *
     *
     * 利用 RMI 进行远程方法调用
     *
     * RMI 提供了客户辅助对象和服务辅助对象，为客户辅助对象创建和服务对象相同的方法。RMI 的好处在于你不必
     * 亲自写任何网络或 I/O 代码。客户程序调用远程方法（即 真正的服务所在）就和对本地 JVM 上的对象进行正
     * 常方法调用一样。
     *
     * RMI 也提供了所有运行时的基础设施，好让这一切正常工作。这包括了查找服务（lookup service），它用来
     * 寻找和访问远程对象。
     *
     * 关于 RMI 调用和本地的方法调用，有一个不同点。虽然调用远程方法就如同调用本地方法一样，但是客户辅助对
     * 象会通过网络发送方法调用，所以网络和 I/O 是的确存在的。而网络和 I/O 是有风险的，容易失败的，所以随
     * 时都有可能抛出异常，也因此，客户必须意识到风险的存在。
     *
     * 在 RMI 中，将客户辅助对象称为 stub（桩/存根），将服务辅助对象称为 skeleton（骨架）。
     *
     *
     * 注意：
     * 较新版的 Java 不需要一个显式的 skeleton 对象，但在服务器端仍然有一些东西负责 skeleton 的行为。
     *
     *
     *
     * 制作远程服务
     *
     * 制作远程服务一共有 5 个步骤。
     *
     * 步骤一：制作远程接口
     * （1）制作远程接口 MyRemote，且需要扩展自 java.rmi.Remote。由于 Remote 是一个 "记号" 接口，所
     * 以它不具有方法。但因为 Remote 接口具有特别的意义，所以必须遵守规则。扩展自 Remote 接口，就可以表
     * 示 MyRemote 接口要用来支持远程调用。
     * （2）然后将 MyRemote 接口中的所有方法都声明为会抛出 RemoteException。客户会调用实现远程接口的
     * Stub 上的方法，而 Stub 底层用到了网络和 I/O，所以各种坏事情都可能会发生。客户必须认识到风险，通过
     * 处理或声明远程异常来解决。如果接口中的方法声明了异常，任何在接口类型的引用上调用方法的代码也必须处理
     * 或声明异常。
     * （3）确定参数和返回值是属于原语（primitive）类型或者可序列化（serializable）类型。因为网络传输需
     * 要通过序列化来完成。
     *
     *
     * 步骤二：制作远程实现
     * （1）你的服务需要实现远程接口，也就是客户将要调用的方法的接口。
     * （2）扩展 UnicastRemoteObject。为了要成为远程服务对象，你的对象需要某些 "远程" 的功能。最简单的
     * 方式是扩展是 java.rmi.server.UnicastRemoteObject。让它来帮忙做这些工作。
     * （3）设计一个不带变量的构造器，并声明 RemoteException。因为 UnicastRemoteObject 的构造器会抛
     * 出 RemoteException，唯一解决这个问题的方法就是为你的远程实现声明一个构造器，这样就有了一个声明
     * RemoteException 的地方。当类被实例化的时候，超类的构造器总是会先被调用。如果超类的构造器抛出异常，
     * 那么只能声明子类的构造器也抛出异常。
     * （4）用 RMI Registry 注册此服务。现在已经有了一个远程服务，必须让它可以被远程客户调用。要做的事情
     * 就是将此服务实例化，然后放进 RMI Registry 中（注意：需要先确定 RMI Registry 正在运行，否则注册
     * 会失败）。当注册这个实现对象时，RMI 系统其实注册的是 Stub，因为这是客户真正需要的。注册服务使用了
     * java.rmi.Naming 类的 rebind() 方法。
     *
     *
     * 步骤三：产生 Stub 和 Skeleton
     * rmic 是 JDK 内的一个工具，用来为一个服务类产生 Stub 和 Skeleton。命名习惯是在远程实现的名字后面
     * 加上 _Stub 和 _Skel。rmic 有一些选项可以调整，包括不要产生 Skeleton、查看源代码、甚至使用 IIOP
     * 作为协议。这里使用 rmic 的方式是常用方式。
     * （注意：由于这里使用的 Java 版本较新，所以默认已经不产生 Skeleton 了。所以下面就只说 Stub）
     *
     * rmic 是根据编译后的 class 文件来产生 Stub，方法如下：
     * （1）先编译 MyRemote 接口和 MyRemoteImpl 实现。进入当前包 example2nd 下，打开终端，
     * javac MyRemote.java MyRemoteImpl.java -d /Users/siwuxie095/IdeaProjects/HelloWorld/src/com/siwuxie095/forme/designpattern/category/chapter11th/example2nd
     * （注意：指定编译目录一直到当前包下）
     * （2）继续在当前包 example2nd 下操作终端。这样 MyRemoteImpl_Stub.class 就产生了。
     * rmic com.siwuxie095.forme.designpattern.category.chapter11th.example2nd.MyRemoteImpl
     * （注意：实际上针对的是 MyRemoteImpl.class）
     *
     *
     * 步骤四：执行 rmiregistry
     * 继续在当前包 example2nd 下操作终端，输入 rmiregistry。
     *
     *
     * 步骤五：启动服务
     *
     * 开启另一个终端，依然在当前包 example2nd 下操作。这里从实现类中的 main() 方法启动，先实例化一个服务
     * 对象，然后到 RMI Registry 中注册。
     * 在当前包 example2nd 下操作终端。
     * java com.siwuxie095.forme.designpattern.category.chapter11th.example2nd.MyRemoteImpl
     *
     *
     *
     * 客户如何取得 Stub 对象？
     *
     * 客户必须取得 Stub 对象（代理对象）以调用其中的方法。所以就需要 RMI Registry 帮忙。客户从 Registry
     * 总寻找（lookup）代理。
     *
     * 在当前包 example2nd 下操作终端。
     * javac MyClient.java -d /Users/siwuxie095/IdeaProjects/HelloWorld/src/com/siwuxie095/forme/designpattern/category/chapter11th/example2nd
     * java com.siwuxie095.forme.designpattern.category.chapter11th.example2nd.MyClient
     * （也将 MyClient.java 编译到指定目录，再执行）
     *
     * 最后大功告成！
     *
     *
     *
     * 对于 RMI，最常见的三个错误：
     * （1）忘了在启动远程服务之前先启动 rmiregistry（因为要用 Naming.rebind() 注册服务，rmiregistry
     * 必须是运行的）。
     * （2）忘了让参数和返回值的类型成为可序列化的类型（这种错误无法在编译期发现，只会在运行时发现）。
     * （3）忘了给客户提供 Stub 类。
     */
    public static void main(String[] args) {

    }

}
