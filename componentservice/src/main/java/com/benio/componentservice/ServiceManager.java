package com.benio.componentservice;

import android.support.v4.util.ArrayMap;

import java.lang.reflect.Proxy;
import java.util.Map;

public final class ServiceManager {
    public static final Class<AccountService> ACCOUNT_SERVICE = AccountService.class;

    private static final Map<Class, IService> SERVICE = new ArrayMap<>();

    public static <T extends IService> T getService(Class<T> cls) {
        IService service = SERVICE.get(cls);
        if (service == null) {
            service = (IService) Proxy.newProxyInstance(cls.getClassLoader(), new Class<?>[]{cls}, new NoActionProxy());
            SERVICE.put(cls, service);
        }
        return (T) service;
    }

    public static <T extends IService> void registerService(Class<T> cls, IService service) {
        SERVICE.put(cls, service);
    }

    public static void unregisterService(Class cls) {
        SERVICE.remove(cls);
    }
}
