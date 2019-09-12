package com.benio.componentservice;

import android.support.v4.util.ArrayMap;

import java.lang.reflect.Proxy;
import java.util.Map;

public class AppRouter {
    private static final Map<Class, IRoute> ROUTES = new ArrayMap<>();

    public static <T extends IRoute> T get(Class<T> cls) {
        IRoute route = ROUTES.get(cls);
        if (route == null) {
            // 为了避免 NullPointException，减少调用者频繁的判空操作, 返回一个动态代理
            route = (IRoute) Proxy.newProxyInstance(cls.getClassLoader(), new Class<?>[]{cls}, new NoActionProxy());
            // 保存到ROUTES
            ROUTES.put(cls, route);
        }
        return (T) route;
    }

    public static <T extends IRoute> void register(Class<T> cls, T service) {
        ROUTES.put(cls, service);
    }

    public static <T extends IRoute> void unregister(Class<T> cls) {
        ROUTES.remove(cls);
    }
}
