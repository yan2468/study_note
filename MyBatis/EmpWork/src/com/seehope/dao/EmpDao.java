package com.seehope.dao;

import com.seehope.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    public List<Emp> fillAllEmp();//查询所有员工

    public List<Emp> findEmpByEmpno(Emp emp);//根据编号查员工

    public int insertEmp(Emp emp);//添加一个员工

    public int updateEmp(Emp emp);//修改一个员工

    public int deleteEmp(int eno);//删除一个员工

    public List<Emp> findEmpByDeptno(@Param("deno") int deno, @Param("ejob") String ejob);//根据部门编号查员工

    public List<Emp> findEmpByDeptno2(Emp emp);
    public List<Emp> findEmpByDeptno3(Map map);

    public Emp searchEmpById(int id);


}
