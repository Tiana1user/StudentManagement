/*
@author NB
@date 2019/4/10 - 15:43
*/

package com.student.entity;

public class userstudent {
    private int uid;
    private String upwd;
    private String uname;

    public userstudent(int uid, String upwd, String uname) {
        this.uid = uid;
        this.upwd = upwd;
        this.uname = uname;
    }
    public userstudent(String uname) {
        this.uname = uname;
    }

    public userstudent() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

}
