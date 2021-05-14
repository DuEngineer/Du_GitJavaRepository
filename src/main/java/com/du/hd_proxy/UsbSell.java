package com.du.hd_proxy;

public interface UsbSell {
    /***************************************************************************************************************************
     *  @fn             Proxy_sell
     *  @brief          出售U盘功能方法
     *  @type           抽象方法
     *  @detail         jdk动态代理要求目标类和代理类实现相同的接口，若不存在接口，是无法使用jdk动态代理。静态代理中，是由我们自己创建一个
     *                             Java类作为代理类，而使用jdk动态代理是不需要我们创建代理类，而是使用jdk的反射机制，直接创建代理类对象，
     *                             并且动态的指定要代理的目标类。
     *                  jdk动态代理的实现需要一包三类（Java.lang.reflect包：InvocationHandler类、Method类、Proxy类）
     *                            InvocationHandler是一个接口类，里面有且仅有一个方法invoke(),是用来编写代理对象要执行的功能代码
     *                            Method类是用来调用目标方法，实现目标方法的功能
     *                            Proxy类是用来创建代理对象
     *                  jdk动态代理的实现步骤：
     *                            1、创建一个接口，定义目标类要完成的功能的抽象方法
     *                            2、创建目标类，实现该接口
     *                            3、创建InvocationHandler接口的实现类，在invoke方法中完成代理类的功能（调用目标方法和增强功能）
     *                            4、使用Proxy类的静态方法newProxyInstance()创建代理对象，并把返回值转为接口类型
     *                            5、最后通过代理类对象就可以调用增强后的目标方法
     *  @param[in]      usbNum    出售U盘的数量
     *  @return         float     U盘出售总的价格
     *  @author         DZH
     *  @date           2021.05.12
     **************************************************************************************************************************/
     public float Proxy_sell(int usbNum);
}
