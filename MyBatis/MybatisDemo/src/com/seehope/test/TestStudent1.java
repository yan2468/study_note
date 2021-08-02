package com.seehope.test;

import com.seehope.dao.IStudentDao;
import com.seehope.dao.StudentDaoImpl;
import com.seehope.entity.Student;

import java.util.List;
import java.util.Scanner;

public class TestStudent1 {
    public static void main(String[] args) {
//        findAllStudents();
        findStudentById();
    }

    private static void findStudentById() {
        IStudentDao studentDao = new StudentDaoImpl();//创建接口对象
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你要查找的学生学号:");
        int sid = scanner.nextInt();
        Student student=studentDao.findStudentById(sid);
        //↑ ↑  IStudentDao接口对象使用它的实现类StudentDaoImpl的findStudentById方法寻找结果，再将找到的结果传出给Student对象
        if(student!=null){
            student.show();
        }
        else {
            System.out.println("没有找到！");
        }
    }

    public static void findAllStudents(){
        IStudentDao studentDao=new StudentDaoImpl();  //左边接口，右边实现类
        List<Student> sList=studentDao.findAllStudents();
//        for(int i=0;i<sList.size();i++){
//            sList.get(i).show();
//        }
        for (Student student:sList) {
            student.show();

        }
    }
}
