/*
@author NB
@date 2019/3/27 - 10:41
*/

package com.student.entity;

public class Student {
    private int sno;
    private String sname;
    private int sage;
    private String saddress;
    private String sclass;
    private String smajor;



    public Student() {

    }
    public Student( String sname, int sage, String saddress, String sclass, String smajor) {
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
        this.sclass = sclass;
        this.smajor = smajor;
    }
    public Student(int sno, String sname, int sage, String saddress,String sclass,String smajor) {
        super();
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
        this.sclass = sclass;
        this.smajor = smajor;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }


    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }
    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSclass() { return sclass; }

    public void setSclass(String sclass) { this.sclass = sclass; }

    public String getSmajor() { return smajor; }

    public void setSmajor(String smajor) { this.smajor = smajor; }
    @Override
    public String toString() {
        return this.getSno()+"-"+this.getSname()+"-"+this.getSage()+"-"+this.getSaddress();
    }
}

