package com.android.learn.base.utils.account;

import com.android.learn.base.event.LoginEvent;
import com.android.learn.base.mmodel.RegisterLoginData;

import org.greenrobot.eventbus.EventBus;

public class UserUtil {

    private static class InstanceHolder {
        static UserUtil instance = new UserUtil();
    }
    public static UserUtil get() {
        return InstanceHolder.instance;
    }

    private boolean logined = false;
    private RegisterLoginData userInfo;

    public boolean isLogined() {
        return logined;
    }

    public void setLogined(boolean logined) {
        this.logined = logined;
    }

    public RegisterLoginData getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(RegisterLoginData userInfo) {
        this.userInfo = userInfo;
        if (userInfo != null) {
            setLogined(true);
        } else {
            setLogined(false);
        }
        LoginEvent accountEvent = new LoginEvent();
        EventBus.getDefault().post(accountEvent);

    }
}
