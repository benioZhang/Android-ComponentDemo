package com.benio.component.demo;

import com.benio.base.ApplicationDelegate;
import com.benio.base.ApplicationDelegateDispatcher;
import com.benio.base.BaseApplication;

public class MyApplication extends BaseApplication {
    private static String[] DELEGATES;

    static {
        DELEGATES = new String[]{
                "com.benio.login.LoginApp",
                "com.benio.share.ShareApp",
        };
    }

    @Override
    public void onCreate() {
        createApplicationDelegates();
        super.onCreate();
    }

    // ApplicationDelegate的注册可使用反射，APT，AspectJ，Javassist等
    private static void createApplicationDelegates() {
        String[] delegates = DELEGATES;
        for (String name : delegates) {
            try {
                Class<?> cls = Class.forName(name);
                if (ApplicationDelegate.class.isAssignableFrom(cls)) {
                    ApplicationDelegate delegate = (ApplicationDelegate) cls.newInstance();
                    ApplicationDelegateDispatcher.get().add(delegate);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
