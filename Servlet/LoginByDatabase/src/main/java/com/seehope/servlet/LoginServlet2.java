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
import java.util.List;

@WebServlet(value = "/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //浏览器--传递--》服务器
        response.setContentType("text/html;charset=UTF-8");// 服务器--响应--》客户端
        SqlSession session= MyBatisUtil.getSession();
        UserDao userDao=session.getMapper(UserDao.class);

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        List<User> list11= userDao.selectOne(userName,userPassword);

        if(list11.size()>0){
            System.out.println("登录成功");
            request.getRequestDispatcher("home").forward(request,response);//转发参数到下一个界面，转发才能使下个页面获取到数据
        } else {
            System.out.println("用户不存在！");
            response.sendRedirect("login2.html");//重定向,回原来的界面，重定向只能转页面不能带参数
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
