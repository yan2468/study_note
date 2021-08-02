# MYSQL





>  
>
> 1. DDL(Data Definition Language)**数据定义语言**
>
>    ​	用来定义数据库对象：数据库，表，列等。关键字：create, drop,alter 等
>
> 2. DML(Data Manipulation Language)**数据操作语言**
>
>    ​	用来对数据库中表的数据进行增删改。关键字：insert, delete, update 等
>
> 3.  DQL(Data Query Language)**数据查询语言**
>
>    ​	用来查询数据库中表的记录(数据)。关键字：select, where 等
>
> 4.  DCL(Data Control Language)**数据控制语言**(了解)
>
> ​            用来定义数据库的访问权限和安全级别，及创建用户。关键字：GRANT， REVOKE 等

------



>  MySQL服务启动，一般开机自动启动
>
> ​             1. 手动。
>
> ​             2. cmd--> services.msc 打开服务的窗口
>
> ​             3. 使用管理员打开cmd
>
> ​                  \* net start mysql : 启动mysql的服务
>
> ​                  \* net stop mysql:关闭mysql服务
>
> MySQL登录
>
> ​             1. mysql -uroot -p密码  
>
> ​             2. mysql -hip -uroot -p连接目标的密码
>
> ​             3. mysql --host=ip --user=root --password=连接目标的密码
>
> MySQL退出
>
> ​             1. exit
>
> ​             2. quit   
>
> MySQL目录结构
>
> ​             1. MySQL安装目录：basedir="D:/develop/MySQL/"
>
> ​                  配置文件 my.ini
>
> ​             2. MySQL数据目录：datadir="C:/ProgramData/MySQL/MySQL Server 5.5/Data/"
>
> ​                   几个概念
>
> ​                      \* 数据库：文件夹
>
> ​                      \* 表：文件
>
> ​                      \* 数据：数据

------



### 数据库管理系统、数据库和表的关系

> 1. 一个数据库服务器包含多个库
> 2. 一个数据库包含多张表
> 3. 一张表包含多条记录



# 数据库操作

```SQL
使用数据库
			* 查询当前正在使用的数据库名称
				* select database();
			* 使用数据库
				* use 数据库名称;
```



# 创建

```sql
* 创建数据库
			* 创建数据库：
				* create database 数据库名称;
			* 创建数据库，判断不存在，再创建：
				* create database if not exists 数据库名称;
			* 创建数据库，并指定字符集
				* create database 数据库名称 character set 字符集名;
				
* 创建表
				create table student(
					id int,
					name varchar(50),
                    gender CHAR(2),   -- 一个中文占两个字节
					age int ,
					score double(4,1),    -- 4使数据的总长度，小数点不占位置。1成为标度，是指小数点后面的长度是1。
					birthday date,
					insert_time timestamp
				);
				* 注意：最后一列，不需要加逗号（,）
				
				
				
* 复制表：
		语法： create table 新表名 like 被复制的表名;	  	
-- 创建一个 s1 的表与 student 结构相同create table s1 like student;
```

> * 常见数据类型：
>      	1. int：整数类型
>      					*age int,
>      	2. double:小数类型
>           	          *score double(5,2)
>      	3. date:日期，只包含年月日，yyyy-MM-dd
>      	4. datetime:日期，包含年月日时分秒	 yyyy-MM-dd HH:mm:ss
>      	5. timestamp:时间戳类型	包含年月日时分秒	 yyyy-MM-dd HH:mm:ss	
>           	            *如果将来不给这个字段赋值，或赋值为null，则默认使用当前的系统时间，来自动赋值
>           			           注：有些时候需要自己设置，将Default设为DEFAULT CURRENT_TIMESTAMP
>
>      ​	6.varchar：字符串
>
>      ​                            name varchar(20):姓名最大20个字符
>      ​                            angsan 8个字符  张三 2个字符
>
>      



# 删除

```sql
* 删除数据库
				* drop database 数据库名称;
			* 判断数据库存在，存在再删除
				* drop database if exists 数据库名称;
				
* 删除表
                * drop table 表名;
                * drop table  if exists 表名 ;   -- 存在就删除			
             * 删除列
				* alter table 表名 drop 列名;
				
* 删除数据	
				* delete from 表名 [where 条件]
				注意：
			1. 如果不加条件，则删除表中所有记录。
			2. 如果要删除所有记录
				1. delete from 表名; -- 不推荐使用。有多少条记录就会执行多少次删除操作
				2. TRUNCATE TABLE 表名; -- 推荐使用，效率更高 先删除表，然后再创建一张一样的表(结构)。


```



# 修改

```sql
* 修改数据库
			* 修改数据库的字符集
				* alter database 数据库名称 character set 字符集名称;
				
* 修改表
			1.修改表名
				* alter table 表名 rename to 新的表名;
			2. 修改表的字符集
				* alter table 表名 character set 字符集名称;
			3. 添加一列
				* alter table 表名 add 列名 数据类型;
                        eg:为学生表添加一个新的字段 remark,类型为 varchar(20)：
                           		 alter table student add remark varchar(20);
			4. 修改列名称 类型
				* alter table 表名 change 列名 新列别 新数据类型;
								
* 修改数据
				UPDATE 表名 SET 列名1=列值1，列名2=列值2 ... WHERE 列名=值
				
				-- 不带条件修改数据，将所有的性别改成女
					* update student set sex = '女';

                -- 带条件修改数据，将 id 号为 2 的学生性别改成男
               		* update student set sex='男' where id=2;

                -- 一次修改多个列，把 id 为 3 的学生，年龄改成 26 岁，address 改成北京
                	* update student set age=26, address='北京' where id=3;

```



# 查询



## 查询数据库

```sql
			* 查询所有数据库的名称:
				* show databases;
			* 查询某个数据库的字符集:查询某个数据库的创建语句
				* show create database 数据库名称;
```



## 查询表

```sql
			* 查询某个数据库中所有的表名称
				* show tables;
			* 查询表结构
				* desc 表名;
```



## 查询数据

