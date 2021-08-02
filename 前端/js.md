# JSON

*js是可以嵌入到html中，是 基于对象 和 事件驱动 的 脚本语言*

*(1)js能动态的修改(增删)html和css的代码      (2)能动态的校验数据*



> 特点：
> 			(1)交互性
> 			(2)安全性：js不能访问本地磁盘
> 			(3)跨平台：浏览器中都具备js解析器



组成：

- ECMAScript	
- BOM(浏览器对象模型)  
- DOM(文档对象模型)



## js被引入的方式

### (1)内嵌脚本

```javascript
<input type="button" value="button" onclick="alert('xxx')" />		 点击就会弹消息	
```

### (2)内部脚本

```javascript
<script type="text/javascript">               打开网页自动弹
		alert("xxx");
</script>
```

### (3)外部脚本

​			首先先创建一个js文件
​			其次在html中引入

```javascript
<script type="text/javascript" src="demo1.js"></script>    打开网页自动弹
```



## js代码放在哪？

​			放在哪都行 但是在不影响html功能的前提下 越晚加载越好

# js基本语法

# 2、JavaScript基本语法

## 注释

•      单行注释

   // 注释的内容

•      多行注释

   /*
 注释的内容
 */

## 输入输出语句

•      输入框 `prompt(“提示内容”);`

•      弹出警告框 `alert(“提示内容”);` 

•      控制台输出 `console.log(“显示内容”);` 

•      页面内容输出 `document.write(“显示内容”);`

## 变量和常量

 JavaScript 属于弱类型的语言，定义变量时不区分具体的数据类型。

### • 定义局部变量 let 变量名 = 值; 

  

```html
 //1.定义局部变量
 let name = "张三";
 let age = 23;
 document.write(name + "," + age +"<br>");
```



### • 定义全局变量 变量名 = 值; 

   

```html
//2.定义全局变量
 {
   let l1 = "aa";
   l2 = "bb";
 }
 //document.write(l1);
 document.write(l2 + "<br>");
```



### • 定义常量 const 常量名 = 值;

   

```html
//3.定义常量
 const PI = 3.1415926;
 //PI = 3.15;
 document.write(PI);
```



## 变量

```javascript
(1)
		var x = 5;
		x = 'javascript';
		var y = "hello";
		var b = true;
(2)
		x = 5;
```

## typeof

**typeof** **用于判断变量的数据类型**

```html
let age = 18; 
document.write(typeof(age)); // number
```



## 原始数据类型



> (1)number:数字类型
> 		(2)string：字符串类型
> 		(3)boolean:布尔类型
> 		(4)null:空类型(object类型的一种)
> 		(5)undefined:未定义
> 		相关概念 NaN:非数字,  Not a Number
> 		
>
> ​	注意：number、boolean、string是伪对象



### 数据类型转换

> - number\boolean转成string
>   				
>
>   ```javascript
>   toString();
>   ```
>
>   
>
> - string\boolean转成number
>   			
>
>   ```javascript
>   parseInt()
>   parseFloat()
>   ```
>
>   ​			**boolean不能转**
>   ​			string可以将数字字符串转换成number      注意:“123a3sd5” 转成123
>
> - 强制转换
>
>   - ​			Boolean() 	强转成布尔
>
>     ​				数字强转成布尔  ：
>
>     ​								非零就是true   零就是false
>     ​				字符串强转成布尔  ：
>
>     ​								非“”(空字符串)就是true   空字符串“”就是false
>
>   - ​			Number()	强转成数字
>     ​				布尔转数字 true转成1  false转成0
>     ​				**含非数字的字符串转数字 不能强转**



## 引用数据类型

> java:  	Object obj = new Object();
>
> js:	   	 var obj = new Object();
> 				var num = new Number();	



## 运算符

