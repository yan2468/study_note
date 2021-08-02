![image-20210720111226098](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210720111226098.png)

# JQuery

核心理念是write less,do more(写得更少,做得更多)

# jq一览

**语法：**

​    `$("选择器")     ， $(dom对象)  ， $("<div>")`

**选择器：**

​    `基本：#id 、element 、 .class 、s1 , s2, ... 、*`

​    `层级：A B 、A>B 、A+B 、A~B`

​    `基本过滤：:first  :last  :eq()  :gt()  :lt()  :even   :odd   :header   :animated   :focus`

​    `内容过滤：:contains()    :empty    :parent    :has()`

​    `可见过滤：:visible    :hidden`

​    `属性：[attr]  [attr=val]  [attr!=val]  [attr^=val]  [attr$=val]  [attr*=val]  [attr=val][][]`

​    `子元素：  :nth-child() :first-child  :last-child :only-child`

​    `表单过滤：  :input   :text   :password   :radio   :checkbox   :file   :submit   :reset   :image   :button   :hidden`

​    `表单对象属性过滤：   :enabled   :disabled   :checked   :selected`

**属性和CSS：**

​    `attr()  、 removeAttr()`

​    `addClass()   removeClass()   toggleClass()`

​    `val()   html()   text()`

​    `css()`

​    `offset() --> {top , left}`

​    `scrollTop()   /scrollLeft()`

​    `width()   height()`

**文档处理：**

​    内部：`append   prepend   appendTo   prependTo`

​    外部：`after   before   insertAfter   insertBefore`

​    删除：`empty    remove   detach --> data()`

​    复制：`clone(true)`

​    替换：`replaceWith    replaceAll`

​    包裹：`wrap   wrapAll   wrapInner   unWrap()`

 



## jQuery语法

​	

```javascript
<script type="text/javascript">
		//js 执行时，有加载顺序
		
		/* jQuery获得数据
		 * * 语法：$("选择器")   == jQuery("选择器")
		 * 
		 */
		
		var username = $("#username");
		// * val()函数 用于获得 value属性的值
		alert(username.val());
		
	</script>

```



## jQuery对象和dom对象转换 

```javascript
<script type="text/javascript">
		//1 使用javascript获得value值
		var username = document.getElementById("username");
		//alert(username.value);
		
		//2 将 dom对象 转换 jQuery对象
		// * 语法：$(dom对象)
		// * 建议：jQuery对象变量名，建议为$开头
		var $username = $(username);
//		alert($username.val());
		
		//3 将 jQuery对象 转换 dom对象
		//3.1 jQuery对象内部使用【数组】存放所有的数据，可以数组的下标获取（索引）
		var username2 = $username[0];
		alert(username2.value);
		//3.2 jQuery提供函数 get() 转换成dom对象
		var username3 = $username.get(0);
		alert(username3.value);
	</script>

```



# 选择器

### 基本【掌握】

```javascript
//-------ID选择器(id)
		  $("#byId").css("backgroundColor","red");
//-------类选择器(class)
		  $(".byClass").css("backgroundColor","red");
//-------元素（标签）选择器
		   $("p").css("backgroundColor","red");
//-------通配选择器(所有的)
		   $("*").css("color","red");
//-------同时选择p标签和类为byClass的标签，多选择器
		   $("p,.byclass").css("backgroundColor","red");
```



### 层级

> A   B ，获得A元素内部所有的B后代元素。（爷孙）
>
> A > B ，获得A元素内部所有的B子元素。（父子）
>
> A + B ，获得A元素后面的第一个兄弟B。（兄弟）
>
> A ~ B ，获得A元素后面的所有的兄弟B。（所有兄弟）