```sql

            查询不会对数据库中的数据进行修改.而是让数据库发送结果集给客户端,查询返回的结果集是一张虚拟表, 是一种显示数据的方式。
            注意：
            1)	SELECT 命令可以读取一行或者多行记录。
            2)	你可以使用星号（*）来代替其他字段，SELECT 语句会返回表的所有字段数据
            示例： select * from student;


            语法：
                select
                        字段列表
                    from
                        表名列表
                    where
                        条件列表

                    group by
                        分组字段
                    having
                        分组之后的条件
                    order by
                        排序
                    limit
                        分页限定

            --------------------------基础查询-----------------
            1. 多个字段的查询
                        select 字段名1，字段名2... from 表名；
                        * 注意：
                            * 如果查询所有字段，则可以使用*来替代字段列表。
            -- 1.1 查询全部
            SELECT * FROM stu;

            -- 1.2　查询指定列   --对列进行筛选
            SELECT sid,sname,age FROM stu;
                    2. 去除重复：
                        * distinct
                            -- 去掉重复的记录
                            select distinct address from student;
```



### 条件查询

```sql

				(1). where子句后跟条件
                (2). 运算符
                    * > 、< 、<= 、>= 、= 、<>
                    * BETWEEN...AND  
                    * IN( 集合) 
                    * LIKE：模糊查询
                        * 占位符：
                            * _:单个任意字符
                            * %：多个任意字符
                    * IS NULL  
                    * and  或 &&
                    * or  或 || 
                    * not  或 !
		
			-- 查询年龄大于20岁
				SELECT * FROM student WHERE age > 20;
				SELECT * FROM student WHERE age >= 20;
				
				-- 查询年龄等于20岁
				SELECT * FROM student WHERE age = 20;
				
				-- 查询年龄不等于20岁
				SELECT * FROM student WHERE age != 20;
				SELECT * FROM student WHERE age <> 20;
				
				-- 查询年龄大于等于20 小于等于30
				SELECT * FROM student WHERE age >= 20 &&  age <=30;
				SELECT * FROM student WHERE age >= 20 AND  age <=30;
				SELECT * FROM student WHERE age BETWEEN 20 AND 30;
				
				-- 查询年龄22岁，18岁，25岁的学生信息
				SELECT * FROM student WHERE age = 22 OR age = 18 OR age = 25
				SELECT * FROM student WHERE age IN (22,18,25);
				
				-- 查询英语成绩为null
				SELECT * FROM student WHERE english = NULL; -- 不对的。null值不能使用 = （!=） 判断		
				SELECT * FROM student WHERE english IS NULL;
				
				-- 查询英语成绩不为null
				SELECT * FROM student WHERE english IS NOT NULL;
```

### 模糊查询



```sql
MYSQL通配符
    %为匹配任意多个字符串
    _为匹配任意一个字符
like表示模糊查询
				-- 查询姓马的有哪些？ 
				SELECT * FROM student WHERE NAME LIKE '马%';
				-- 查询姓名第二个字是化的人
				
				SELECT * FROM student WHERE NAME LIKE "_化%";
				
				-- 查询姓名是3个字的人
				SELECT * FROM student WHERE NAME LIKE '___';
				
				
				-- 查询姓名中包含德的人
				SELECT * FROM student WHERE NAME LIKE '%德%';


```



### 排序查询

```sql
		* 语法：order by 子句
			* order by 排序字段1 排序方式1 ，  排序字段2 排序方式2...

		* 排序方式：
			* ASC：升序，默认的。
			* DESC：降序。

		* 注意：
			* 如果有多个排序条件，则当前边的条件值一样时，才会判断第二条件。


-- 查询所有学生记录，按年龄升序排序
        SELECT *
        FROM stu
        ORDER BY sage ASC;
        或者
        SELECT *
        FROM stu
        ORDER BY sage;

-- 查询所有学生记录，按年龄降序排序
        SELECT *
        FROM stu
        ORDER BY age DESC;

-- 查询所有雇员，按月薪降序排序，如果月薪相同时，按编号升序排序
        SELECT * FROM emp
        ORDER BY sal DESC,empno ASC;
```

### 分组查询

```SQL
1. 语法：group by 分组字段；
		2. 注意：
			1. 分组之后查询的字段：分组字段、聚合函数
			2. where 和 having 的区别？
				1. where 在分组之前进行限定，如果不满足条件，则不参与分组。
				    having在分组之后进行限定，如果不满足结果，则不会被查询出来
				
				2. where 后不可以跟聚合函数，having可以进行聚合函数的判断。

			-- 按照性别分组。分别查询男、女同学的平均分

			SELECT sex , AVG(math) FROM student GROUP BY sex;
			
			-- 按照性别分组。分别查询男、女同学的平均分,人数
			
			SELECT sex , AVG(math),COUNT(id) FROM student GROUP BY sex;
			
			--  按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组
			SELECT sex , AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex;
			
			--  按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组,分组之后。人数要大于2个人
			SELECT sex , AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex HAVING COUNT(id) > 2;
			
			SELECT sex , AVG(math),COUNT(id) 人数 FROM student WHERE math > 70 GROUP BY sex HAVING 人数 > 2;


*	查询每个部门的部门编号以及每个部门的人数：
SELECT deptno,COUNT(*)
FROM emp
GROUP BY deptno;-- 以deptno为主键输出出来

*	查询每个部门的部门编号和每个部门的工资和：
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno;
*	查询每个部门的部门编号以及每个部门工资大于1500的人数：
SELECT deptno,COUNT(*)
FROM emp
WHERE sal>1500
GROUP BY deptno;

```



### 聚合函数(纵向的计算)

*将一列数据作为一个整体，进行纵向的计算。*

```sql

		1. count：计算记录个数
			1. 一般选择非空的列：主键
			2. count(*)
		2. max：计算最大值
		3. min：计算最小值
		4. sum：计算和
		5. avg：计算平均值
		

		* 注意：聚合函数的计算，排除null值。
			解决方案：
				1. 选择不包含非空的列进行计算
				2. IFNULL函数

聚合函数是用来做纵向运算的函数：
*	COUNT()：统计指定列不为NULL的记录行数；
*	MAX()：计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算；
*	MIN()：计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；
*	SUM()：计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；
*	AVG()：计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；

    --  SUM和AVG
        当需要纵向求和时使用sum()函数。
        *	查询所有雇员月薪和：
        SELECT SUM(sal) FROM emp;

        *	查询所有雇员月薪和，以及所有雇员佣金和：
        SELECT SUM(sal), SUM(comm) FROM emp;

        *	查询所有雇员月薪+佣金和：
        SELECT SUM(sal+IFNULL(comm,0)) FROM emp;

        *	统计所有员工平均工资：
        SELECT AVG(sal) FROM emp;

    --  MAX和MIN
        *	查询最高工资和最低工资：
        SELECT MAX(sal), MIN(sal) FROM emp;

```



