# css

CSS 指层叠样式表 (Cascading Style Sheets)

- 样式定义如何显示 HTML 元素

- 样式通常存储在样式表中

- 把样式添加到 HTML 4.0 中，是为了解决内容与表现分离的问题

- 外部样式表可以极大提高工作效率

- 外部样式表通常存储在 CSS 文件中

- 多个样式定义可层叠为一

  

## css语法

> ```css
> h1 {coloe:red;font-size:14px;}
> ```
>
> ​		↑			↑        ↑
>
> ​	选择器     属性   值

![](C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210715183959472.png)



![img](file:///C:/Users/HBY/AppData/Local/Temp/msohtmlclip1/02/clip_image002.jpg)

> 书写注意事项
>
> 1. 如果值为若干单词，则要给值加引号
>
> 2. 多个声明之间使用分号(;)分开
>
> 3. css对大小写不敏感,如果涉及到与html文档一起使用时，class与id名称对大小写敏感





## 导入css方式

### 内联样式表

```css
<div style="border:1px solid black">你好</div>
```

> 一般情况下，这种方式只有在一个标签上只应用一次样式时才会使用



### 内部样式表

```css
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			div{color:red}
		</style>
	</head>
	<body>
		
		<div style="border: 1px solid black">
			你好
		</div>
	</body>
</html>
```

> 这种方式，样式只适合应用于一个页面



### 外部样式表

> 如果想要在多个页面使用同一个样式表，可以使用外部样式表来导入
>
> 我们可以在html页面上使用<link>标签来导入外部样式表。

```css
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="mystyle.css"/>
	</head>
	<body>
		<div style="border: 1px solid black">
			你好
		</div>
	</body>
</html>

/*
浏览器会从mystyle.css文件中读取样式，并对页面上的html进行修饰。*/
```

### **优先级问题**

​      内联样式表>内部样式表>外部样式表

### @import导入

```css
<html>
	<head>
		<style type="text/css">
			@import "mystyle.css";
		</style>
	</head>
	<body>
		<div >
			你好
		</div>
	</body>
</html>
```



> **关于@import与引用外部样式表的区别:**
>
> 1. @import这种方式只有firefox支持，而ie不支持。
>
>    2.@import这种方式导入的css，会在整个页面加载后，才会加载样式。如果网络不好情况下，会先看到无样式修饰的页面，闪烁一下后，才会看到有样式修饰的页面。
>
>  而使用外部样式表，会先装载样式表，这样看到的就是有样式修饰的页面。
>
>   3.@import不支持通过javascript修改样式，而link支持。





## CSS选择器

​    *css选择器主要是用于选择需要添加样式的html元素。*



### id选择器

*Id选择器使用#引入，它引用的是id属性中的值。*

```css
<html>
	<head>
		<style type="text/css">
			#d{
				border: 1px solid black;
				color: red;
			}
		</style>
	</head>
	<body>
		<div id="d">
			你好
		</div>
	</body>
</html>
```



### 类选择器

*类选择器使用时,需要在类名前加一个点号(.)*

```css
<html>
	<head>
		<style type="text/css">
			.d{
				border: 1px solid black;
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="d">
			你好
		</div>
	</body>
</html>
```



### 元素选择器

*这是最常见的选择器，简单说，文档中的元素就是选择器*

```css
<html>
	<head>
		<style type="text/css">
			div{
				border: 1px solid black;
				color: red;
			}
		</style>
	</head>
	<body>
		<div>
			你好
		</div>
	</body>
</html>
```



### 属性选择器

*如果需要选择有某个属性的元素，而不论属性是什么，可以使用属性选择器*

> 如下，type=text的元素将会被改变

```css
<html>
	<head>
		<style type="text/css">
			input[type='text']{
				border-left-style: none;
				border-right-style: none;
				border-top-style: none;
				border-bottom-style: solid;
			}
		</style>
	</head>
	<body>
		<input type="text" name="username" value="请输入姓名" />
		<br>
		<br>
		<input type="password" name="password"  />
	</body>
</html>

```



### 伪元素选择器

*css伪类用于向某些选择器添加特殊效果。*

```css
<html><!-- 伪元素选择器 -->
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			a:link{/* 静止状态 */
				color: blue;
			}
			a:hover{/* 悬浮状态 */
				color: red;
			}
			a:active{/* 点击 */
				color: yellow;
			}
			a:visited{
				color: green;
			}
		</style>
	</head>
	<body>
		<a href="#"> 点击我吧</a>
	</body>
</html>
```



## CSS属性

*Css字体属性定义文本的字体系列，大小，加粗，风格(如斜体)和变形(如小型大写字母)*

### 字体

*Css字体属性定义文本的**字体系列**，大小，加粗，风格(如斜体)和变形(如小型大写字母)*

> 常用属性:
>
> 
>
> - font:简写属性，作用是把所有针对字体的属性设置在一个声明中。
>
> - font-family:定义字体系列
>
> - font-size:定义字体的尺寸
>
> - font-style:定义字体风格

 

### 文本

*CSS 文本属性可定义**文本的外观**。通过文本属性，您可以改变文本的颜色、字符间距，对齐文本，装饰文本，对文本进行缩进，等等。*

> 常用属性
>
> - color:定义文本颜色
>
> - text-align:定义文本对齐方式
>
> - letter-spacing:定义字符间隔
>
> - word-spacing:定义字间隔

 

### 背景

CSS 允许应用纯色作为**背景**，也允许使用背景图像创建相当复杂的效果。CSS 在这方面的能力远远在 HTML 之上。

> 常用属性:
>
> - background:简写属性，作用是将背景属性设置在一个声明中
>
> - background-color:定义背景颜色
>
> - background-image:定义背景图片
>
> - background-position:定义背景图片的起始位置
>
> - background-repeat:定义背景图片是否及如何重复。

### 尺寸

CSS 尺寸 (Dimension) 属性允许你控制**元素的高度和宽度**。

> 常用属性:
>
> - width:设置元素的宽度
>
> - height:设置元素的高度     

### 列表

CSS 列表属性允许你放置、改变列表项标志，或者将图像作为列表项标志。

> 常用属性:
>
> - list-style:简写属性。用于把所有用于列表的属性设置于一个声明中。
>
> - list-style-image:定义列表项标志为图象
>
> - list-style-position:定义列表项标志的位置
>
> - list-style-type:定义列表项标志的类型。

### 表格

CSS 表格属性可以帮助您极大地改善**表格的外观**



### 轮廓

轮廓（outline）是绘制于元素周围的一条线，位于边框边缘的外围，可起到**突出元素**的作用。

CSS outline 属性规定元素轮廓的样式、颜色和宽度。

> 常用属性:
>
> - outline:在一个声明中设置所有的轮廓属性
>
> - outline-color:定义轮廓的颜色
>
> - outline-style:定义轮廓的样式
>
> - outline-width:定义轮廓的宽度

 

 

### 定位

CSS 定位 (Positioning) 属性允许你对元素进行定位。

定位的基本思想很简单，它允许你定义元素框相对于其正常位置应该出现的位置，或者相对于父元素、另一个元素甚至浏览器窗口本身的位置

CSS 有三种基本的定位机制：普通流、浮动和绝对定位。

> 常用属性:
>
> - position:把元素放置到一个静态的,相对的，绝对的，或固定的位置中。
>
> - top:定义了定位元素的上外边距边界与其包含块上边界之间的偏移量
>
> - right: 定义了定位元素右外边距边界与其包含块右边界之间的偏移
>
> - left: 定义了定位元素左外边距边界与其包含块左边界之间的偏移
>
> - bottom: 定义了定位元素下外边距边界与其包含块下边界之间的偏移。



### 分类

CSS 分类属性允许你控制如何**显示元素**，设置图像显示于另一元素中的何处，相对于其正常位置来定位元素，使用绝对值来定位元素，以及元素的可见度。

>  常用属性
>
> - clear:设置一个元素的侧面是否允许其它的浮动元素
>
> - float:定义元素在哪个方向浮动
>
> - cursor:当指向某元素之上时显示的指针类型
>
> - display:定义是否及如何显示元素
>
> - visibility:定义元素是否可见或不可见。



## CSS框模型

### 盒子模型

CSS 框模型 (Box Model) 规定了元素框处理元素内容、内边距、边框和 外边距的方式。

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210715191216678.png" alt="image-20210715191216678" style="zoom:50%;" />

> 元素框的最内部分是实际的内容，直接包围内容的是内边距。内边距呈现了元素的背景。内边距的边缘是边框。边框以外是外边距，外边距默认是透明的，因此不会遮挡其后的任何元素



#### 边框 (border)

*元素的边框 (border) 是围绕元素内容和内边距的一条或多条线。*

*CSS border 属性允许你规定元素边框的样式、宽度和颜色。*

> 常用属性:
>
> - border:简写属性，用于把针对于四个边的属性设置在一个声明。
>
> - border-color:简写属性，定义元素边框中可见部分的颜色，或为四个边分别设置颜色。
>
> - border-style:用于定义所有边框的样式，或者单独为各边设置边框样式。
>
> - border-width:简写属性，用于为元素的所有边框设置宽度，或则单独地为各边边框设置宽度
>
> - border-top:简写属性，用于把上边框的所有属性设置到一个声明中
>
> - border-right:简写属性，用于把右边框所有属性设置到一个声明中
>
> - border-bottom:简写属性，用于把下边框的所有属性设置到一个声明中
>
> - border-left:简写属性，用于把左边框的所有属性设置到一个声明中。



#### 外边距（margin）

*围绕在元素边框的空白区域是外边距。设置外边距会在元素外创建额外的“空白”。*

*设置外边距的最简单的方法就是使用 margin 属性，这个属性接受任何长度单位、百分数值甚至负值。*

> 常用属性:
>
> - margin:简写属性，在一个声明中设置所有外边距属性
>
> - margin-top:定义元素的上外边距
>
> - margin-right:定义元素的右外边距
>
> - margin-bottom:定义元素的下外边距
>
> - margin-left定义元素的左外边距
>
> 
>
> 注意:在使用margin来定义所有外边距时，可以使用值复制。
>
> - 如果缺少左外边距的值，则使用右外边距的值。
>
> - 如果缺少下外边距的值，则使用上外边距的值。
>
> - 如果缺少右外边距的值，则使用上外边距的值。



#### 内边距（padding）

*素的内边距在边框和内容区之间。控制该区域最简单的属性是 padding 属性。*

*CSS padding 属性定义元素边框与元素内容之间的空白区域。*

> 常用属性:
>
> -  padding:简写属性，作用是在一个声明中设置元素的所有内边距属性
>
> - padding-top:定义元素的上内边距
>
> - padding-right:定义元素的右内边距
>
> - padding-bottom:定义元素的下内边距
>
> - padding-left:定义元素的左内边距。





## 块级、行级（内）元素

块级元素：div,ul,li,p,h1-h6  (从上到下顺序)

行内元素：a,i,s,span,input,img (从左到右顺序)         没有宽高（如果需要设置宽高则需要转换为块级元素）



### 块级元素变为行级(内)元素

```css
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			div{
				display: inline;   /* 将块级元素改变为行(内)级元素 */
				}	
```

### 行级(内)元素变为块级元素

```css
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			div{
				display: block;   /* 行级元素变为块级 */
				}	
```

## 元素整体居中显示

```css
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;   /*初始化*/
			}
			div{
				 margin:0 auto ;
				 }
```

## display属性

*用来设置元素的类型及隐藏的*

> 1、none 元素隐藏且不占位置
> 2、block 元素以块元素显示
> 3、inline 元素以内联元素显示
> 4、inline-block 元素以内联块元素显示
> 5、内联块的margin不会产生合并问题

## 浮动元素



## 浮动

*元素的水平方向浮动*

```css
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
		div{
    		float: left;      /* 脱离标准流,浮动到页面左上角 */ 
            /* float: right; */       /* 脱离标准流,浮动到页面右上角 */ 
		}
```

> 浮动元素之后的元素将围绕它。



> 如果你把几个浮动的元素放到一起，如果有空间的话，它们将彼此相邻，可设置间距（外边距）。



## 清除浮动

*消除浮动影响，即能够不让子类div超出父类div的边框*

*有父类的元素，用了浮动会跳出父类（两个div嵌套，里面div用了浮动就会跳出外层div的控制）*

> 解决办法：
>
> 方法1 为父类内部最后再添加一个空的div,class设置为clear。  eg: clear: both;  最后留在父类元素内的元素清除所有浮动【right消除右边的，left消除左边的】
>
> 方法2 为父类设置一个合适的高度。  eg:将父类元素的高、宽变大，恰好包住
>
> 方法3 为父类设置overflow属性。  eg:overflow: scroll; (设置一个滑动框)

```css
<!DOCTYPE html>
<html>								
	<head>							
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
		div {
			margin:10px;
			padding:5px;
		}
		#father {
			border:1px #000 solid;
			/*方法2 为父类设置一个合适的高度*/
			/* height: 200px; */
			
			/*方法3 为父类设置overflow属性*/
			overflow: scroll;
			
		}
		.layer01 {
			border:1px #F00 dashed;
			float:left;
		 
		}
		.layer02 {
			border:1px #00F dashed;
			float:left;
		
		}
		.layer03 {
			border:1px #060 dashed;
			float:left;
		
		}
		/* .layer04{
			clear: both;
		} */
		
		
		
		
		</style>
	</head>
	<body>
		<h1>浮动专项练习(下面的元素浮动对上面的元素无影响)</h1>
		<div id="father">
		  <div class="layer01"><img src="img/photo-1.jpg" alt="日用品" /></div>
		  <div class="layer02"><img src="img/photo-2.jpg" alt="图书" /></div>
		  <div class="layer03"><img src="img/photo-3.jpg" alt="鞋子" /></div>
		
		 <!--方法1 为父类内部最后再添加一个空的div,class设置为clear -->
		 <!-- <div class="layer04"> </div> -->
			
		</div>
		
		<div class="layer05">浮动的盒子可以向左浮动，也可以向右浮动，直到它的外边缘碰到包含框或另一个浮动盒子为止。本网页中共有三个图片，分别代表日用品图片、图书图片和鞋子图片。这里使用这三个图片和本段文字来演示讲解浮动在网页中的应用，根据需要图片所在的div分别向左浮动、向右浮动，或者不浮动。</div>
		
	</body>
</html>

```



## 元素内文本水平居中

```css
li{text-align: center;}
```



## 元素内文本垂直居中

```css
li{
    height: 50px;
    line-height: 50px;
}
```



##  删除链接下划线 

```css
text-decoration: none;
```



## 定位

- 相对定位   *相对定位参照物:相对于它自已原来的位置,不脱离标准流，原来位置不会被其他元素占领。*

```css
div{
    position: relative;
	left: 50px;/* 距离自己之前的位置的左边框移动50像素 */
	top:20px;/* 距离自己之前的位置的上边框移动20像素 */
}	
				
```



- 绝对定位   *参照物时浏览器，并且脱离标准流，原来位置会被其他元素占领。*

```css
div{
    position: absolute;
	left: 100px;/* 距离最上左边框移动100像素 */
	top:100px;/* 距离最上上边框移动100像素 */
}	
```



- 固定定位   无论怎么滑动都固定在此位置

- ```css
  position: fixed;
  ```



### 三种定位的比较

| 定位方式 | 参照物                                                    | 是否脱离标准流 |
| -------- | --------------------------------------------------------- | -------------- |
| 相对定位 | 自己原来的位置                                            | 不脱离         |
| 绝对定位 | （1）默认浏览器                                           | 脱离           |
|          | （2）如果它的父亲已经定位过，那么参照物就变成了父亲       |                |
|          | （3）任何一个祖先定位过，则参照物就变成该祖先元素         |                |
|          | （4）如果多个祖先元素都定位过，则参照物是最近那个祖先元素 |                |
| 固定定位 | 浏览器                                                    | 脱离           |





# 设计注意事项

 **先全局设计,再局部  ； 从外到内，从上到下 ， 同一层级优先**











------

#### 【笔试面试题】

\1.     css基本语法是什么

\2.     css导入方式有几种

\3.     外部导入与@import有什么区别

\4.     Css选择器的作用是什么,并说出常见三种选择器。

\5.     display=none与visibility=hidden有什么区别

------







