package com.example.droidcafe;

public class Student {
    public String getSid() {
        return sid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getAvatar() {
        return avatar;
    }

    public Student(String fullname, String sid, int avatar) {
        this.fullname = fullname;
        this.sid = sid;
        this.avatar = avatar;
    }

    private String sid;

    public Student() {
    }

    private String fullname;
    private int avatar;

}
