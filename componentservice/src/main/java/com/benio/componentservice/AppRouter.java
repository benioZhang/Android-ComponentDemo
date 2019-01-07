package com.benio.componentservice;

import java.util.HashMap;
import java.util.Map;

public class AppRouter {
    public static final String LOGIN = "login";
    public static final String SHARE = "share";

    private static final Map<String, RoadMap> ROAD_MAPS = new HashMap<>();

    public static <T extends RoadMap> T get(String name) {
        return (T) ROAD_MAPS.get(name);
    }

    public static void register(String name, RoadMap service) {
        ROAD_MAPS.put(name, service);
    }

    public static void remove(String name) {
        ROAD_MAPS.remove(name);
    }
}
