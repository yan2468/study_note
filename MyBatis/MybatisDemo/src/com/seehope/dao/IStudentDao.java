package com.seehope.dao;

import com.seehope.entity.Student;

import java.util.List;

public interface IStudentDao {

        public List<Student> findAllStudents();//查找全部学生
        public Student findStudentById(int sid);//查找某id的学生

}
