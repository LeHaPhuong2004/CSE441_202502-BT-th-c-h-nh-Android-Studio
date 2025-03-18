package com.example.tlucontact;

public class Donvi {
    private String tenDV, sdtDV, emailDV, diachiDV;
    private int avatarDV;

    public String getTenDV() {
        return tenDV;
    }

    public String getSdtDV() {
        return sdtDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public void setSdtDV(String sdtDV) {
        this.sdtDV = sdtDV;
    }

    public void setEmailDV(String emailDV) {
        this.emailDV = emailDV;
    }

    public void setAvatarDV(int avatarDV) {
        this.avatarDV = avatarDV;
    }

    public void setDiachiDV(String diachiDV) {
        this.diachiDV = diachiDV;
    }

    public String getEmailDV() {
        return emailDV;
    }

    public int getAvatarDV() {
        return avatarDV;
    }

    public String getDiachiDV() {
        return diachiDV;
    }

    public Donvi(String tenDV, String sdtDV, String emailDV, String diachiDV, int avatarDV) {
        this.tenDV = tenDV;
        this.sdtDV = sdtDV;
        this.emailDV = emailDV;
        this.diachiDV = diachiDV;
        this.avatarDV = avatarDV;
    }

    public Donvi() {
    }

}
