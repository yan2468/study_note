package com.seehope.servlet;

import com.seehope.dao.UserDao;
import com.seehope.entity.User;
import com.seehope.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//打开regist.html 和 login2.html
@WebServlet(value = "/register2")
public class RegisterServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //浏览器--传递--》服务器
        response.setContentType("text/html;charset=UTF-8");// 服务器--响应--》客户端


//        int userID= Integer.parseInt(request.getParameter("userID"));  // 用户编号用户不可见
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String sex=request.getParameter("sex");
        String school=request.getParameter("school");
        String[] hobbies=request.getParameterValues("hobby");
        String birthday=request.getParameter("birthday");
        String phoneNumber=request.getParameter("phoneNumber");


        StringBuilder hobby = new StringBuilder();
        for(int i=0;i<hobbies.length;i++){
            hobby.append(hobbies[i]);
            hobby.append(",");
        }

        User user=new User(userName,userPassword,sex,school, hobby.toString(),birthday,phoneNumber);//保存数据到user对象
        System.out.println(user);
        SqlSession session= MyBatisUtil.getSession();
        UserDao userDao=session.getMapper(UserDao.class);
        int num = userDao.insertUser(user);
        if(num>0){
            System.out.println("添加成功！");
        }
        session.commit();

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