### COUNT(纵向统计)

```sql
当需要纵向统计时可以使用COUNT()。
*	查询emp表中记录数：
SELECT COUNT(*) AS cnt FROM emp;

*	查询emp表中有佣金的人数：
SELECT COUNT(comm) cnt FROM emp;
注意，因为count()函数中给出的是comm列，那么只统计comm列非NULL的行数。

*	查询emp表中月薪大于2500的人数：
SELECT COUNT(*) FROM emp
WHERE sal > 2500;

*	统计月薪与佣金之和大于2500元的人数：
SELECT COUNT(*) AS cnt FROM emp WHERE sal+IFNULL(comm,0) > 2500;

*	查询有佣金的人数，以及有领导的人数：
SELECT COUNT(comm), COUNT(mgr) FROM emp;

```



### 分组后过滤 Having子句

```sql

*	查询工资总和大于9000的部门编号以及工资和：
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
HAVING SUM(sal) > 9000;
　　
	注：having与where的区别:
		1.having是在分组后对数据进行过滤.
		  where是在分组前对数据进行过滤
		
		2.having后面可以使用分组函数(统计函数)
          where后面不可以使用分组函数。
          
        3.WHERE是对分组前记录的条件，如果某行记录没有满足WHERE子句的条件，那么这行记录不会参加分组；
       	  而HAVING是对分组后数据的约束。

```



### 分页查询limit（显示特定 数量的记录）

```SQL
		1. 语法：limit 开始的索引,每页查询的条数;
		2. 公式：开始的索引 = （当前的页码 - 1） * 每页显示的条数
			-- 每页显示3条记录 

			SELECT * FROM student LIMIT 0,3; -- 第1页
			
			SELECT * FROM student LIMIT 3,3; -- 第2页
			
			SELECT * FROM student LIMIT 6,3; -- 第3页

```



### 多表查询

| **表与表之间的三种关系          ** | 关系如何维护                             |
| ---------------------------------- | ---------------------------------------- |
| **一对多**                         | **通过主外键约束**                       |
| **多对多**                         | **通过中间表，中间表与两个表是多对一**   |
| **一对一**                         | **1.**  **特殊的一对多，多方加唯一约束** |

> - **一对一**：例如person表和card表，即人和身份证。这种情况需要找出主从关系，即谁是主表，谁是从表。人可以没有身份证，但身份证必须要有人才行，所以人是主表，而身份证是从表。设计从表可以有两种方案：
>   - 在card表中添加外键列（相对person表），并且给外键添加唯一约束；
>   - 给card表的主键添加外键约束（相对person表），即card表的主键也是外键。（主键连主键是一对一关系，因为表只有一个主键）
> - **一对多**（多对一）：最为常见的就是一对多！一对多和多对一，这是从哪个角度去看得出来的。dept和emp的关系，从dept来看就是一对多，而从emp的角度来看就是多对一！这种情况都是在多方创建外键！
> - **多对多**：例如stu和teacher表，即一个学生可以有多个老师，而一个老师也可以有多个学生。这种情况通常需要创建中间表来处理多对多关系。例如再创建一张表stu_tea表，给出两个外键，一个相对stu表的外键，另一个相对teacher表的外键。





#### 笛卡尔积现象

![image-20210725104503029](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210725104503029.png)



#### 如何清除笛卡尔积现象的影响

*我们发现不是所有的数据组合都是有用的，只有*员工表.dept_id = 部门表.id的数据才是有用的。所以需要通过条件过滤掉没用的数据*。

```SQL
-- 查询所有员工表.dept_id = 部门表.id的数据
select * from emp,dept where emp.'dept_id' = dept.'id';

-- 查询员工和部门的名字
select emp.'name', dept.'name' from emp,dept where emp.'dept_id' = dept.'id';

```



#### 多表查询分类

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210725104836277.png" alt="image-20210725104836277" style="zoom: 80%;" />

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210725210523523.png" alt="image-20210725210523523" style="zoom:150%;" />





##### 内连接

*用左边表的记录去匹配右边表的记录，如果符合条件的则显示。如：从表.外键=主表.主键*

​                              注：部门表（dept）是主表， 员工表（emp）是从表

​											~~（可不看）记忆：（数据少的是主表）~~

###### 1     隐式内连接

*看不到 JOIN 关键字，条件使用 WHERE 指定*

```SQL
SELECT 字段名  FROM 左表, 右表  WHERE 条件

eg:   select * from emp,dept where emp.`dept_id` = dept.`id`;
```

###### 2     显式内连接

*使用 INNER JOIN ... ON 语句, 可以省略 INNER*

```sql
SELECT 字段名 FROM 左表 [INNER] JOIN 右表 ON 条件
```



```sql
-- 确定查询字段，查询唐僧的信息，显示员工 id，姓名，性别，工资和所在的部门名称
eg:  select e.`id`,e.`name`,e.`gender`,e.`salary`,d.`name` from emp e inner join dept d on e.`dept_id` = d.`id` where e.`name`='唐僧';
```



> ​	总结内连接查询步骤：
>
> 1）确定查询的字段
>
> 2） 确定查询哪些表
>
> 3） 确定表连接的条件
>
> 4）确定查询的条件





##### 外连接



###### 1      左外连接

*使用 LEFT OUTER JOIN ... ON，OUTER 可以省略*

```sql
SELECT 字段名 FROM 左表 LEFT [OUTER] JOIN 右表 ON 条件
```

*用左边表的记录去匹配右边表的记录，如果符合条件的则显示；否则，显示 NULL*

*在内连接的基础上保证左表的数据全部显示(左表是部门，右表员工)*

```sql
-- 使用左外连接查询
select * from dept as d left join emp as e on d.`id` = e.`dept_id`;
```

![image-20210725190024902](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210725190024902.png)





###### 2     右外连接

*使用 RIGHT OUTER JOIN ... ON，OUTER 可以省略*

```sql
SELECT 字段名 FROM 左表 RIGHT [OUTER ]JOIN 右表 ON 条件
```

*用右边表的记录去匹配左边表的记录，如果符合条件的则显示；否则，显示 NULL*

*可以理解为：在内连接的基础上保证右表的数据全部显示*

```sql
-- 使用右外连接查询
select * from dept right join emp on dept.`id` = emp.`dept_id`;
```

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210725205747382.png" alt="image-20210725205747382" style="zoom:150%;" />