```javascript
// ----------------------------后代选择器
 					 $("#dv p").css('backgroundColor','red');//获得dv标签后面的所有p后代元素
					 $("#dv").find("p").css('backgroundColor','red');//查找dv元素的所有子元素标签
					
// 子元素选择器
					 选择div下面的儿子P标签
					 $("#dv>p").css('backgroundColor','red');
					 $("#dv").children("p").css('backgroundColor','red');
					
// 获取id为dv后紧邻的第一个兄弟元素
					 $("#dv+p").css('backgroundColor','red');
					 $("#dv").next("p").css('backgroundColor','red');
					 $("#dv").next("p").next().css('backgroundColor','red');//下一个的下一个
					
// 获取id为dv后的所有兄弟p标签
					 $("#dv~p").css('backgroundColor','red');
					 $("#dv").nextAll("p").css('backgroundColor','red');
					 $("#dv").nextAll("").css('backgroundColor','red');	// 获取id为dv后的所有兄弟标签
					
// 获取id为dv前紧邻的第一个兄弟元素p
					 $("#dv").prev("p").css('backgroundColor','red');
					 $("#dv").prev("p").prev("").css('backgroundColor','red');//上一个的上一个
// 获取id为dv前的所有兄弟p标签
					 $("#dv").prevAll("p").css('backgroundColor','red');
					
// 获取div的所有兄弟
					 $("#dv").siblings("").css('backgroundColor','red');
					 $("#dv").siblings("p").css('backgroundColor','red');// 获取div的所有兄弟p标签
					
//获取父级元素
					 $("#p1").parent().css('backgroundColor','red');
					 $("#p1").parent().parent().css('backgroundColor','red');
					 $("#p1").parent().parent().parent().css('backgroundColor','red');
```



### 基本过滤

> :first    , 第一个
>
> :last    ,最后一个
>
> :eq(index) ，获得指定索引
>
> :gt(index) 大于
>
> :lt(index) 小于
>
> :even 偶数，从 0 开始计数。例如：查找表格的1、3、5...行（即索引值0、2、4...）
>
> :odd 奇数
>
> :not(selector) 去除所有与给定选择器匹配的元素
>
> \------------------------------
>
> :header 获得所有标题元素。例如：<h1>...<h6>
>
> :animated 获得所有动画
>
> :focus   获得焦点

```javascript
//--------所有的li元素背景颜色改变
$("li").css("background-color","#09F");
				
//----------改变第一个<li>元素的背景颜色
				$("li:first").css("background-color","#09F");
				$("li").first().css("background-color","#09F");
				
 //-------改变最后一个<li>元素的背景颜色
				$("li:last").css("background-color","#09F");
				$("li").last().css("background-color","#09F");

//---------改变class不为three的<li>元素的背景颜色
				$("li:not(.three)").css("background-color","#09F");

//------------偶数行变色
				$("li:even").css("background-color","#09F");
//---------------奇数行变色
				$("li:odd").css("background-color","red");

//------------改变索引值等于2的<li>元素的背景颜色
				$("li:eq(2)").css("background-color","#09F");
				$("li").eq(2).css("background-color","#09F");
//--------------改变索引值大于2的<li>元素的背景颜色
				$("li:gt(2)").css("background-color","#09F");
//-------------改变索引值小于2的<li>元素的背景颜色
				$("li:lt(2)").css("background-color","#09F");
//-------------改变所有标题元素（h标签）
				$(":header").css("background-color","#09F");
```



### 内容过滤

> :empty 当前元素是否为空（是否有标签体--子元素、文本）
>
> :has(...) 当前元素，是否含有指定的子元素
>
> :parent  当前元素是否是父元素
>
> :contains( text ) 标签体是否含有指定的文本

```javascript
//---------------标签体是否含有指定的文本					
$('div:contains("也")').css('background','pink');
//----------------当前元素是否含有指定的子元素
					$('div:has(span)').css('background','pink');
//---------------当前元素是否为空
					$('div:empty').css('background','pink'); 
//---------------标签体是否是父元素
					$('div:parent').css('background','pink'); 
```



### 可见性过滤[掌握]

> :hidden  隐藏。特指 <xxx style="display:none;"> ，获得 <input type="hidden">
>
> :visible  可见（默认）

```javascript
<body>
<p id="txt_hide">点击按钮，我会被隐藏哦~</p>
<p id="txt_show">隐藏的我，被显示了，嘿嘿^^</p>
<input name="show" type="button" value="点击显示文字" />
<input name="hide" type="button" value="点击隐藏文字" />
<script src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("input[name=show]").click(function(){
				$("p:hidden").css("display","block");
				//$("p:hidden").show();
			});
			
			$("input[name=hide]").click(function(){
					$("p:visible").css("display","none");
					//$("p:visible").hide();
				});
			});
	</script>
</body>
```



### 属性【掌握】

