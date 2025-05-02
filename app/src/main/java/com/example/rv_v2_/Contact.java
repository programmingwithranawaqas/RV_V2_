package com.example.rv_v2_;

public class Contact {
    private String name;
    private String profileUrl;
    private String msg;
    private String time;
    private int notifications;
    private boolean isPin;

    public Contact() {
    }

    public Contact(boolean isPin, String msg, String name, int notifications, String profileUrl, String time) {
        this.isPin = isPin;
        this.msg = msg;
        this.name = name;
        this.notifications = notifications;
        this.profileUrl = profileUrl;
        this.time = time;
    }

    public boolean isPin() {
        return isPin;
    }

    public void setPin(boolean pin) {
        isPin = pin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNotifications() {
        return notifications;
    }

    public void setNotifications(int notifications) {
        this.notifications = notifications;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