#### 子查询

*嵌套查询*

```sql
-- 使用子查询
select * from emp where dept_id = (select id from dept where name='市场部');

```

> 子查询的概念：
>
> 1) 一个查询的结果做为另一个查询的条件
>
> 2) 有查询的嵌套，内部的查询称为子查询
>
> 3) 子查询要使用括号



####    子查询小结

- **子查询结果只要是单列，则在 WHERE 后面作为条件**

- **子查询结果只要是多列，则在 FROM 后面作为表进行二次查询**



#### 子查询的结果分类



1.单行单列（一个值）

> *子查询结果只要是单行单列，肯定在 WHERE 后面作为条件，父查询使用：比较运算符，如：> 、<、<>、= 等*

```sql
SELECT 查询字段  FROM 表  WHERE 字段=（子查询）;
eg：	案例：查询工资最高的员工是谁？
-- 1) 查询最高工资是多少
select max(salary) from emp;
-- 2) 根据最高工资到员工表查询到对应的员工信息
select * from emp where salary = (select max(salary) from emp);
```



2.多行单列

> *子查询结果是单例多行，结果集类似于一个数组，父查询使用 IN 运算符*

```SQL
SELECT 查询字段  FROM 表  WHERE 字段  IN （子查询）;
eg:   案例：查询开发部与财务部所有的员工信息
-- 先查询开发部与财务部的 id
select id from dept where name in('开发部','财务部');
-- 再查询在这些部门 id 中有哪些员工
select * from emp where dept_id in (select id from dept where name in('开发部','财务部'));

```





3.多行多列

> *子查询结果只要是多列，肯定在 FROM 后面作为虚拟表*
>
> *而子查询作为表需要取别名，否则这张表没有名称则无法访问表中的字段*

```sql
SELECT 查询字段  FROM （子查询）  表别名  WHERE 条件；
eg：  案例：  查询出 2011 年以后入职的员工信息，包括部门名称
-- 在员工表中查询 2011-1-1 以后入职的员工
select * from emp where join_date >='2011-1-1';

-- 查询所有的部门信息，与上面的虚拟表中的信息组合，找出所有部门 id 等于的 dept_id
select * from dept as d, (select * from emp where join_date >='2011-1-1') as e where d.`id`= e.dept_id ;

```





#### 多表查询



##### 合并结果集

*合并结果集就是把两个select语句的查询结果合并到一起！*

> 注意：**被合并的两个结果：列数、列类型必须相同。**

分为：

###### UNION

```sql
去除重复记录，例如：SELECT * FROM t1 UNION SELECT * FROM t2；
```

###### UNION ALL

```sql
不去除重复记录，例如：SELECT * FROM t1 UNION ALL SELECT * FROM t2;
```



#### 连接查询（非常重要）



*连接查询就是求出多个表的乘积，例如t1连接t2，那么查询出的结果就是t1t2，产生的为笛卡尔积，假设集合A={a,b}，集合B={0,1,2}，则两个集合的笛卡尔积为{(a,0),(a,1),(a,2),(b,0),(b,1),(b,2)}。可以扩展到多个集合的情况。*

解决方法：**通过主外键关系来除去无用信息**



##### 内连接

```sql
SELECT e.需要的信息,d.需要的信息 FROM emp as e,dept as d WHERE e.deptno=d.deptno; -- 方言 使用  where
或者
SELECT e.需要的信息,d.需要的信息 FROM emp e INNER JOIN dept d ON e.deptno=d.deptno;  -- 标准形式 使用inner join...on..
这些都是内连接

```

> 内连接的特点：**查询结果必须满足条件**。



![image-20210727083102526](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727083102526.png)

![image-20210727083108881](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727083108881.png)



##### 外连接

> 外连接的特点：**查询出的结果存在不满足条件的可能**。



###### 左连接

*左连接是先查询出左表（即以左表为主），然后查询右表，右表中满足条件的显示出来，不满足条件的显示NULL。*

```sql
eg：emp表中“张三”这条记录中，部门编号为50，而dept表中不存在部门编号为50的记录，所以“张三”这条记录，不能满足e.deptno=d.deptno这条件。但在左连接中，因为emp表是左表，所以左表中的记录都会查询出来，即“张三”这条记录也会查出，但相应的右表部分显示NULL。

别名是在from后面那个为准
SELECT * FROM emp e LEFT OUTER JOIN dept d ON e.deptno=d.deptno;
```

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727084151040.png" alt="image-20210727084151040" style="zoom:150%;" />

###### 右连接

*与左连接相反，以右表为主。   右连接就是先把右表中所有记录都查询出来，然后左表满足条件的显示，不满足显示NULL。*

```sql
eg:在dept表中的40部门并不存在员工，但在右连接中，如果dept表为右表，那么还是会查出40部门，但相应的员工信息为NULL。

别名是在from后面那个为准
SELECT * FROM emp e RIGHT OUTER JOIN dept d ON e.deptno=d.deptno;
```

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727084436409.png" alt="image-20210727084436409" style="zoom:150%;" />

#### 连接查询注意事项：

> 两张表的连接查询一定有一个主外键关系，三张表的连接查询就一定有两个主外键关系，
>
> 所以在大家不是很熟悉连接查询时，首先要学会去除无用笛卡尔积，那么就是用主外键关系作为条件来处理。
>
> 如果两张表的查询，那么至少有一个主外键条件，三张表连接至少有两个主外键条件*。*



#### 自然连接

> 自然连接无需你去给出主外键等式，它会自动找到这一等式：
>
> - ​							两张连接的表中名称和类型完全一致的列作为条件，例如emp和dept表都存在deptno列，并且类型一致，所以会被自然连接找到！
>
> 当然自然连接还有其他的查找条件的方式，但其他方式都可能存在问题！

```sql
SELECT * FROM emp NATURAL JOIN dept;
SELECT * FROM emp NATURAL LEFT JOIN dept;
SELECT * FROM emp NATURAL RIGHT JOIN dept;
```





#### 子查询

- 子查询出现的位置：
  - where后，作为被查询的条件的一部分；
  -  from后，作虚拟表用；

- 当子查询出现在where后作为条件时，还可以使用如下关键字：
  -  any
  -  all

- 子查询结果集的形式：
  -  单行单列（用于条件）
  -  单行多列（用于条件）
  -  多行单列（用于条件）
  -  多行多列（用于表）



#### 自连接

*自己连接自己，起别名*