> [属性名]           获得指定的属性名的元素
>
> [属性名=值]        获得属性名 等于 指定值的 的元素【1】
>
> [属性名!=值]        获得属性名 不等于 指定值的 的元素
>
> `[as1][as2][as3]....`     复合选择器，多个条件同时成立。类似 where ...and...and【2】
>
> \---------------------------------------
>
> [属性名^=值]        获得以属性值 开头 的元素
>
> [属性名$=值]       获得以属性值 结尾 的元素
>
> [属性名*=值]       获得 含有属性值 的元素

```javascript
//--------所有为title属性的
		$("[title]").css("background-color","#09F");   

//--------所有title属性不等于cartoonlist的
		$("[title=cartoonlist]").css("background-color","#09F")	;

//--------所有li有title属性的
		$("li[title]").css("background-color","#09F")	;

//--------title属性为h开头的
		$("[title^=h]").css("background-color","#09F")	;

//--------title属性为p结束的
		$("[title$=p]").css("background-color","#09F")	;

//--------title属性中含有s的
		$("[title*=s]").css("background-color","#09F")	;

//--------li标签且class为evens且title属性中含有y的
		$("li[class=evens][title*=y]").css("background-color","#09F")	;
```



### 子元素过滤

> :nth-child(index) ，获得每个父元素下的第几个孩子，从1开始。
>
> :first-child ， 获得每个父元素下的第一个孩子
>
> :last-child ， 获得每个父元素下的最后孩子
>
> :only-child ， 获得每个父元素下的独生子

```javascript
//-----------父元素下的第一个li元素
				$('li:first-child').css('background','orange');
//-----------父元素下的最后一个li元素
				$('li:last-child').css('background','orange');
//-----------只有一个li子元素的父元素
				$('li:only-child').css('background','orange');
//-----------每个父元素中的第三个li元素
				$('li:nth-child(2)').css('background','orange');
```



### 表单过滤

> :input 选取所有的表单元素。（<input> / <select> / <textarea> / <button>）
>
> :text           选取所有的单行文本框<input type="text">
>
> :password      选取所有的密码框<input type=" password ">
>
> :radio           选取所有的单选<input type="radio">
>
> :checkbox       选取所有的多选框<input type="checkbox">
>
> :submit         选取所有的提交按钮<input type="submit">
>
> :image          选取所有的图片按钮<input type="image" src="">
>
> :reset           选取所有重置按钮<input type="reset">
>
> :file           选取所有文件上传按钮<input type="file">
>
> :hidden         选取所有不可见的元素（隐藏域）<input type="hidden"> ,还可以获得<xxx style="display:none"> 
>
> ​                  ~~其他值：`<br>`   <option> ,存在浏览器兼容问题~~
>
> :button          选取所有普通按钮。 <button > 或 <input type="button">

```javascript
//---------隐藏所有表单标签
						$(':input').hide();
//---------给所有表单标签添加背景颜色
						 $(':input').css('background','orange');
//---------给所有的text标签添加背景颜色
						 $(':text').css('background','orange');
//---------给所有的password标签添加背景颜色
						$(':password').css('background','orange');
//---------隐藏单选标签
						 $(':radio').hide();
//---------隐藏多选标签
						 $(':checkbox').hide();
//---------给所有的button标签添加背景颜色
						 $(':button').css('background','orange');
//---------隐藏image标签
						 $(':image').hide();  
//---------隐藏submit标签
						 $(':submit').hide();
//---------隐藏reset标签
						 $(':reset').hide();
//---------选取所有的不可见元素
						$(":hidden");
```



### 表单对象属性过滤【掌握】

> :enabled     可用
>
> :disabled    不可用。<xxx disabled="disabled"> 或<xxx disabled=""> 或 <xxx disabled>
>
> :checked    选中（单选框radio、复选框 checkbox）
>
> :selected    选择（下拉列表 select option）

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210720212140494.png" alt="image-20210720212140494" style="zoom:80%;" />

用prop





# 筛选

- 选择器可以完成功能，筛选提供相同函数。

​    选择器  :first

​    筛选    first()

-  对比：

​    $("div:first")  直接获得第一个div （永远只能操作第一个）

​    $("div").first() 先获得所有的div，从所有的中筛选出第一个。 （可以操作第一个，也可以操作所有）、

## 过滤

