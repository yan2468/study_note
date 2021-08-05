package com.seehope.entity;

import java.util.List;

public class Dept {
    private int deptno;
    private String dname;
    private String loc;
    private List<Emp> emp;


    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return
                "部门编号=" + getDeptno()+
                ", 部门名称=" + getDname()+
                ",部门所在地=" + getLoc()
                ;
    }
}
