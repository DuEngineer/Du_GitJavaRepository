package com.du.hd_proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void Test_Proxy(){
        /*创建目标类对象*/
        UsbKingFactory usbKingFactory = new UsbKingFactory();
        /*创建InvocationHandler实现类对象*/
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(usbKingFactory);
        /*创建动态代理类对象*/
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(usbKingFactory.getClass().getClassLoader(),
                              usbKingFactory.getClass().getInterfaces(),
                              invocationHandler);
        /*调用代理类方法*/
        float price = proxy.Proxy_sell(10);
        System.out.println(price);
    }
}