> eq(index | -index) 类型 :eq()
>
> ​    index：正数，从头开始获得指定索引的元素。这个元素的位置是从0算起。0表示第一个
>
> ​    -index：负数，从尾开始获得指定索引的元素。1算起。 -1表示最后一个
>
> 
>
> first()    第一个 :first
>
> last()     最后一个 :last
>
> is()         判断
>
> hasClass()   判断是否是指定class 。<xxx class="my">
>
> ​    这其实就是 is("." + class)。
>
> filter() 筛选出与指定表达式匹配的元素集合
>
> not() 将指定内容删除
>
> \--------------------------------
>
> has() 子元素是否有
>
> slice(start , end) 截取元素 ，[2,4) --> 2,3
>
> map() jQuery对象 拆分成 jQuery对象数组
>
> 



## 查找

> <A>
>
> ​    <B>
>
> ​       <C></C>
>
> ​       <D></D>
>
> ​       <E></E>
>
> ​       <F></F>
>
> ​    </B>
>
> </A>
>
> 
>
> B.children([...])  获得所有的子元素。CDEF
>
> B.children(“C”) 类似子选择器
>
> A.find(D) 从指定的区域查询指定元素。D  类似后代选择器
>
> D.next() 下一个兄弟。E
>
> D.nextAll() 后面的所有兄弟。EF
>
> E.prev() 上一个兄弟。D （previous）
>
> E.prevAll() 前面的所有兄弟。CD
>
> E.siblings()  所有兄弟。CDF
>
> E.parent() 父元素。B
>
> E.closest(A) 向上获得指定的父元素（含自己），如果获得返回一个对象，如果没有没有对象。
>
> \------------------------------
>
>  
>
> C.nextUntil(E) 获得后面所有兄弟，直到指定条件位置。DE
>
> F.prevUntil(D) 获得前面所有兄弟，直到指定条件位置。DE
>
>  
>
> E.parents()  获得所有的祖先元素。AB



- *closest和parents的主要区别是：*

*1，前者从当前元素开始匹配寻找，后者从父元素开始匹配寻找；*

*2，前者逐级向上查找，直到发现匹配的元素后就停止了，后者一直向上查找直到根元素，然后把这些元素放进一个临时集合中，再用给定的选择器表达式去过滤；*

*3，前者返回0或1个元素，后者可能包含0个，1个，或者多个元素。* 



## 串联

> A.add(B) 将A和B组合一个对象 。类型 $("A,B")
>
> andSelf() ： 将之前对象添加到操作集合中
>
>   													  A.children().andSelf() 
>	
>    													A  孩子  孩子和A
>
> end() ：回到最近的一个"破坏性"操作之前
>
>    																 A.children().children().end() .end() 
>	
>    																 A       孩子            孙子     孩子  A
>
> \--------------------
>
> contents() 获得所有的子节点（子元素 和 文本）





# 属性和CSS

### 属性【掌握】

> attr(name)  获得指定属性名的值 //读 attr(name);
>
> attr(key ,val ) 给一个指定属性名设置值,prop(key,val)作用相同，但只适用于固有属性 //写
>
> attr(prop ) 给多个属性名设置值。参数：prop  json数据
>
> ​    {k : v , k : v , .....}
>
> removeAttr(name) 移除指定属性

```javascript
				$("#btn1").click(function() {
					var title=$("li:first").attr("title");// 获取 读属性 看
					alert(title);
				});
				$("#btn2").click(function() {
					$("li:first").attr("title","hello kitty!");//修改  写
				});
				$("#btn3").click(function() {
					$("li:first").removeAttr("title");//移除
				});
				$("#btn4").click(function() {
					var alt=$("img").attr("alt");//获取id为img的alt属性
					alert(alt);
				});
				$("#btn5").click(function() {
					$("img").attr({//  增加 写多个属性
						'width':"75",
						'height':"100"
					});
				});
				
				$("#btn6").click(function() {
					//$('#ckx').attr("checked","checked");
					$('#ckx').attr("checked",true);  //只能点一次
					// $('#ckx').prop("checked",true);  //只用在enabled diasabled selected checked   //能点多次
				});
				
				$("#btn7").click(function() {
					$('#ckx').removeAttr("checked"); //只能点一次
					// $('#ckx').prop("checked",false);  //能点多次
				});
```





### CSS类

