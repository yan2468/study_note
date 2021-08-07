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
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //浏览器--传递--》服务器
        response.setContentType("text/html;charset=UTF-8");// 服务器--响应--》客户端


        SqlSession session= MyBatisUtil.getSession();
        UserDao userDao=session.getMapper(UserDao.class);
        String userName = request.getParameter("userName");
        User user= new User();
        user.setUserName(userName);
        List<User> userList = userDao.findUserByUserName(user);
        for (User userr:userList) {

            PrintWriter out = response.getWriter();
            out.println("姓名："+userr.getUserName());
            out.println("密码："+userr.getUserPassword());
            out.println("性别："+userr.getSex());
            out.println("学校："+userr.getSchool());
            out.println("爱好："+userr.getHobby());
            out.println("生日："+userr.getBirthday());
            out.println("手机号："+userr.getPhoneNumber());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
