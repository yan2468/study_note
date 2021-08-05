package com.seehope.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Emp {
    private int eno;
    private String name;
    private  String ejob;
    private int emgr;
    private Date edate;
    private double esal;
    private double ecomm;
    private int deno;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void show(){
//        System.out.println("员工编号："+eno+" 员工姓名："+name+" 职位："+ejob+" 经理："+emgr+"入职时间:"+edate+"薪水:"+esal+"奖金:"+ecomm+"部门编号："+deno);
        System.out.println(String.format("% 4d", eno)+"\t"+
                 String.format("%-8s", name)+"\t"+
                 String.format("%-8s", ejob)+"\t"+
                 String.format("%-8d", emgr)+"\t"+
                 new SimpleDateFormat("yyyy-MM-dd").format(edate)+"\t"+
                 String.format("%-8f", esal)+"\t"+
                 String.format("%-8f", ecomm)+"\t"+
                 String.format("%-8d", deno)
                );

    }

    public Emp() {
    }

    public Emp(int eno, String name, String ejob, int emgr, Date edate, double esal, double ecomm, int deno) {
        this.eno = eno;
        this.name = name;
        this.ejob = ejob;
        this.emgr = emgr;
        this.edate = edate;
        this.esal = esal;
        this.ecomm = ecomm;
        this.deno = deno;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEjob() {
        return ejob;
    }

    public void setEjob(String ejob) {
        this.ejob = ejob;
    }

    public int getEmgr() {
        return emgr;
    }

    public void setEmgr(int emgr) {
        this.emgr = emgr;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    public double getEcomm() {
        return ecomm;
    }

    public void setEcomm(double ecomm) {
        this.ecomm = ecomm;
    }

    public int getDeno() {
        return deno;
    }

    public void setDeno(int deno) {
        this.deno = deno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eno=" + eno +
                ", name='" + name + '\'' +
                ", ejob='" + ejob + '\'' +
                ", emgr=" + emgr +
                ", edate='" + edate + '\'' +
                ", esal=" + esal +
                ", ecomm=" + ecomm +
                ", deno=" + deno +
                '}';
    }
}