> addClass("my") 追加一个类
>
> removeClass("my") 将指定类移除
>
> toggleClass("my") 如果有my将移除，如果没有将添加。

```javascript
				$('#btn1').click(function() {
					$('div').addClass("style1");
				});

				$('#btn2').click(function() {
					$('div').addClass("style2");
				});

				$('#btn3').click(function() {
					$('div').removeClass("style2");
				});

				$('#btn4').click(function() {
					$('div').removeClass();
				});
				
				$('#btn5').click(function() {
					$('div').toggleClass("style3");
				});
```







### HTML代码/文本/值【掌握】

> val()    获得**表单中**value的值，(作用相当于javascript 的value属性)
>
> val(text) 设置value的值
>
> ```javascript
> $('.btn1').click(function() {
>           alert($(".txt").val());//不带参的方法，读,value   jq对象
> 		//alert($(".txt")[0].value);//不带参的方法，读,value  dom对象
>         });
> $('.btn2').click(function() {
>           $(".txt").val("hello world!!");//带参的方法，写,  jq对象
> 			// $(".txt").val("");//清空
> 			// $(".txt")[0].value="hello  world!!";//不带参的方法，写  dom对象
> 			});
> ```
>
> <img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210722194524747.png" alt="image-20210722194524747" style="zoom:67%;" />
>
> 





> html() 获得html代码，含有标签（相当于javascript的：innerHTML属性）
>
> html(...) 设置html代码，如果有标签，将进行解析。
>
> ```javascript
> $("#btn1").click(function() {	 
> 		 var content=$("#d1").html();   //读 innerHTML ,只适用于DOM对象
> 		 // var content=$("#d1")[0].innerHTML;//  JQUERY对象 ---->DOM
> 		 // var div= document.getElementById("d1");//  DOM对象 ---->JQUERY
> 		 // var content=$(div).html();//  DOM对象 ---->JQUERY
> 		 alert(content);
> 	   });
> ```
>
> <img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210722194311722.png" alt="image-20210722194311722" style="zoom: 50%;" />







> text() 获得**纯文本**值，**将标签进行过滤**（相当于javascript的：innerText属性）
>
> text(...) 设置文本值，如果有标签，将被转义 -->  < `&lt;`  `&`  `&amp;`  >  `&lt;`  `&nbsp;`
>
> ```javascript
>  $("#btn1").click(function() {	 
>  			var content=$(".left").text();
>  			alert(content);
>  	   });
> 
> 
> ```
>
> <img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210722194443303.png" alt="image-20210722194443303" style="zoom:50%;" />











### CSS

> css(name) 获得指定名称的css值
>
> css(name ,value) 设置一对值
>
> css(prop) 设置一组值

```javascript
$(document).ready(function(){
			//获取单个属性的值
			// var obj=$('div').css('font-size');
			// alert(obj);
			//获取多个属性的值
			var obj=$('div').css(['color','font-size','font-family']);//键
			//在控制台查看obj
			console.log(obj);
		});
```



###  位置

> offset(...) 设置坐标。例如：$(this).offset({"top":0 , "left" : 0})
>
>  offset() 获得坐标 ， 返回JSON对象，{"top":200, "left" : 100}
>
> ​    ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)
>
> scrollTop() 垂直滚动条 滚过的距离
>
> scrollLeft() 水平滚动条 滚过的距离

```javascript
$('input').click(function() {
        	// alert($('div').offset());//获取
			// alert("left:"+$('div').offset().left+" top:"+$('div').offset().top);  //获取
			$('div').offset({left:300,top:300});//修改
        });
```



### 尺寸

> height([...]) 获得 或 设置 高度
>
> width([...])获得 或 设置 宽度

```javascript
<input type="button" value="按钮">
    <div>只要努力，人生的长度和宽度都可以改变</div>
    <script>
        $('input').click(function() {
			// $('div').width(300);
			// $('div').height(300);
			// $('div').width($('div').width()+50);
			// $('div').height($('div').height()+50);
			
        });
```





# 文档处理

## 内部插入【掌握】

> A.append(B) 将B插入到A的内部后面（之后的串联操作，操作A）
>
> ​    <A>
>
> ​       ....
>
> ​       <B></B>
>
> ​    <A>
>
> A.prepend(B) 将B插入到A的内部前面
>
> ​    <A>
>
> ​       <B></B>
>
> ​       ....
>
> ​    <A>
>
> \--------------------------------------------
>
> A.appendTo(B) 将A插入到B的内部后面 （之后的串联操作，操作A）
>
> A.prependTo(B) 将A插入到B的内部前面