```sql
eg：求7369员工编号、姓名、经理编号和经理姓名
	SELECT e1.empno , e1.ename,e1.mgr,e2.ename FROM emp e1, emp e2 WHERE e1.mgr = e2.empno AND e1.empno = 7369;

```



#### 三表联查（重要）

```sql
三表联查 ----------------------------------------------------------------
-- 查询学生的学号，课程号，成绩，
SELECT studentno ,courseno,score FROM scores;

-- 查询学生的学号，学生姓名，课程号，成绩
SELECT scores.studentno ,studentname,courseno,score FROM scores,studentinfo WHERE scores.studentno=studentinfo.studentno;

-- 查询学生的学号，课程号，课程名称，成绩
SELECT studentno ,scores.courseno,coursename,score FROM scores,course WHERE scores.courseno=course.courseno;

-- 查询学生的学号，学生姓名，课程号，课程名称，成绩
SELECT scores.studentno ,studentname,scores.courseno,coursename,score FROM scores,studentinfo,course WHERE scores.studentno=studentinfo.studentno AND scores.courseno=course.courseno;

```



#### 两表联查中的不等连接（求xx等级时适用）

```sql
-- 两表联查中的不等连接
-- 查询学生的学号，课程号，成绩，成绩等级

SELECT studentno,courseno,score,grade FROM scores,scoregrade WHERE score BETWEEN loscore AND hiscore;
```





# 添加

> ​										
>
> ```sql
> * 添加数据
>  注意：
> 			1. 列名和值要一一对应。
> 			2. 如果表名后，不定义列名，则默认给所有列添加值
> 				insert into 表名 values(值1,值2,...值n);
> 
> * 插入全部字段
> 		所有的字段名都写出来
>  			* INSERT INTO 表名 (字段名 1, 字段名 2, 字段名 3…) VALUES (值 1, 值 2, 值 3);	
> 
> * 不写字段名 
>  			* INSERT INTO 表名 VALUES (值 1, 值 2, 值 3…);	
> 				值的个数，顺序类型必须和字段定义一致 
> 				
> * 插入部分数据  (有三列但是只插入两列的数据)
> 			*  INSERT INTO 表名 (字段名 1, 字段名 2, ...) VALUES (值 1, 值 2, ...);
> 				注：没有添加数据的字段会使用 NULL
> 
> ```
>
> ![image-20210723194826807](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210723194826807.png)







# 计算并显示

```sql
* 计算列

* 一般可以使用四则运算计算一些列的值。（一般只会进行数值型的计算）
			* ifnull(表达式1,表达式2)：null参与的运算，计算结果都为null
				* 表达式1：哪个字段需要判断是否为null
				* 如果该字段为null后的替换值。

eg：--  查询员工的姓名，工资，奖金，工资与奖金之和
SELECT ename,sal,comm,sal+comm FROM emp; -- 有异常 因为comm中有一些null无法参与运算

-- 使用IFNULL函数解决问题
-- 查询佣金，如果佣金为null则返回0
SELECT ename,sal,comm,sal+IFNULL(comm,0) FROM emp;



```



# 别名

```
* 起别名：
			* as：as也可以省略
-- 使用别名
select name as 姓名,age as 年龄 from student;
-- 表使用别名
select st.name ,age from student as st；

```



# 约束

| **约束名                              ** | 关键字                  | 说明                                 |
| ---------------------------------------- | ----------------------- | ------------------------------------ |
| **主键**                                 | primary key             | **1)**   **唯一**  **2)**   **非空** |
| **默认**                                 | default                 | **如果一列没有值，使用默认值**       |
| **非空**                                 | not null                | **这一列必须有值**                   |
| **唯一**                                 | unique                  | **这一列不能有重复值**               |
| **外键**                                 | foreign key             | **主表中主键列，在从表中外键列**     |
| **检查约束**                             | check 注：mysql  不支持 |                                      |



## 作用

对表中的数据进行限制，保证数据的正确性、有效性和完整性。一个表如果添加了约束，不正确的数据将无法插入到表中。**约束在创建表的时候添加比较合适**



*连关系线：由外键连向主键*



## 主键

*用来唯一标识数据库中的每一条记录（字段）*

*主键有没有含义没有关系，只要**不重复，唯一非空**就行*

> 如：身份证，学号不建议做成主键

> **特点：**
>
> 1. **非空 not null**
> 2. **唯一**



## 创建主键（primary key）

-  **在创建表的时候给字段添加主键**

```SQL
字段名 字段类型 PRIMARY KEY                                                       
```

- ​     **在已有表中添加主键**

```sql
ALTER TABLE 表名 ADD PRIMARY KEY(字段名);
```

举例：

```SQL
-- 创建表学生表 st5, 包含字段(id, name, age)将 id 做为主键
create table st5 (
	id int primary key,	-- id 为主键
	name varchar(20), 
    age int
)

desc st5;-- 查看表结构

```







## 主键自增（AUTO_INCREMENT） 流水号

主键如果让我们自己添加很有可能重复,我们通常希望在每次插入新记录时,数据库自动生成主键字段的值

***自动增长(字段类型必须是整数类型)***

- **创建表时设置**

```sql
CREATE TABLE st4(
	id INT PRIMARY KEY AUTO_INCREMENT,  -- 主键自增
	sname VARCHAR(20),
	age INT
);

SELECT * FROM st4;
INSERT INTO st4 VALUES(1,'aaa',18);
INSERT INTO st4 VALUES(NULL,'bbb',19);-- 插入后自动在id位置补2
INSERT INTO st4 (sname,age) VALUES('bbb',19);
```

- **创建表后设置**

```sql
ALTER TABLE st4 MODIFY id INT AUTO_INCREMENT;
```



### 修改自增的默认起始值

*默认地 AUTO_INCREMENT 的开始值是 1，如果希望修改起始值,请使用下列 SQL 语法*

- **建表时修改起始值**

```sql
CREATE TABLE 表名(
		列 名 int primary key AUTO_INCREMENT
) AUTO_INCREMENT=起始值;

```

- **建表后再改起始值  但是只对新增加的数据才有作用，之前的数据id依旧不变**



### DELETE 和 TRUNCATE 对自增长的影响



- **DELETE**：删除所有的记录之后，自增长没有影响,起始值接着往下走不会还原。

- **TRUNCATE**：删除以后，自增长又重新开始(从1开始)。







## 删除主键

- **删除 st5 表的主键**

