package com.example.tlucontact;

public class CBNV {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public void setDvct(String dvct) {
        this.dvct = dvct;
    }

    public void setHocvi(String hocvi) {
        this.hocvi = hocvi;
    }

    public void setBomon(String bomon) {
        this.bomon = bomon;
    }

    public void setAvatarcb(int avatarcb) {
        this.avatarcb = avatarcb;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getChucvu() {
        return chucvu;
    }

    public String getDvct() {
        return dvct;
    }

    public String getHocvi() {
        return hocvi;
    }

    public int getAvatarcb() {
        return avatarcb;
    }

    public String getBomon() {
        return bomon;
    }

    public CBNV(String name, String sdt, String email, String chucvu, String hocvi, String dvct, String bomon, int avatarcb) {
        this.name = name;
        this.sdt = sdt;
        this.email = email;
        this.chucvu = chucvu;
        this.hocvi = hocvi;
        this.dvct = dvct;
        this.bomon = bomon;
        this.avatarcb = avatarcb;
    }

    public CBNV() {
    }


    private String name, sdt, email, chucvu, dvct, hocvi, bomon;
    private int avatarcb;


}