```javascript

			$(document).ready(function(){
				$(".btn").click(function(){
					// 创建节点
					var $newNodel=$("<li>爱神</li>");//创建含文本的<li>元素节点
					
					// 追加子节点（加到现有子节点的后面）
					// $("ul").append($newNodel);
					// $newNodel.appendTo("ul");
					
					// 前置插入子节点
					// $("ul").prepend($newNodel);
					// $newNodel.prependTo("ul");
					
					// 元素之后插入同辈节点
					// $("ul").after($newNodel);
					// $newNodel.insertAfter("ul");
					
					// // 元素之前插入同辈节点
					// $("ul").before($newNodel);
					// $newNodel.insertBefore("ul");


				});
				
			});
	
```



## 外部插入【掌握】

> A.after(B) , 将B插入到A后面（同级）
>
> ​    <A></A>
>
> ​    <B></B>
>
> A.before(B) ，将B插入到A前面
>
> ​    <B></B>
>
> ​    <A></A>
>
> \-----------------------------------
>
> A.insertAfter(B) , 将A插入到B后面（同级）
>
> ​    <B></B>
>
> ​    <A></A>
>
> A.insertBefore(B) 将A插入到B前面
>
> ​    <A></A>
>
> ​    <B></B>



##  删除[掌握]

> empty() 清空标签体
>
> remove() 删除当前对象。如果之后再使用，元素本身保留，绑定事件 或 绑定数据 都会被移除
>
> detach() 删除当前对象。如果之后再使用，元素本身保留，绑定事件 或 绑定数据 都保留
>
>  

```javascript
// // 删除、清空节点
					// $("ul li:eq(1)").remove();
					// $("ul li:eq(1)").empty();
					// $("ul li:eq(1)").detach();
					
```



> l 绑定数据
>
> ​    data(name) 获得
>
> ​    data(name,value) 设置



```javascript
			$("p").click(function(){    //给p标签绑定事件  （后来的绑定不了）
				$(this).css("background-color","pink");
			});
			
			$("#dv").on("click","p",function(){        //给id为dv的所有p标签绑定事件（可以绑定所有的）
				$(this).css("background-color","pink");
			});
```



## 复制

> clone() 克隆
>
> ​    even ：指示事件处理函数是否会被复制。V1.5以上版本默认值是：false



```javascript
// // 复制节点
					// $("ul li:eq(1)").clone().appendTo("ul");

// // 输出元素本身html
					// alert($("<div></div>").append($("ul li:eq(1)").clone()).html());
					
					// var btn=$(this).clone(true);//true指复印获得原件的事件
					// $("body").append(btn);
```



## 替换

> A.replaceWith(B) ，使用A将B替换掉
>
> A.replaceAll(B) ，使用B将A替换掉

```
// // 替换节点
					// $("ul li:eq(1)").replaceWith($newNodel);
					// $newNodel.replaceAll("ul li:eq(1)");
```



## 包裹

> A.wrap(B) ，使用B将每一个A进行包裹（多个B）
>
> ​    <B><A></A></B>
>
> ​    <B><A></A></B>
>
> ​    ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)
>
> A.wrapAll(B) ，使用B将所有A进行包裹（一个B）
>
> ​    <B>
>
> ​       <A></A>
>
> ​       <A></A>
>
> ​    </B>
>
> ​    ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image004.jpg)
>
> A.wrapInner(B) ,使用B将每一个A的标签体包裹。
>
> ​    <A><B>。。。</B></A>
>
> ​    <A><B>。。。</B></A>
>
> ​    ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image006.jpg)
>
> A.unwrap() ，将A的父元素删除，自己留着

```javascript
					$('li').wrap('<strong></strong>');
					// $('li').wrapAll('<strong></strong>');
					// $('li').wrapInner('<strong></strong>');
					// $('li').unwrap();

```





# each遍历	

```
<script type="text/javascript">
			$(document).ready(function() {
				$("#btn").click(function() {
					$("li").each(function(i,e){
						// alert(i);
						alert($(e).text());
						// alert($(this).text());
					});
				});

			});
		</script>
```





# 事件