void 常用语 HTML 脚本中执行 [JavaScript](http://c.biancheng.net/js/) 表达式，但不需要返回表达式的计算结果。

> (1)赋值运算符
> 			var x = 5;
> 			x=6;
> (2)算术运算符
>
>  `+ - * / %`
> 	+: 遇到**字符串变成连接**
> 	-：先把字符串转成数字然后进行运算
> 	*: 先把字符串转成数字然后进行运算
> 	/: 先把字符串转成数字然后进行运算(有小数点)
>
> (3)逻辑运算符
> 		&&	||
> (4)比较运算符
> 	<	>	>=	<=	!=	==
> 	===:全等：**类型与值**都要相等  "10"===10  false
> 	==只判断值相等  "10"==10  true  注：true==1  true（原因：true在和number比较时会先变成1）
> (5)三元运算符
> 		3<2?"大于":"小于"
> (6)void运算符
> `<a href="javascript:void(0);">xxxxxx</a>`
> (7)类型运算符
> 		typeof:判断数据类型 **返回变量的数据类型**
> 		instanceof：判断数据类型 **判断是否是某种类型**
>
> ​		var obj = new Object();
> ​		alert(typeof obj);//object
> ​		alert(obj instanceof Object);//true



## 逻辑语句

- **if-else**

```javascript
			//数字非0 字符串非空====true
				if(9){
					alert("true--");
				}else{
					alert("false--");
				}
```



- switch

  ```javascript
  var x = "java";
  switch(x){
  	case "css":
  			   alert("css");
  			   break;
  	case "js":
  				alert("js");
  				break;
  	case "java":
  				alert("java");
  				break;
  	default:
  				alert("def");
  	}
  ```

  ​		

- for

  ```javascript
   for(var i = 0;i<5;i++){
  			alert(i);
  		 }
  ```

- for in
  		

  ```javascript
  var arr = [1,3,5,7,"js"];
  		 for(index in arr){//index代表角标
  			//alert(index);
  			alert(arr[index]);
  		 }	
  ```

  

## 输出基础语句

```javascript
alert(...)在打开网页时弹出
document.writer()在网页上打印出
```



# js内建对象



1. **Number**                     

   ```javascript
   创建方式：
   			var myNum=new Number(value);
   			var myNum=Number(value);
   ```

   > 属性和方法：
   > 			toString():转成字符串
   > 			valueOf()：返回一个 Number 对象的基本数字值

   

2. **Boolean**

   ```javascript
   创建方式：
   			var bool = new Boolean(value);	
   			var bool = Boolean(value);
   ```

   > 属性和方法：
   > 			toString():转成字符串
   > 			valueOf()：返回一个 Boolean 对象的基本值(boolean)	

   

3. **String**

   ```javascript
   创建方式：
   			var str = new String(s);
   			var str = String(s);
   ```

   > 属性和方法：
   > 			length:字符串的长度
   > 			charAt():返回索引字符
   > 			charCodeAt:返回索引字符unicode
   > 			indexOf():返回字符的索引
   > 			lastIndexOf();逆向返回字符的索引
   > 			split();将字符串按照特殊字符切割成数组
   > 			substr():从起始索引号提取字符串中指定数目的字符
   > 			substring():提取字符串中两个指定的索引号之间的字符
   > 			toUpperCase();转大写
   > 			toLowerCase();转大写

   

4. **Array**

   ```javascript
   创建方式：
   			var arr = new Array();//空数组
   			var arr = new Array(size);//创建一个指定长度的数组
   			var arr = new Array(element0, element1, ..., elementn);//创建数组直接实例化元素
   			var arr = [];//空数组
   			var arr = [1,2,5,"java"];//创建数组直接实例化元素
   ```

   > 属性和方法：
   > 			length:数组长度
   > 			join()：把数组的所有元素放入一个字符串。元素通过指定的分隔符进行分隔
   > 			pop():删除并返回最后元素
   > 			push()：向数组的末尾添加一个或更多元素，并返回新的长度
   > 			reverse();反转数组
   > 			sort();排序

   

5. **Date**

   ```javascript
   创建方式：	
   			var myDate = new Date();
   			var myDate = new Date(毫秒值);//代表从1970-1-1到现在的一个毫秒值
   ```

   > 属性和方法
   > 			getFullYear():年
   > 			getMonth():月 0-11
   > 			getDate():日 1-31
   > 			getDay()：星期 0-6
   > 			getTime():返回1970年1月1日午夜到指定日期（字符串）的毫秒数
   > 			toLocaleString();获得本地时间格式的字符串

   

6. **Math**

   ```javascript
   创建方式：	
   	Math 对象并不像 Date 和 String 那样是对象的类，因此没有构造函数 Math()，像 Math.sin() 这样的函数只是函数，
   	不是某个对象的方法。您无需创建它，通过把 Math 作为对象使用就可以调用其所有属性和方法。
   ```

   > 属性和方法
   > 		PI：圆周率
   > 		abs():绝对值
   > 		ceil():对数进行上舍入
   > 		floor():对数进行下舍入
   > 		round():四舍五入
   > 		pow(x,y)：返回 x 的 y 次幂（x^y）
   > 		random():0-1之间的随机数

   

7. **RegExp**

   ```javascript
   创建方式：	
   		var reg = new RegExp(pattern);
   		var reg = /^正则规则$/;   
   
   ```

   > ​	规则的写法：
   > ​		[0-9] 
   > ​		[A-Z]
   > ​		[a-z]
   > ​		[A-z]
   > ​		\d 代表数字
   > ​		\D	非数字
   > ​		\w	查找单词字符(数字,大小写字母,下划线)
   > ​		\W	查找非单词字符
   > ​		\s	查找空白字符
   > ​		\S	查找非空白字符
   > ​		n+	出现至少一次
   > ​		n*	出现0次或多次
   > ​		n?	出现0次或1次
   > ​		n{5} 出现5
   > ​		n{2,8} 2到8次
   > ​                    .      匹配任意一个字符

   > ​	方法：	
   > ​		reg.test(str):**检索**字符串中指定的值。返回 true 或 false ，//java:str.matches(reg)

   > ​	需求：
   > ​		校验邮箱：
   > ​		var email = haohao_827@163.com
   > ​		var reg = /^[A-z]+[A-z0-9_-]*\@[A-z0-9]+\.[A-z]+$/;
   > ​		reg.test(email);

# js的函数

### js函数定义的方式

#### (1)普通方式

​			

```javascript
语法：function 函数名(参数列表){函数体}
```

​		

```html
	示例：
<script type="text/javascript">
			 	function fn(a,b){
			 		var sum=a+b;
			 		 alert(sum);
					 for(var i=0;i<arguments.length;i++){ //arguments是个数组  会将传递的实参进行封装
						 alert(arguments[i]);
					 }
			 	}
				fn(10);//实参个数<形参个数    
				//由于函数找不到第二个参数，所以输出undefined（未定义），当undefined类型数据和一个数值类型数据进行运算时，undefined先转换成数值类型NaN（非数值），然后NaN和一个数值类型数据运算，结果还是NaN。
</script>
```




#### (2)匿名函数

​		

```javascript
	语法：function(参数列表){函数体}
```

​			示例：
​				var method = function(){
​					alert("yyy");
​				};
​				method();

#### (3)对象函数

​			

```javascript
语法：new Function(参数1,参数2,...,函数体);
```

​			*注意：参数名称必须使用字符串形式、最后一个默认是函数体且函数体需要字符串形式*
​			示例：
​				var fn = new Function("a","b","alert(a+b)");
​				fn(2,5);





### 函数的参数

> (1)形参没有var修饰
> (2)形参和实参个数不一定相等
> (3)arguments对象 是个数组 会将传递的实参进行封装
> 		function fn(a,b,c){
> 			//var sum = a+b+c;
> 			//alert(sum);
> 			//arguments是个数组 会将传递的实参进行封装
> 			for(var i=0;i<arguments.length;i++){
> 				alert(arguments[i]);
> 			}
> 		}
> 		fn(1,2,4,8);	



### 返回值

> (1)在定义函数的时候不必表明是否具有返回值  
> (2)返回值仅仅通过return关键字就可以了 return后的代码不执行
> 		function fn(a,b){
> 			return a+b;
> 			//alert("xxxx");
> 		}
> 		alert(fn(2,3));



### js的全局函数

(1)**编码和解码**

​		encodeURI()   decodeURI()
​		encodeURIComponet()	  decodeURIComponent()
​		escape()	unescape()
​		三者区别：
​			进行编码的符号范围不同

encodeURI()和encodeURIComponent()方法都可以对URI（通用资源标识符）进行编码，以便发送给浏览器。
但它们编码的范围有所不用。

encodeURI()方法不会对下列字符编码：ASCII字母、数字、~!@#$&*()=:/,;?+'
encodeURIComponent()方法不会对下列字符编码：ASCII字母、数字、~!*()'

​	(2)**强制转换**
​		Number()
​		String()
​		Boolean()
​	(3**)转成数字**
​		parseInt()
​		parseFloat()
​	(4)**eval()方法**	
​		将字符串当作脚本进行解析运行
​		//var str = "var a=2;var b=3;alert(a+b)";
​		//eval(str);
​		function print(str){
​			eval(str);
​		}
​		print("自定义逻辑");



### js的事件

​	事件
​	事件源
​	响应行为

#### 	1、js的常用事件

##### 点击事件

​		onclick:点击事件
​		onchange:域内容被改变的事件
​			需求：实现二级联动

```javascript
			<select id="city">
				<option value="bj">北京</option>
				<option value="tj">天津</option>
				<option value="sh">上海</option>
			</select>
			<select id="area">
				<option>海淀</option>
				<option>朝阳</option>
				<option>东城</option>
			</select>
			<script type="text/javascript">
				var select = document.getElementById("city");
				var area = document.getElementById("area");
				select.onchange = function(){
					var optionVal = select.value;
					switch(optionVal){
						case 'bj':
							area.innerHTML = "<option>海淀</option><option>朝阳</option><option>东城</option>";
							break;
						case 'tj':
							area.innerHTML = "<option>南开</option><option>西青</option><option>河西</option>";
							break;
						case 'sh':
							area.innerHTML = "<option>浦东</option><option>杨浦</option>";
							break;
						default:
							alert("error");
					}
				};		
</script>
```



```html
<!-- 1.将事件和相应行为内嵌到html标签中 -->
		<input type="button" name="" id="" value="button1" onclick="alert('button1')" />
		<br/>
<!-- 2.将事件内嵌到html中而相应行为用函数进行封装 -->
		<input type="button" name="" id="" value="button2" onclick="fn()" />
		<br/>
<!-- 3.将事件和相应行为与html标签完全离开 -->
		<input type="button" name="" id="btn3" value="button3"/>
		<br/>
		<script type="text/javascript">
			function fn(){
				alert("button2");
			}
			var btn=document.getElementById("btn3");
			btn.onclick=function(){
				alert("button3");
			}
		</script>
```

​				innerHTML	改变文本, URL, 及链接目标:





##### 焦点事件

> ​	onfocus:获得焦点的事件
> ​	onblur:失去焦点的事件

*需求：	当输入框获得焦点的时候，提示输入的内容格式;*
				*当输入框失去焦点的时候，提示输入有误*

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		
		<!-- 将一个 <label> 和一个 <input> 元素匹配在一起，你需要给 <input> 一个 id 属性。而 <label> 需要一个 for 属性，其值和  <input> 的 id 一样。 -->
		<label for="txt">name</label> 
		 <input type="text"  id="txt"/><span id="info"></span>  
		
		<script type="text/javascript">
			var txt=document.getElementById("txt");
			var span=document.getElementById("info");
			txt.onfocus=function(){
				span.innerHTML="<font color='green'>用户名格式最小为8位</font>";
			};
			txt.onblur=function(){
				span.innerHTML="<font color='red'>对不起格式不正确！</font>";
			};
		</script>
	</body>
</html>
```



##### 鼠标事件

> ​	onmouseover:鼠标悬浮的事件
> ​	onmouseout:鼠标离开的事件

​		*需求：div元素 鼠标移入变为绿色 移出恢复原色*
​		



```
		#d1{background-color: red;width:200px;height: 200px;}
		<div id="d1"></div>
		<script type="text/javascript">
			var div = document.getElementById("d1");
			div.onmouseover = function(){
				this.style.backgroundColor = "green";
			};
			div.onmouseout = function(){
				this.style.backgroundColor = "red";
			};
		</script>
```



##### 	onload:加载完毕的事件

​		*等到页面加载完毕在执行onload事件所指向的函数*




```javascript
<html>
	<head>
		<meta charset="utf-8">
		<title></title>	
		<script type="text/javascript">
			//window.onload=function(){    //1、等到全部内容加载完毕，在触发此事件，就可以避免因先后顺序造成的无法绑定问题
				function method1(){
				var span=document.getElementById("span");
				span.innerHTML="<h1>helloworld</h1>";
			}
		</script>
	</head>
	<body onload="method1()">   <!-- 2、或者等整个body执行完毕再触发 -->
		<span id="span">
			
		</span>
	</body>
</html>
```

#### 2、事件的绑定方式

> ​	(1)**将事件和响应行为都内嵌到html标签中**
> ​	
>
> ```javascript
> 	<input type="button" value="button"  onclick="alert('xxx')"/>
> ```
>
> ​	(2)**将事件内嵌到html中而响应行为用函数进行封装**
> ​	
>
> ```javascript
> 	<input type="button" value="button" onclick="fn()" />   //点击的时候就执行fn方法
> 			<script type="text/javascript">
> 			function fn(){        //
> 				alert("yyy");
> 			}
> 		</script>
> ```
>
> 
>
> ​	(3)**将事件和响应行为 与html标签完全分离**
> ​		
>
> ```javascript
> 	<input id="btn" type="button" value="button"/>
> 		<script type="text/javascript">
> 			var btn = document.getElementById("btn");   //将在id为btn的标签上绑定事件
> 			btn.onclick = function(){        //点击的时候就执行
> 				alert("zzz");
> 			};
> 		</script>
> ```



### 	**this关键字**

​		*this经过事件的函数进行传递的是本html标签对象*

```javascript
	<input id="btn" name="mybtn" type="button" value="button123" onclick="fn(this)"/>
			<script type="text/javascript">
			function fn(obj){
				alert(obj.name);
			}
		</script>
```





### 



### 下拉框

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<select id="city">
					<option value="bj">北京</option>
					<option value="tj">天津</option>
					<option value="sh">上海</option>
				</select>
				<select id="area">
					<option>海淀</option>
					<option>朝阳</option>
					<option>东城</option>
				</select>
				<script type="text/javascript">
					var select =document.getElementById("city");
					var area =document.getElementById("area");
					select.onchange=function(){
						var optionVal=select.value;
						switch(optionVal){
							case 'bj':
								area.innerHTML = "<option>海淀</option><option>朝阳</option><option>东城</option>";
								break;
							case 'tj':
								area.innerHTML = "<option>南开</option><option>西青</option><option>河西</option>";
								break;
							case 'sh':
								area.innerHTML = "<option>浦东</option><option>杨浦</option>";
								break;
							default:
								alert("error");
						}
					}
		</script>
	</body>
</html>

```



### 

### 键盘事件

```html
<body>
		<br><br><br>
		<input type="text" name="" id="k4" onkeydown="fn1(event)" onkeypress="fn2(event)" onkeyup="fn3(event)"/>
		<span id="txt"></span>
	</body>
	<script type="text/javascript">
		var txt=document.getElementById("txt");
		var str="";
		function fn1(e){
			alert(e.keyCode);
			if(e.keyCode==13){
				str+="你按下了回车键keyDown,";
				txt.innerHTML=str;
			}
		}
		function fn2(e){
			if(e.keyCode==13){
				str+="按到最底keypress";
				txt.innerHTML=str;
			}
		}
		function fn3(e){
			if(e.keyCode==13){
				str+="你松开了回车键keyup";
				txt.innerHTML=str;
			}
		}
	</script>
```

案例：

```html
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>事件编程案例</title>

	</head>
	<body>
		没有按钮的表单，用回车键提交
		<form  action="register.jsp" method="get">

			用户名：<input type="text" id="k1"  onkeydown="fn1(event)"/><br />
			密&nbsp;&nbsp;&nbsp;码：<input type="text" id="k2"  onkeypress="fn2(event)"/><br />
			电&nbsp;&nbsp;&nbsp;话：<input type="text" id="k3" name="username" onkeyup="Submitform(event);"/><br />
			<input type="submit" value="注册">
		</form>
		<br /><br /><br />
		<span id="txt"></span>
	</body>
	<script language="JavaScript">
		function Submitform(e){
			if(e.keyCode==13){
				document.forms(0).submit();//提交表单（没有此语句也可以提交，但是可以借鉴点击其他键的时候也可以提交表单）
			}
		}
		function fn1(e){
			if(e.keyCode==13){
				e.preventDefault();
				document.getElementById("k2").focus();//下一个标签获得焦点
			}
			
		}
		function fn2(e){
			if(e.keyCode==13){
				e.preventDefault();
				document.getElementById("k3").focus();//下一个标签获得焦点
			}
			
		}

		
		
	</script>
</html>

```



### 提交事件

```html
function fn(){          //confirm('') 会返回true或false
					var flag=confirm('你确定要删除该学生信息吗？');
					return flag;}
```

​	event.preventDefault();//阻止表单提交（阻止默认行为）



### js的bom

#### (1)window对象

```javascript

		弹框的方法：
			提示框：alert("提示信息");     
			确认框：confirm("确认信息");
				有返回值：如果点击确认返回true  如果点击取消 返回false
				var res = confirm("您确认要删除吗？");
				alert(res);
			输入框：prompt("提示信息");
				有返回值：如果点击确认返回输入框的文本 点击取消返回null
				var res =  prompt("请输入密码？");
				alert(res);
		open方法：
			window.open("url地址");			
			open("../jsCore/demo10.html");

open方法的完整用法：
window.open('page.html', 'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no') 
//该句写成一行代码

参数解释：

window.open 弹出新窗口的命令；
'page.html' 弹出窗口的文件名；?
　　
'newwindow' 弹出窗口的名字（不是文件名），非必须，可用空''代替；?
　　
height=100 窗口高度；?
　　
width=400 窗口宽度；?
　　
top=0 窗口距离屏幕上方的象素值；?
　　
left=0 窗口距离屏幕左侧的象素值；?
　　
toolbar=no 是否显示工具栏，yes为显示；?
　　
menubar，scrollbars 表示菜单栏和滚动栏。?
　　
resizable=no 是否允许改变窗口大小，yes为允许；?
　　
location=no 是否显示地址栏，yes为允许；?
　　
status=no 是否显示状态栏内的信息（通常是文件已经打开），yes为允许
```



#### (2)定时器

> ①setInterval(function(){
> 					语句
> 				},
> 				2000
> 			);
>
> ​				或者
>
> ②setTimeout(fn,2000);
>

```javascript

			setTimeout(函数,毫秒值);
				setTimeout(
					function(){
						alert("hello world!!!");
					},
					2000
				);
			clearTimeout(定时器的名称);
				var timer;
				var fn = function(){
					alert("x");
					timer = setTimeout(fn,2000);
				};
				var closer = function(){
					clearTimeout(timer);
				};
				fn();
			
			setInterval(函数,毫秒值);
			clearInterval(定时器的名称)
				var timer = setInterval(
				function(){
					alert("nihao");
				},
				2000
			);
			var closer = function(){
				clearInterval(timer);
			};
			
		需求：注册后5秒钟跳转首页
		恭喜您注册成功，<span id="second" style="color: red;">5</span>秒后跳转到首页，如果不跳转请<a href="../jsCore/demo10.html">点击这里</a>
		<script type="text/javascript">
			var time = 5;
			var timer;
			timer = setInterval(
				function(){
					var second = document.getElementById("second");
					if(time>=1){
						second.innerHTML = time;
						time--;
					}else{
						clearInterval(timer);
						location.href="../jsCore/demo10.html";
					}
				},
				1000
			);
		</script>

```

#### (3)location	

*把用户带到一个新地址*

```javascript
window.location="地址"
```



#### (4)history

> back();
> forward();
> go();

```javascript
<a href="demo7.html">后一页</a>
<input type="button" value="上一页" onclick="history.back()">
<input type="button" value="下一页" onclick="history.forward()">
		
<input type="button" value="上一页" onclick="history.go(-1)">
<input type="button" value="下一页" onclick="history.go(1)">
```







### js的dom

1、理解一下文档对象模型
		html文件加载到内存之后会形成一颗dom树，根据这些节点对象可以进行脚本代码的动态修改
		在dom树当中 一切皆为节点对象
	2、dom方法和属性
		笔记见代码

![image-20210719213355221](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210719213355221.png)

#### Element元素的获取操作

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210719213637417.png" alt="image-20210719213637417" style="zoom: 80%;" />

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>元素的获取</title>
</head>
<body>
    <div id="div1">div1</div>
    <div id="div2">div2</div>
    <div class="cls">div3</div>
    <div class="cls">div4</div>
    <input type="text" name="username"/>
</body>
<script>
    //1. getElementById()   根据id属性值获取元素对象
    let div1 = document.getElementById("div1");
    //alert(div1);

    //2. getElementsByTagName()   根据元素名称获取元素对象们，返回数组
    let divs = document.getElementsByTagName("div");
    //alert(divs.length);

    //3. getElementsByClassName()  根据class属性值获取元素对象们，返回数组
    let cls = document.getElementsByClassName("cls");
    //alert(cls.length);

    //4. getElementsByName()   根据name属性值获取元素对象们，返回数组
    let username = document.getElementsByName("username");
    //alert(username.length);

    //5. 子元素对象.parentElement属性   获取当前元素的父元素
    let body = div1.parentElement;
    alert(body);
</script>
</html>

```

#### Element元素的增删改操作

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210719213722826.png" alt="image-20210719213722826" style="zoom:80%;" />

```html
 	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>元素的增删改</title>
</head>
<body>
    <select id="s">
        <option>---请选择---</option>
        <option>北京</option>
        <option>上海</option>
        <option>广州</option>
    </select>
</body>
<script>
    //1. createElement()   创建新的元素
    let option = document.createElement("option");
    //为option添加文本内容
    option.innerText = "深圳";

    //2. appendChild()     将子元素添加到父元素中
    let select = document.getElementById("s");
    select.appendChild(option);

    //3. removeChild()     通过父元素删除子元素
    //select.removeChild(option);

    //4. replaceChild()    用新元素替换老元素
    let option2 = document.createElement("option");
    option2.innerText = "杭州";
    select.replaceChild(option2,option);

</script>
</html>

```

## Attribute属性的操作

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210719213746992.png" alt="image-20210719213746992" style="zoom:80%;" />

```html
 	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>属性的操作</title>
    <style>
        .aColor{
            color: blue;
        }
    </style>
</head>
<body>
    <a>点我呀</a>
</body>
<script>
    //1. setAttribute()    添加属性
    let a = document.getElementsByTagName("a")[0];
    a.setAttribute("href","https://www.baidu.com");

    //2. getAttribute()    获取属性
    let value = a.getAttribute("href");
    //alert(value);

    //3. removeAttribute()  删除属性
    //a.removeAttribute("href");

    //4. style属性   添加样式
    //a.style.color = "red";

    //5. className属性   添加指定样式
    a.className = "aColor";

</script>
</html>

```

#### Text文本的操作

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210719213812151.png" alt="image-20210719213812151" style="zoom:80%;" />

```html
<script>
    //1. innerText   添加文本内容，不解析标签
    let div = document.getElementById("div");
    div.innerText = "<b>我是div</b>";   //结果：<b>我是div</b>

    //2. innerHTML   添加文本内容，解析标签
    div.innerHTML = "<b>我是div</b>";   //结果：我是div

```

