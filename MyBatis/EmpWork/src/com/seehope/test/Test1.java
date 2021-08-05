package com.seehope.test;

import com.seehope.dao.DeptDao;
import com.seehope.dao.EmpDao;
import com.seehope.dao.UserDao;
import com.seehope.entity.Dept;
import com.seehope.entity.Emp;
import com.seehope.entity.User;
import com.seehope.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        login();

    }
    static SqlSession session=MyBatisUtil.getSession();
    static UserDao userDao=session.getMapper(UserDao.class);

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username=scanner.next();
        System.out.print("请输入密码：");
        String password=scanner.next();
        List<User> list11= userDao.selectOne(username,password);
       if(list11.size()>0){
           System.out.println("***********************");
           System.out.println("欢迎用户"+username+"进入员工管理系统！！");
           System.out.println("欢迎用户"+username+"进入员工管理系统！！");
           System.out.println("欢迎用户"+username+"进入员工管理系统！！");
           System.out.println("***********************");
           start();
       } else {
           System.out.println("用户不存在！");
       }


    }

    private static void start() {
        System.out.println("欢 迎 进 入 员 工 管 理 系 统");
        System.out.println("**********************************");
        System.out.println("1.查询所有员工");
        System.out.println("2.按员工编号查询员工");
        System.out.println("3.添加员工");
        System.out.println("4.修改员工");
        System.out.println("5.删除员工");
        System.out.println("6.根据部门编号和职位查询员工（参数）");
        System.out.println("7.根据部门编号和职位查询员工（对象）");
        System.out.println("8.根据部门编号和职位查询员工（集合）");
        System.out.println("9.根据部门编号查询一个部门及其所有员工(一对多)");
        System.out.println("10.根据员工编号查询一个员工信息及其所在部门的信息(多对一)");
        System.out.println("11.退出");
        System.out.println("**********************************\n");
        System.out.println("请选择：");

        Scanner input =new Scanner(System.in);
        int choice=input.nextInt();
        switch(choice) {
            case 1:
                fillAllEmp();
                start();
                break;
            case 2:


                String input0;
                do {
                    findEmpByEmpno();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续按编号搜索数据");
                    input0 = scanner.next();
                }
                while (input0.equals("y") || input0.equals("Y")) ;
                start();
                break;
            case 3:


                String input1;
                do {
                    try {
                        insertEmp();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续插入数据");
                    input1 = scanner.next();
                }
                while (input1.equals("y") || input1.equals("Y")) ;
                start();
                break;
            case 4:

                String input2;
                do {
                    try {
                        updateEmp();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续修改数据");
                    input2 = scanner.next();
                }
                while (input2.equals("y") || input2.equals("Y")) ;
                start();
                break;
            case 5:
                String input3;
                do {
                    deleteEmp();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续删除数据");
                    input3 = scanner.next();
                }
                while (input3.equals("y") || input3.equals("Y")) ;
                start();
                break;
            case 6:

                String input4;
                do {
                    findEmpByDeptno1();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续搜索数据");
                    input4 = scanner.next();
                }
                while (input4.equals("y") || input4.equals("Y")) ;
                start();
                break;
            case 7:
                String input5;
                do {
                    findEmpByDeptno2();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续搜索数据");
                    input5 = scanner.next();
                }
                while (input5.equals("y") || input5.equals("Y")) ;
                start();
                break;
            case 8:
                String input6;
                do {
                    findEmpByDeptno3();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续搜索数据");
                    input6 = scanner.next();
                }
                while (input6.equals("y") || input6.equals("Y")) ;
                start();
                break;
            case 9:
                String input7;
                do {
                    findDeptByNo();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续搜索数据");
                    input7 = scanner.next();
                }
                while (input7.equals("y") || input7.equals("Y")) ;
                start();
                break;
            case 10:

                String input8;
                do {
                    searchEmpById();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入y或n来确认是否继续搜索数据");
                    input8 = scanner.next();
                }
                while (input8.equals("y") || input8.equals("Y")) ;
                start();
                break;
            case 11:
                System.out.println("\n谢谢使用！");
                break;
        }
    }


    static EmpDao empDao=session.getMapper(EmpDao.class);//不用实现类的动态代理方法

    private static void findEmpByDeptno3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的部门编号");
        int deno=scanner.nextInt();
        System.out.println("请输入你要查找的职位");
        String ejob=scanner.next();
        Map map=new HashMap();
        map.put("deno",deno);
        map.put("ejob",ejob);
        List<Emp> list=empDao.findEmpByDeptno3(map);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        for (Emp emp:list) {
            emp.show();

        }
    }

    private static void findEmpByDeptno2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的部门编号");
        int deno=scanner.nextInt();
        System.out.println("请输入你要查找的职位");
        String ejob=scanner.next();
        Emp emp=new Emp();
        emp.setDeno(deno);
        emp.setEjob(ejob);
        List<Emp> list=empDao.findEmpByDeptno2(emp);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        for (Emp emp1:list) {
            emp1.show();

        }
    }

    private static void findEmpByDeptno1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的部门编号");
        int deno=scanner.nextInt();
        System.out.println("请输入你要查找的职位");
        String ejob=scanner.next();
        List<Emp> list=empDao.findEmpByDeptno(deno,ejob);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        for (Emp emp1:list) {
            emp1.show();
        }
    }



    private static void deleteEmp() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入员工编号：");
        int eno=scanner.nextInt();
        int num=empDao.deleteEmp(eno);
        if(num>0){
            System.out.println("删除成功！");
        }
        session.commit();
    }

    private static void updateEmp() throws Exception{
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入要修改的员工编号：");
        int eno= scanner.nextInt();
        System.out.println("请输入要修改的员工姓名：");
        String name=scanner.next();
        System.out.println("请输入要修改的职位：");
        String ejob=scanner.next();
        System.out.println("请输入要修改的直属经理：");
        int emgr=scanner.nextInt();
        System.out.println("请输入要修改的入职日期：（xxxx-xx-xx）");
        Date edate=new SimpleDateFormat("yyyy-MM-dd").parse(scanner.next());
        System.out.println("请输入要修改的薪水：");
        double esal=scanner.nextDouble();
        System.out.println("请输入要修改的奖金：");
        double ecomm=scanner.nextDouble();
        System.out.println("请输入要修改的部门编号：");
        int deno=scanner.nextInt();
        Emp emp = new Emp(eno,name,ejob,emgr,edate,esal,ecomm,deno);
        int num=empDao.updateEmp(emp);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        System.out.println(eno+"\t"+name+"\t"+ejob+"\t"+emgr+"\t"+edate+"\t"+esal+"\t"+ecomm+"\t"+deno);
        if(num>0){
            System.out.println("修改成功！");
        }
        System.out.println("----------------------------------");
        fillAllEmp();
        session.commit();
    }



    private static void insertEmp() throws Exception{
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入员工编号：");
        int eno= scanner.nextInt();
        System.out.println("请输入员工姓名：");
        String name=scanner.next();
        System.out.println("请输入职位：");
        String ejob=scanner.next();
        System.out.println("请输入直属经理：");
        int emgr=scanner.nextInt();
        System.out.println("请输入入职日期：（xxxx-xx-xx）");
        Date edate=new SimpleDateFormat("yyyy-MM-dd").parse(scanner.next());
        System.out.println("请输入薪水：");
        double esal=scanner.nextDouble();
        System.out.println("请输入奖金：");
        double ecomm=scanner.nextDouble();
        System.out.println("请输入部门编号：");
        int deno=scanner.nextInt();
        Emp emp = new Emp(eno,name,ejob,emgr,edate,esal,ecomm,deno);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        System.out.println(eno+"\t"+name+"\t"+ejob+"\t"+emgr+"\t"+edate+"\t"+esal+"\t"+ecomm+"\t"+deno);
        int num = empDao.insertEmp(emp);
        if(num>0){
            System.out.println("添加成功！");
        }
        System.out.println("----------------------------------");
        fillAllEmp();
        session.commit();
    }



    private static void findEmpByEmpno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入员工编号:");
        int eno=scanner.nextInt();
        Emp emp= new Emp();
        emp.setEno(eno);
        List<Emp> empList = empDao.findEmpByEmpno(emp);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        for (Emp empp:empList) {
            empp.show();
        }

    }

    private static void fillAllEmp() {
        List<Emp> sList=empDao.fillAllEmp();
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        for (Emp emp:sList) {
            emp.show();
        }
    }


    static DeptDao deptDao=session.getMapper(DeptDao.class);

    private static void findDeptByNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你要查找的部门编号:");
        int no = scanner.nextInt();
        Dept dept = deptDao.findDeptByNo(no);
        System.out.println(dept.toString());
        System.out.println("该部门的员工如下：");
        List<Emp> list = dept.getEmp();
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
        for (Emp emp1 : list) {
            emp1.show();
        }
    }


    private static void searchEmpById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的员工编号:");
        int id = scanner.nextInt();
        Emp emp = empDao.searchEmpById(id);
        if (emp != null) {
            System.out.println("员工编号" + "\t" + "员工姓名" + "\t\t\t" + "职位" + "\t\t" + "经理" + "\t\t\t" + "入职时间" + "\t\t" + "薪水" + "\t\t\t\t" + "奖金" + "\t" + "部门编号");
            emp.show();
            System.out.print("部门信息：");
            Dept dept = emp.getDept();
            System.out.println(dept.toString());
        } else {
            System.out.println("没有找到");
        }
    }

}