```SQL
alter table st5 drop primary key;
```

- **添加主键**

```sql
alter table st5 add primary key(id);
```



## 约束①------------唯一约束

*表中某一列不能出现重复的值*

> 特点：
>
> -- 1.**不能同名**
> -- 2.**可以为空且可以多个为空**

- **建表时设置**

```sql
-- 创建学生表 st7, 包含字段(id, name),name 这一列设置唯一约束,不能出现同名的学Th create table st7 (
		id int,
		sname varchar(20) unique
)

```

- **建表后设置**

```sql
ALTER TABLE st7 MODIFY sname VARCHAR(20) UNIQUE;
```





## 约束②------------非空约束

*某一列不能为 null。*

- **建表时设置**

  ```SQL
  CREATE TABLE st8(
  	id INT,
  	sname VARCHAR(20) NOT NULL
  );
  ```

- **建表后设置**

```SQL
ALTER TABLE st8 MODIFY sname VARCHAR(20) NOT NULL;
```



## 疑问

如果一个字段设置了非空与唯一约束，该字段与主键的区别?

1. 主键数在一个表中，**只能有一个**。不能出现多个主键。**主键可以单列，也可以是多列**。 
2. **自增长只能用在主键上**



## 约束③-----------默认值

- **建表时设置**

  ```SQL
  CREATE TABLE st9(
  	id INT,
  	sname VARCHAR(20),
  	address VARCHAR(30) DEFAULT '广州'
  )
  ```

- **建表后设置**

```sql
ALTER TABLE st9 MODIFY address VARCHAR(30) DEFAULT '广州';
```



## 约束④-----------外键约束（foreign key）

### 使用原因：

![image-20210725100403536](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210725100403536.png)

注意：之所以使用是想从表不能添加除主表以外的id值

### 设置

- **建表时设置**

  > CONSTRAINT] [外键约束名称] FOREIGN KEY(外键字段名) REFERENCES 主表名(主键字段名)

  ```SQL
  -- 主表
  CREATE TABLE department(
  	id INT PRIMARY KEY AUTO_INCREMENT,
  	dep_name VARCHAR(20),
  	dep_location VARCHAR(20)
  );
  
  -- 外键表
  CREATE TABLE employee(
  	empno INT PRIMARY KEY AUTO_INCREMENT,
  	ename VARCHAR(30),
  	deptno INT,
  	CONSTRAINT fk_deptno FOREIGN KEY(deptno) REFERENCES department(id) -- 外键约束foreign key
  );
  ```

- **建表后设置**

> ALTER TABLE 从表 ADD [CONSTRAINT] [外键约束名称] FOREIGN KEY (外键字段名) REFERENCES主表(主键字段名);

```sql
-- 假设主表已经建好
-- 外建表↓
CREATE TABLE employee(
	empno INT PRIMARY KEY AUTO_INCREMENT,
	ename VARCHAR(30),
	deptno INT
	
);
ALTER TABLE employee ADD CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES department(id);
```

### 删除外键

1. 直接删除

   ```sql
   ALTER TABLE employee DROP FOREIGN KEY fk_deptno；
   ```

2. 级联删除

```sql
ALTER TABLE employee ADD CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES department(id) ON UPDATE CASCADE ON DELETE CASCADE;-- 添加级联
DELETE FROM department WHERE id=10 ; -- 主键和从键一起删除
```



## 级联操作  

*在修改和删除主表的主键时，同时更新或删除副表的外键值*

```sql
ALTER TABLE employee ADD CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES department(id) ON UPDATE CASCADE ON DELETE CASCADE;-- 添加级联

UPDATE department SET id=10 WHERE id=1;  -- 主键id改为10 从键一起更新

DELETE FROM department WHERE id=10 ; -- 主键和从键一起删除

```



## 复合主键（联合主键）

有些场合当个主键无法唯一决定一个数据，需要多个主键才行

```SQL
CREATE TABLE st10(
	sid INT,
	cid INT ,
	score INT,
	PRIMARY KEY(sid,cid)  --sid、cid一起当主键
);
```





# 事务

*事务执行是一个整体，所有的 SQL 语句都必须执行成功。如果其中有 1 条 SQL 语句出现异常，则所有的SQL 语句都要回滚，整个业务执行失败。*

| **功能**     | **SQL** **语句**       |
| ------------ | ---------------------- |
| **开启事务** | **start transaction;** |
| **提交事务** | **commit;**            |
| **回滚事务** | **rollback;**          |

```
begin transaction   --    (开启事务)
			UPDATE account SET balance=balance-500 WHERE pname='张三';
rollback   		-- 	(回滚事务)
			UPDATE account SET balance=balance+500 WHERE pname='李四';
commmit  		-- 		  (提交事务)
```



## 自动提交事务

> 1为自动提交
>
>  0为手动提交

```sql
cmd查看当前是什么提交：
			SELECT @@autocommit;
将默认设置为手动提交，相当于不用打 begin transaction了
			SET @@autocommit=0; 

```



## 回滚点

*在某些成功的操作完成之后，后续的操作有可能成功有可能失败，但是不管成功还是失败，前面操作都已经成功，可以在当前成功的位置设置一个回滚点。可以供**后续失败操作返回到该位置**，而不是撤销所有操作，这个点称之为回滚点。*

| **设置回滚点** | savepoint  名字      |
| -------------- | -------------------- |
| **回到回滚点** | **rollback to 名字** |

```sql
start transaction; -- (开启事务)
update account set balance=balance-10 where pname='张三';
update account set balance=balance-10 where pname='张三';
update account set balance=balance-10 where pname='张三';
savepoint three_times;   --  设置回滚点
update account set balance=balance-10 where pname='张三';
update account set balance=balance-10 where pname='张三';
update account set balance=balance-10 where pname='张三';
update account set balance=balance-10 where pname='张三';
rollback to three_times;   -- 回到回滚点 中间语句撤销执行
```



## 事务的四大特性 ACID

 

| **事务特性               含义** |                                                              |
| ------------------------------- | ------------------------------------------------------------ |
| **原子性**（Atomicity）         | **每个事务都是一个整体，不可再拆分，事务中所有的**  **SQL** **语句要么都执行成功，**  **要么都失败。** |
| **一致性**（Consistency）       | **事务在执行前数据库的状态与执行后数据库的状态保持一致。如：转账前2个人的总金额是** **2000，转账后** **2** **个人总金额也是**  **2000** |
| **隔离性**（Isolation）         | **事务与事务之间不应该相互影响，执行时保持隔离的状态。**     |
| **持久性**（Durability）        | **一旦事务执行成功，对数据库的修改是持久的。就算关机，也是保存下来的。** |



