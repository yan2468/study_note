package com.seehope.entity;

public class Student {
    private int sid;//学号
    private String sname;
    private String sex;
    private int age;

    public void show(){
        System.out.println("学生编号："+sid+" 学生姓名："+sname+" 学生性别："+sex+" 学生年龄："+age);
    }

    public Student() {
    }

    public Student(int sid, String sname, String sex, int age) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
