package com.csy.vo;

public class UserVO {

    private String uName;

    private Integer uSex;

    private String uPhone;

    private String uImgurl;

    private Integer iId;
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    private Integer uTime;

    private String uIntro;

    private String userID;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuImgurl() {
        return uImgurl;
    }

    public void setuImgurl(String uImgurl) {
        this.uImgurl = uImgurl;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getuTime() {
        return uTime;
    }

    public void setuTime(Integer uTime) {
        this.uTime = uTime;
    }

    public String getuIntro() {
        return uIntro;
    }

    public void setuIntro(String uIntro) {
        this.uIntro = uIntro;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