![image-20210722201006319](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210722201006319.png)



- focusin 和 focusout

​    **focusin 获得焦点，js中为 focus。**

​       focusin事件跟focus事件区别在于，他可以在父元素上检测子元素获取焦点的情况。

​    **focusout 失去焦点，js中为 blur。**

​       focusout事件跟blur事件区别在于，他可以在父元素上检测子元素失去焦点的情况。

 

- mouseenter 和 mouseleave

  ​    **mouseenter 鼠标移入，js中为mouseover。**

  ​       与 mouseover 事件不同，只有在鼠标指针穿过被选元素时，才会触发 mouseenter 事件。如果鼠标指针穿过任何子元素，同样会触发 mouseover 事件。

  ​    **mouseleave 鼠标移出，js中为mouseout。**

  ​       与 mouseout 事件不同，只有在鼠标指针离开被选元素时，才会触发 mouseleave 事件。如果鼠标指针离开任何子元素，同样会触发 mouseout 事件。

 

# 页面载入

```javascript
$(document).ready(function(){
});
可以简化为：
$(function(){
});

```

# 事件绑定

### 处理

> bind(type ,fn) 给当前对象绑定一个事件。例如：A.bind("click", fn ); 类型：A.click( fn );
>
> unbind(type ) 解绑bind绑定事件
>
>  
>
> one(type ,fn ) 给当前对象绑定一次事件。
>
> \-----------------------------------------
>
> on(events , fn) 提供绑定事件处理程序所需的所有功能。完成3个方法功能.bind(), .delegate(), 和 .live().
>
> off(events) 解绑
>
>  
>
> trigger(type) 在每一个匹配的元素上触发某类事件。例如：A.trigger("submit") ,类似 A.submit();
>
> triggerHandler(type) 在每一个匹配的元素上触发某类事件。但不会执行浏览器默认动作，也不会产生事件冒泡。

### 委派

> live(type , fn) 绑定事件，之后动态添加同样的成员，也具有相同的事件。
>
> die(type) 解绑事件

### 切换

> hover(over , out)
>
> ​    简化版，鼠标移入和移出 ，A.mouseover( fn ).mouseout( fn) 简化 A.hover( fn , fn )
>
> toggle( fn , fn , fn ,...) 执行click事件，每点击一次执行一个fn



# change事件

```
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>改变事件</title>
    <script src="../../js/jquery-1.12.4.js"></script>
  </head>
  <body>

    <p>性别：
      <select class="info" name="male">
        <option value="boy">男</option>
        <option value="girl">女</option>
      </select>
    </p>
    <script>
        // 注册改变事件
       $(".info").change(function(){
		   alert("性别为："+$(".info>option:selected").text());
	   });
    </script>
  </body>
</html>
```





# 效果|动画

## 1.1  基本

*通过改变元素 高度和宽度 进行显示或隐藏*



> show(**speed,fn**) 显示
>
> ​    参数1：speed速度。显示的时间，单位：毫秒。固定字符串：("slow","normal", or "fast")
>
> ​    参数2：fn 回调函数。动画效果完成之后回调函数。
>
> hide() 隐藏
>
> toggle() 切换



## 1.2  滑动

*通过改变元素 高度 进行显示或隐藏*



> slideDown() 显示
>
> slideUp() 隐藏
>
> slideToggle() 切换

 

## 1.3  淡入淡出

*通过改变元素  透明度 进行显示或隐藏*



> fadeIn() 显示
>
> fadeOut() 隐藏
>
> fadeToggle() 切换
>
> fadeTo(speed,opacity,fn) 指定透明度
>
> ​    参数2：opacity 透明度，一个0至1之间表示透明度的数字

 

# 其他



## 1.1  表单序列化

![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

serialize() 将表单中所有选中项拼凑成一个字符串。类似get请求参数

​    例如：username=jack&password=1234&gender=man&....

![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image003.gif) ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image005.jpg)

serializeArray()将表单中所有选中项拼凑一个json数组

​    ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image007.jpg)

​    ![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image009.jpg)

## 1.2  事件冒泡

![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image011.jpg)

 

event.stopPropagation()

 

 

## 1.3  浏览器默认动作

![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/01/clip_image013.jpg)

 

event.preventDefault() ;





# 小技巧

if语句里面后面加上return可以不做默认事件