## 事务的隔离级别

*所有的事务之间保持隔离，互不影响。因为并发操作，多个用户同时访问同一个数据。可能引发并发访问的问题*

| 并发访问的问题 | 含义                                                         |
| -------------- | ------------------------------------------------------------ |
| **脏读**       | **一个事务读取到了另一个事务中尚未提交的数据**     （ ab窗口都开启事务，a修改了数据但是没有提交，b查看数据表的时候发现数据表已经是a改动了的，然后a回滚了，b的数据又还原回去了。） |
| **不可重复读** | **一个事务中两次读取的数据内容不一致，要求的是一个事务中多次读取时数据是一致的，这**  **是事务** **update** **时引发的问题**    （b先开启事务查看了一下数据表，接着a开启了事务对数据表做出了改动，b再次查看数据表发现不一样了。） |
| **幻读**       | **一个事务中两次读取的数据的数量不一致，要求在一个事务多次读取的数据的数量是一致**  **的，这是** **insert** **或** **delete** **时引发的问题**     （a窗口先开启业务，b再开启，a先对表做出了改动但是没有提交，这个时候b也做了改动，但一直卡住。a提交后，b才开始运行。b提交后，做出的改变a才看到。） |

| **级别  ** | 名字     | 隔离级别          | 脏读   | 不可重复读 | 幻读   | 数据库默认隔离级别                                           |
| ---------- | -------- | ----------------- | ------ | ---------- | ------ | ------------------------------------------------------------ |
| **1**      | 读未提交 | read  uncommitted | **是** | **是**     | **是** |                                                              |
| **2**      | 读已提交 | read  committed   | 否     | **是**     | **是** | **Oracle** **和** **SQL Server**                             |
| **3**      | 可重复读 | repeatable  read  | 否     | 否         | **是** | ![image-20210727201206576](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727201206576.png) |
| **4**      | 串行化   | serializable      | 否     | 否         | 否     |                                                              |

*<u>隔离级别越高，性能越差，安全性越高。</u>*



## 相关命令

- 查询全局事务隔离级别

```sql
查询隔离级别      select @@tx_isolation;
```

- 设置事务隔离级别，需要退出 MySQL 再重新登录才能看到隔离级别的变化	

```sql
设置隔离级别	    set global transaction isolation level 级别名字;
```







# 常用函数

## 字符串函数

```sql
-- 字段拼接 concat
SELECT CONCAT (empno,ename)FROM emp;
SELECT CONCAT('my','sql','2021'); -- mysql2021

-- 字段长度 length
SELECT * FROM emp WHERE LENGTH(ename)=5; 
SELECT LENGTH ('mysql');  -- 5

-- 字符串比较
SELECT STRCMP('aaa','aab');-- 字符串比较ascall码 strcmp  第一大于第二返回1 小于返回-1；
SELECT STRCMP('aaa','aaa');-- 相等返回0 
```



## 日期函数

```sql
SELECT CURRENT_DATE();  -- 查看当前日期
SELECT CURRENT_TIME();  -- 查看当前时间
SELECT NOW();   -- 查看当前日期＋时间
SELECT YEAR(NOW()); -- 查看当前年份
SELECT MONTH(NOW()); -- 查看当前月份
SELECT DAY(NOW()); -- 查看当前日期
SELECT HOUR(NOW()); -- 查看小时
SELECT MINUTE(NOW()); -- 查看分钟
SELECT SECOND(NOW()); -- 查看秒
SELECT DAYNAME(NOW()); -- 查看星期几
SELECT DAYNAME('2021-4-10');
SELECT DAYOFWEEK(NOW()); -- 查看今天是一周中的第几天，星期天为1
SELECT DAYOFYEAR(NOW()); -- 查看今天是一年中的第几天
SELECT LAST_DAY(NOW()); -- 查看此月的最后一天的日期

-- 查询学生的名字，出生日期
SELECT studentname,birthday FROM studentinfo;

-- 查询学生的名字 出生日期，年龄
SELECT studentname,birthday,YEAR(NOW())-YEAR(birthday) 年龄 FROM studentinfo;

SELECT DATEDIFF('2020-12-31','2020-12-30 23:59:58'); -- 查看相差的天数 (只算日期，不算时分秒)
SELECT DATEDIFF('2020-12-31 23:59:58','2020-12-30' ); 

SELECT DATE_ADD('2020-12-31 23:59:59',INTERVAL 1 SECOND);  -- 某个时间增加1秒后的时间
SELECT DATE_ADD('2020-12-31 23:59:59',INTERVAL 1 MINUTE);  -- 某个时间增加1分后的时间
SELECT DATE_ADD('2020-12-31 23:59:59',INTERVAL 1 HOUR);  -- 某个时间增加1小时后的时间
SELECT DATE_ADD('2020-12-31 23:59:59',INTERVAL 10 DAY);  -- 某个时间增加10天后的时间
SELECT DATE_ADD('2020-1-31 23:59:59',INTERVAL 1 MONTH);  -- 某个时间增加1个月后的时间（默认加到下个月末尾）

SELECT DATE_ADD('2020-12-31 23:59:59',INTERVAL -1 SECOND);  -- 某个时间减少1秒后的时间

```







# 权限

## 创建用户

```sql
 CREATE USER  '用户名'@'主机名' IDENTIFIED BY '密码';
```

| 关键字 | 说明                                                         |
| ------ | ------------------------------------------------------------ |
| 用户名 | 将创建的用户名                                               |
| 主机名 | 指定该用户在哪个主机上可以登陆，如果是本地用户可用 localhost；如果想让该用户可以  从任意远程主机登陆，可以使用通配符  % |
| 密码   | 该用户的登陆密码，密码可以为空，如果为空则该用户可以不需要密码登陆服务器 |

```sql
eg：
CREATE USER 'user1'@'localhost' IDENTIFIED BY '123';  -- 本机登录
CREATE USER 'user2'@'%' IDENTIFIED BY '123';  -- 远程登录
```



## 分配权限

```sql
 GRANT 权限 1, 权限 2... ON 数据库名.表名 TO '用户名'@'主机名';
```

