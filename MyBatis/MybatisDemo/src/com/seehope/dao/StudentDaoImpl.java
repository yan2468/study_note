package com.seehope.dao;

import com.seehope.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> findAllStudents() {
        SqlSession session = null;//SqlSession对象里有各种增删改查方法
        List<Student> list = new ArrayList<Student>();
        try {
//1.读取主配置文件mybatis-config.xml
            String resource = "mybatis-config.xml";//加载配置文件
            Reader reader = Resources.getResourceAsReader(resource);//读取映射文件
//2.根据主配置文件mybatis-config.xml构建SqlSessionFactory对象factory
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
//3.根据SqlSessionFactory对象创建SqlSession对象session
            session = factory.openSession();//SqlSession对象里有各种增删改查方法
//4.调用SqlSession对象session的selectList方法执行查询数据库的操作，返回映射后的结果集合(泛型集合)
            list = session.selectList("com.seehope.dao.IStudentDao.findAllStudents");//执行映射文件中的SQL语句


        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    @Override
    public Student findStudentById(int sid) {
       SqlSession session=null;
       Student student=null;
        try {
//1.读取主配置文件mybatis-config.xml
            String resource = "mybatis-config.xml";//加载配置文件
            Reader reader = Resources.getResourceAsReader(resource);//读取映射文件
//2.根据主配置文件mybatis-config.xml构建SqlSessionFactory对象factory
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
//3.根据SqlSessionFactory对象创建SqlSession对象session
            session = factory.openSession();//SqlSession对象里有各种增删改查方法
//4.调用SqlSession对象session的selectList方法执行查询数据库的操作，返回映射后的结果(一个学生)
            student = session.selectOne("com.seehope.dao.IStudentDao.findStudentById",sid);//执行映射文件中的SQL语句

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return student;
    }
}
