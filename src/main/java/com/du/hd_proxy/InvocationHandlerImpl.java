package com.du.hd_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private Object target = null;
    public InvocationHandlerImpl(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        obj = method.invoke(target, args);
        if(null!=obj){
            Float price = (Float)obj;
            price = price - 20;
            obj = price;
        }
        return obj;
    }
}
