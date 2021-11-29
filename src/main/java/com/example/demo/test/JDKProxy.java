package com.example.demo.test;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.thymeleaf.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ((RealHello)target).invoke();
    }
}

class ProxyTest{
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy(new RealHello());
    }
}

