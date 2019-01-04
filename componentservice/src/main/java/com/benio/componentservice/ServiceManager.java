package com.benio.componentservice;

import java.util.HashMap;
import java.util.Map;

public final class ServiceManager {
    public static final String ACCOUNT_SERVICE = "account";

    private static final Map<String, Object> SERVICE = new HashMap<>();

    public static <T> T getService(String name) {
        return (T) SERVICE.get(name);
    }

    public static void registerService(String name, Object service) {
        SERVICE.put(name, service);
    }

    public static void removeService(String name) {
        SERVICE.remove(name);
    }
}
