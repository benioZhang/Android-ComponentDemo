package com.benio.componentservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 用来防止NPE
 * 参考：https://www.jianshu.com/p/efc4991e2aa5
 */
public class NoActionProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Type type = method.getReturnType();
        if (type == boolean.class) {
            return false;
        } else if (type == int.class) {
            return 0;
        } else if (type == short.class) {
            return (short) 0;
        } else if (type == char.class) {
            return (char) 0;
        } else if (type == byte.class) {
            return (byte) 0;
        } else if (type == long.class) {
            return 0L;
        } else if (type == float.class) {
            return 0f;
        } else if (type == double.class) {
            return 0D;
        } else {
            return null;
        }
    }
}