| 关键字            | 说明                                                         |
| ----------------- | ------------------------------------------------------------ |
| GRANT…ON…TO       | 授权关键字                                                   |
| 权限              | 授予用户的权限，如 CREATE、ALTER、SELECT、INSERT、UPDATE 等。如果要授  予所有的权限则使用 ALL |
| 数据库名.表名     | 该用户可以操作哪个数据库的哪些表。如果要授予该用户对所有数据库和表的相应操作  权限则可用*表示，如*.* |
| ‘用户名'@'主机名’ | 给哪个用户授权，注：有 2 对单引号                            |

```sql
eg：
GRANT CREATE ,ALTER,INSERT ,UPDATE ,SELECT  ON mydb1.emp TO 'user1'@'localhost'; -- 没有赋予删除权限
GRANT ALL ON mydb1.emp TO 'user1'@'localhost';-- 赋予所有
```



## 撤销权限

```sql
REVOKE	权限 1, 权限 2... ON 数据库.表名 from  '用户名'@ '主机' ;
revoke  all on test.* from 'user1'@'localhost';
```

| 关键字            | 说明                                                         |
| ----------------- | ------------------------------------------------------------ |
| REVOKE…ON…FROM    | 撤销授权的关键字                                             |
| 权限              | 用户的权限，如  CREATE、ALTER、SELECT、INSERT、UPDATE  等，所有的权  限则使用 ALL |
| 数据库名.表名     | 对哪些数据库的哪些表，如果要取消该用户对所有数据库和表的操作权限则可用*表  示，如*.* |
| '用户名'@'主机名' | 给哪个用户撤销                                               |

```sql
eg:
REVOKE DELETE ON mydb1.emp FROM 'user1'@'localhost';
-- REVOKE all ON test.* from 'user'@'localhost'; -- 撤销所有权限
```



## 查看权限

```sql
 SHOW GRANTS FOR '用户名'@'主机名';
 eg:
	 SHOW GRANTS FOR 'user1'@'localhost'; -- 查看用户权限
```



## 删除用户

```sql
DROP USER '用户名'@'主机名';
eg:
	DROP USER 'user1'@'localhost'; -- 删除用户

```



## 修改密码

### 修改管理员密码

 *注意：需要在未登陆 MySQL 的情况下操作，新密码不需要加上引号。*

```sql
 mysqladmin -uroot -p password 新密码
```

### 修改普通用户密码

*² 注意：需要在登陆 MySQL 的情况下操作，新密码要加单引号。*

```sql
set password for '用户名'@'主机名' = password('新密码');
```





# 视图

## 创建视图

```sql
create view 视图名 as 主干语句 ;
```

## 删除视图

```sql
DROP VIEW v_general;  -- 删除视图
```



## 用于权限管理

```sql
-- (1)只适用于普通员工的视图

CREATE VIEW v_general
AS 
SELECT empno,ename,job,mgr,deptno FROM emp;

-- (2)只适用于hr的视图
CREATE VIEW v_hr
AS 
SELECT empno,ename,job,mgr,hiredate,sal,deptno FROM emp;

-- (3)只适用于mgr的视图
CREATE VIEW v_mgr
AS 
SELECT empno,ename,job,mgr,hiredate,comm,deptno FROM emp;

 -- 创建用户
CREATE USER 'user_gen'@'%' IDENTIFIED BY '123'; 
CREATE USER 'user_hr'@'%' IDENTIFIED BY '123';
CREATE USER 'user_mgr'@'%' IDENTIFIED BY '123';

-- 赋予权限
GRANT SELECT ON mydb1.v_general TO 'user_gen'@'%'; 
GRANT SELECT ON mydb1.v_hr TO 'user_hr'@'%';
GRANT SELECT ON mydb1.v_mgr TO 'user_mgr'@'%';

```





# 存储过程

*多个sql语句可以打包成一个存储过程，类似java的方法，可以带参数。调用存储过程，就相当于执行存储过程里面*

## 不带参数

```sql
DELIMITER $$   -- 开始 （改变默认分号结束）
CREATE PROCEDURE sp_empl() -- 存储过程procedure
BEGIN
	SELECT emp.*,dname FROM emp,dept WHERE emp.deptno=dept.deptno;
	SELECT * FROM dept;
END
$$ -- 结束

DELIMITER; -- 重新恢复为;号结束
--  DELIMITER就是告诉mysql解释器

-- 调用存储过程
CALL sp_empl();
```



## 带参数

```
-- 输入参数----------
-- 带一个输入参数的存储过程
-- 查询指定部门的员工信息
DELIMITER $$
CREATE PROCEDURE  sp_emp2(IN dno INT) -- 输入参数
BEGIN
	SELECT * FROM emp WHERE deptno=dno;
END
$$
DELIMITER;

-- 查询10部门的员工信息
CALL sp_emp2(10);
CALL sp_emp2(20);


-- 输出参数----------
DELIMITER $$
CREATE PROCEDURE  sp_emp3(OUT nums INT) -- 输入参数
BEGIN
	SELECT COUNT(*) INTO nums FROM emp ; -- into为赋值
END
$$

DELIMITER ; -- 还原回;号结束

-- 查询10部门的员工信息
SET @nums=0;
CALL sp_emp3(@nums);
SELECT @nums;

```



## 多个参数

*注意：如果参数是字符串需要 eg: IN str varchar(50)*

```sql
DELIMITER $$
CREATE PROCEDURE sp_emp4(IN dno INT,OUT nums INT,OUT avgsal DOUBLE)
BEGIN
	SELECT COUNT(*),AVG(sal) INTO nums,avgsal FROM emp WHERE deptno=dno;
END
$$

DELIMITER ;

-- 查询10号部门的员工人数，平均工资。
SET @nums=0;
SET @avgsal=0.0;               -- 先赋值
CALL sp_emp4(10,@nums,@avgsal);   -- 再填入
SELECT @nums,@avgsal;           -- 最后输出
```





> 系统的全局变量需要两个@
> 自己定义变量只需要一个@





# 范式

## 第一范式

*字段里面还能再分的就不符合*

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727205758370.png" alt="image-20210727205758370" style="zoom:80%;" />

## 第二范式

*一个表只能描述一件事*

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727210028756.png" alt="image-20210727210028756" style="zoom:80%;" />

## 第三范式

*字段不能依赖于非主键字段*

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210727210252303.png" alt="image-20210727210252303" style="zoom:80%;" />









# 补充



```sql
得到最后一句SELECT查询到的总行数：
	FOUND_ROWS
```

