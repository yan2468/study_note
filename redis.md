# redis

*高性能键值对（key-value）数据库*

*它通过提供多种键值数据类型来适应不同场景下的存储需求*

|      |      |
| ---- | ---- |
|      |      |
|      |      |
|      |      |
|      |      |





# redis的应用场景

> 缓存（数据查询、短连接、新闻内容、商品内容等等）。（**最多使用**）
>
> 分布式集群架构中的session分离。
>
> 聊天室的在线好友列表。
>
> 任务队列。（秒杀、抢购、12306等等）
>
> 应用排行榜。
>
> 网站访问统计。
>
> 数据过期处理（可以精确到毫秒）



# redis启动

①打开redis-server.exe ， 最小化到后台

②打开redis-cli.exe ，开始编写代码



# Redis数据类型 

| 数据类型     |                       |
| ------------ | --------------------- |
| **字符串**   | **字符串**            |
| **散列**     | **Hash类型**          |
| **类型**     | **List**              |
| **集合**     | **Set**               |
| **有序集合** | **SortedSet（zset）** |



## String类型

### 赋值

```sql
语法：
	SET key value     -- 单个键值
	MSET key value [key value …]  -- 多个键值
eg：
	set test 123
	mset k1 v1 k2 v2 k3 v3
```



### 获取值

```sql
语法：
	GET value    -- 单个键值
	MGET key [key …]   -- 多个键值
eg： 
	get test
	mget k1 k3
```



### 取值并赋值

```sql
语法：
	GETSET key value
eg:
	getset s2 222
```



### 删除

```sql
语法：
	DEL key
eg:
	del test
```



### 数值增减

*当存储的字符串是整数时，Redis提供了一个实用的命令INCR，其作用是让当前键值递增，并返回递增后的值。*

```sql
语法：
	INCR key   -- 加1
	INCRBY key 指定数字  -- 加指定数
	DECR key   -- 减1
	DECRBY key 指定数字  -- 减指定数
```



### 向尾部追加值 

*APPEND的作用是向键值的末尾追加value。如果键不存在则将该键的值设置为value，即相当于 SET key value。返回值是追加后字符串的总长度。*

```sql
语法：
	APPEND key value
eg:
	127.0.0.1:6379> append str " world!"
	(integer) 12
	127.0.0.1:6379> get str 
	"hello world!"
```



### 获取字符串长度

*STRLEN命令返回键值的长度，如果键不存在则返回0。*

```sql
语法：
	STRLEN key
eg:
    127.0.0.1:6379> strlen str 
    (integer) 0
    127.0.0.1:6379> set str hello
    OK
    127.0.0.1:6379> strlen str 
    (integer) 5

```





## Hash类型

*hash叫散列类型，它提供了字段和字段值的映射。字段值只能是字符串类型，不支持散列类型、集合类型等其它类型。*

​																								 key                                field                           value

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210728184546944.png" alt="image-20210728184546944" style="zoom:80%;" />



###  赋值

*HSET命令不区分插入和更新操作，当执行插入操作时HSET命令返回1，当执行更新操作时返回0。*

```sql
语法：
	HSET key field value	-- 	一次只能设置一个字段值
	HMSET key field value [field value ...]	  -- 	一次可以设置多个字段值
	HSETNX key field value   -- 	当字段不存在时赋值，类似HSET，区别在于如果字段存在，该命令不执行任何操作
	
eg:
	127.0.0.1:6379> hset user username zhangsan 
	(integer) 1
	127.0.0.1:6379> hmset user age 20 username lisi 
	OK
	127.0.0.1:6379> hsetnx user age 30	 --  如果user中没有age字段则设置age值为30，否则不做任何操作
	(integer) 0

```



### 获取值

```sql
语法：
	HGET key field  	 -- 一次只能获取一个字段值
	HMGET key field [field ...]	 --  一次可以获取多个字段值
	HGETALL key  -- 	获取所有字段值
	
eg:
	127.0.0.1:6379> hget user username
    "zhangsan"
    127.0.0.1:6379> hmget user age username
    1) "20"
    2) "lisi"
    127.0.0.1:6379> hgetall user
    1) "age"
    2) "20"
    3) "username"
    4) "lisi"

```



### 删除

*可以删除一个或多个字段，返回值是被删除的字段个数*

```sql
语法：
	HDEL key field [field ...]
eg:
    127.0.0.1:6379> hdel user age
    (integer) 1
    127.0.0.1:6379> hdel user age name
    (integer) 0
```



### 增加数字

```sql
语法：
	HINCRBY key field 指定数字
	
eg:
    127.0.0.1:6379> hincrby user age 2	将用户的年龄加2
    (integer) 22
    127.0.0.1:6379> hget user age		获取用户的年龄
    "22“
```



### 判断字段是否存在

```sql
语法：
	HEXISTS key field
eg:
	127.0.0.1:6379> hexists user age		查看user中是否有age字段
    (integer) 1
    127.0.0.1:6379> hexists user name	查看user中是否有name字段
    (integer) 0

```



### 只获取字段名或字段值

```sql
语法：
    HKEYS key
    HVALS key
eg:
	127.0.0.1:6379> hmset user age 20 name lisi -- 设置
    OK
    127.0.0.1:6379> hkeys user  -- 获取字段
    1) "age"
    2) "name"
    127.0.0.1:6379> hvals user  -- 获取字段值
    1) "20"
    2) "lisi"
```



### 获取字段数量

```sql
语法：
	HLEN key
eg：
    127.0.0.1:6379> hlen user
    (integer) 2
```





## List类型

> ArrayList：使用数组方式存储数据，所以根据索引**查询数据速度快**，而**新增或者删除元素时需要设计到位移操作，所以比较慢**。 
>
> LinkedList：使用**双向链表方式**存储数据，每个元素都记录前后元素的指针，所以**插入、删除数据时**只是更改前后元素的指针指向即可，**速度非常快**。然后通过下标**查询元素时**需要从头开始索引，所以**比较慢**，但是**如果查询前几个元素或后几个元素速度比较快**。



> 列表类型（list）可以存储一个有序的字符串列表，常用的操作是向**列表两端添加元素**，或者**获得列表的某一个片段**。
>
> ​       **列表类型内部是使用双向链表（double linked list**）实现的，所以向列表两端添加元素的时间复杂度为0(1)，获取越接近两端的元素速度就越快。这意味着即使是一个有几千万个元素的列表，获取头部或尾部的10条记录也是极快的。





### 向列表两端增加元素

```sql
语法：
	LPUSH key value [value ...] -- 	向列表左边增加元素
	RPUSH key value [value ...] -- 	向列表右边增加元素
	
eg:
	127.0.0.1:6379> lpush list:1 1 2 3
	(integer) 3
	127.0.0.1:6379> rpush list:1 4 5 6
	(integer) 3
```



### 查看列表

*LRANGE命令是列表类型最常用的命令之一，获取列表中的某一片段，将返回start、stop之间的所有元素（包含两端的元素），索引从0开始。索引可以是负数，如：“-1”代表最后边的一个元素。一般查询全部的时候可以使用（0，-1）*

```sql
语法：
	LRANGE key start stop
eg：	
    127.0.0.1:6379> lrange list:1 0 2
    1) "2"
    2) "1"
    3) "4"
```



### 从列表两端弹出元素

*LPOP命令从列表左边弹出一个元素，会分两步完成：*

*第一步是将列表左边的元素从列表中移除*

*第二步是返回被移除的元素值。*

```sql
语法：
	LPOP key
	RPOP key
eg：
	127.0.0.1:6379> lpop list:1
	"3"
    127.0.0.1:6379> rpop list:1
    "6"
```



### 获取列表中元素的个数

```sql
语法：
	LLEN key
eg:
    127.0.0.1:6379> llen list:1
    (integer) 2
```



### 删除列表中指定的值

> LREM命令会删除列表中前count个值为value的元素，返回实际删除的元素个数。根据count值的不同，该命令的执行方式会有所不同： 
>
> - 当count>0时， LREM会从列表左边开始删除。
>
> - 当count<0时， LREM会从列表后边开始删除。
>
> - 当count=0时， LREM删除所有值为value的元素。 

```sql
语法：
	LREM key count value
```



### 获得/设置指定索引的元素值

```sql
语法：
	LINDEX key index  -- 获得指定索引的元素值
	LSET key index value  -- 设置指定索引的元素值
eg:	
	127.0.0.1:6379> lindex l:list 2
	"1"

    127.0.0.1:6379> lset l:list 2 2
    OK
    127.0.0.1:6379> lrange l:list 0 -1
    1) "6"
    2) "5"
    3) "2"
    4) "2"
```



### 只保留列表指定片段

*指定范围和LRANGE一致*

```sql
语法：
	LTRIM key start stop
eg:
    127.0.0.1:6379> lrange l:list 0 -1
    1) "6"
    2) "5"
    3) "0"
    4) "2"
    127.0.0.1:6379> ltrim l:list 0 2
    OK
    127.0.0.1:6379> lrange l:list 0 -1
    1) "6"
    2) "5"
    3) "0"
```



### 向列表中插入元素

*该命令首先会在列表中从左到右查找值为pivot的元素，然后根据第二个参数是BEFORE还是AFTER来决定将value插入到该元素的前面还是后面。*

```sql
语法：
	LINSERT key BEFORE|AFTER pivot value
eg:
    127.0.0.1:6379> lrange list 0 -1
    1) "3"
    2) "2"
    3) "1"
    127.0.0.1:6379> linsert list after 3 4
    (integer) 4
    127.0.0.1:6379> lrange list 0 -1
    1) "3"
    2) "4"
    3) "2"
    4) "1"
```



### 将元素从一个列表转移到另一个列表中

```sql
语法：
	RPOPLPUSH source destination
	
eg:
    127.0.0.1:6379> rpoplpush list newlist 
    "1"
    127.0.0.1:6379> lrange newlist 0 -1
    1) "1"
    127.0.0.1:6379> lrange list 0 -1
    1) "3"
    2) "4"
    3) "2"
```





## Set类型

> 集合类型的常用操作是**向集合中加入或删除元素、判断某个元素是否存在**等，由于集合类型的Redis内部是使用值为空的散列表实现，所有这些操作的时间复杂度都为0(1)。 
>
> Redis还提供了多个集合之间的**交集、并集、差集**的运算。



### 运算命令

#### 差集A - B

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210728194113463.png" alt="image-20210728194113463" style="zoom:67%;" />

```sql
语法：
	SDIFF key [key ...]
eg:
    127.0.0.1:6379> sadd setA 1 2 3
    (integer) 3
    127.0.0.1:6379> sadd setB 2 3 4
    (integer) 3
    127.0.0.1:6379> sdiff setA setB 
    1) "1"
    127.0.0.1:6379> sdiff setB setA 
    1) "4"
```



#### 交集A ∩ B

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210728194124963.png" alt="image-20210728194124963" style="zoom:67%;" />

```sql
语法：
	SINTER key [key ...]
eg:
    127.0.0.1:6379> sinter setA setB 
    1) "2"
    2) "3"
```



#### 并集A ∪ B

<img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210728194132977.png" alt="image-20210728194132977" style="zoom:67%;" />

```sql
语法：
	SUNION key [key ...]
eg:
    127.0.0.1:6379> sunion setA setB
    1) "1"
    2) "2"
    3) "3"
    4) "4"
```



### 增加/删除元素

```sql
语法：
	SADD key member [member ...]	
	SREM key member [member ...]
eg:
  127.0.0.1:6379> sadd set a b c  
  *(integer) 3  
  127.0.0.1:6379> sadd set a  
  *(integer) 0  
  127.0.0.1:6379> srem set c d
  *(integer) 1  
```

 

### 获得集合中的所有元素

```sql
语法：
	SMEMBERS key*
eg:
    127.0.0.1:6379> smembers set  
    1) "b"  
    2) "a”  
```

 

### 判断元素是否在集合中

```sql
语法：
	SISMEMBER key member*
eg:
    127.0.0.1:6379> sismember set a  
    *(integer) 1  
    127.0.0.1:6379> sismember set h  
    *(integer) 0  
```



### 获得集合中元素的个数

```sql
语法：
	SCARD key*
eg:
    127.0.0.1:6379> smembers setA   
    *1) "1"  
    2) "2"  
    3) "3"  
    127.0.0.1:6379> scard setA   
    *(integer) 3  
```



### 从集合中弹出一个元素

*注意：由于集合是无序的，所有SPOP命令会从集合中随机选择一个元素弹出*

```sql
语法：
	SPOP key
eg:
	127.0.0.1:6379> spop setA 
	*"1"
```





## SortedSet类型zset

> ​     在集合类型的基础上，有序集合类型为集合中的每个元素都关联一个分数（权重， 是数字类型），这使得我们不仅可以完成插入、删除和判断元素是否存在在集合中，还能够获得分数最高或最低的前N个元素、获取指定分数范围内的元素等与分数有关的操作。 



### 增加元素

*向有序集合中加入一个元素和该元素的分数，如果该元素已经存在则会用新的分数替换原有的分数。返回值是新加入到集合中的元素个数，不包含之前已经存在 的元素。*

```sql
语法：
	ZADD key score member [score member ...]*

  127.0.0.1:6379> zadd scoreboard 80  zhangsan 89 lisi 94 wangwu   
  *(integer) 3  
  127.0.0.1:6379> zadd scoreboard 97  lisi   
  *(integer) 0 
```

 

###  获取元素的分数

```sql
语法：
	ZSCORE key member
eg:
    127.0.0.1:6379> zscore scoreboard lisi    
    *"97"  
```

 

###  删除元素

*移除有序集key中的一个或多个成员，不存在的成员将被忽略。*

*当key存在但不是有序集类型时，返回一个错误。*

```sql
语法：
	ZREM key member [member ...]
eg:
  127.0.0.1:6379> zrem scoreboard lisi  
  *(integer) 1  
```

 

### 获得排名在某个范围的元素列表

获得排名在某个范围的元素列表 

Ø 按照元素分数**从小到大**的顺序返回索引从start到stop之间的所有元素（包含两端的元素）

 

```sql
语法：
	ZRANGE key start stop [WITHSCORES]             
eg:
  127.0.0.1:6379> zrange scoreboard 0 2  
  *1) "zhangsan"  
  2) "wangwu"  
  3) "lisi“  
```

 

Ø 按照元素分数**从大到小**的顺序返回索引从start到stop之间的所有元素（包含两端的元素）



```sql
语法：
	ZREVRANGE key start stop [WITHSCORES] 

    127.0.0.1:6379> zrevrange scoreboard 0  2  
    *1) " lisi "  
    2) "wangwu"  
    3) " zhangsan “  
```

 

如果需要**获得元素的分数**的可以在命令尾部加上**WITHSCORES**参数 

```sql
  127.0.0.1:6379> zrange scoreboard 0 1  WITHSCORES  
  *1) "zhangsan"  
  2) "80"  
  3) "wangwu"  
  4) "94"  
```



## 获得指定分数范围的元素

```sql
语法：
	ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count]*
eg:
  127.0.0.1:6379> zrangebyscore scoreboard  90 97 WITHSCORES*  
  *1) "wangwu"  
  *2) "94"  
  *3) "lisi"  
  *4) "97"
  127.0.0.1:6379> zrangebyscore  scoreboard 70 100 limit 1 2  
  *1) "wangwu"  
  *2) "lisi" 
```

 

### 增加某个元素的分数

返回值是更改后的分数 

```sql
语法：
	ZINCRBY key increment member*
eg:
  127.0.0.1:6379> zincrby scoreboard 4  lisi   
   *"101“  
```

 

 

### 获得集合中元素的数量 

```sql
语法：
	ZCARD key*
eg:
  127.0.0.1:6379> ZCARD scoreboard  
   *(integer) 3  
```

 

###  获得指定分数范围内的元素个数 

```sql
语法：
	ZCOUNT key min max
eg:
  127.0.0.1:6379> ZCOUNT scoreboard  80 90  
  *(integer) 1  
```

 

### 按照排名范围删除元素 

```sql
语法：
	ZREMRANGEBYRANK key start stop
eg:
  	127.0.0.1:6379> zremrangebyrank  scoreboard 0 1  
  	*(integer) 2
  	127.0.0.1:6379> zrange scoreboard 0  -1  
  	*1) "lisi"  
```



###  按照分数范围删除元素

```sql
语法：
	ZREMRANGEBYSCORE key min max
eg:
  127.0.0.1:6379> zadd scoreboard 84  zhangsan     
  (integer) 1  
  127.0.0.1:6379> ZREMRANGEBYSCORE  scoreboard 80 100  
  (integer) 1  
```

 

### 获取元素的排名 

Ø 从小到大

```sql
语法：
	ZRANK key member*
eg:
  	127.0.0.1:6379> ZRANK scoreboard lisi   
  	(integer) 0  
```

 

Ø 从大到小

```sql
语法：
	ZREVRANK key member*

  	127.0.0.1:6379> ZREVRANK scoreboard  zhangsan   
  	(integer) 1  
```



## key命令

### 设置key的生存时间

> *EXPIRE key seconds*         	 *设置key**的生存时间（单位：秒）key**在多少秒后会自动删除* 
>
> *TTL key*                           	   *查看key剩余的生存时间*  
>
> *PERSIST key*                  	   *清除生存时间*   
>
> *PEXPIRE key milliseconds*    *生存时间设置单位为：毫秒*  

```sql
eg：
192.168.101.3:7002> set test 1		设置test的值为1
OK
192.168.101.3:7002> get test			获取test的值
"1"
192.168.101.3:7002> EXPIRE test 5	设置test的生存时间为5秒
(integer) 1
192.168.101.3:7002> TTL test			查看test的生于生成时间还有1秒删除
(integer) 1
192.168.101.3:7002> TTL test
(integer) -2
192.168.101.3:7002> get test			获取test的值，已经删除
(nil)
```



### 1.1.0keys

*返回满足给定pattern 的所有key*

```sql
eg:
    redis 127.0.0.1:6379> keys mylist*  -- 输出以mylist开头的key
      1) "mylist"  
      2) "mylist5"  
      3) "mylist6"  
      4) "mylist7"  
      5) "mylist8"  
```

 

 

### 1.1.1 exists

*确认一个 key 是否存在*

```sql
示例：从结果来看，数据库中不存在HongWan 这个key，但是age 这个key 是存在的

  redis 127.0.0.1:6379> exists HongWan  
  (integer) 0  
  redis 127.0.0.1:6379> exists age  
  (integer) 1  
```

  

 

### 1.1.2 del

*删除一个key*

```sql
eg:
	redis 127.0.0.1:6379> del age  
	(integer) 1  
	redis 127.0.0.1:6379> exists age  
	(integer) 0  
```



### 1.1.3 rename

*重命名 key*

```sql
示例：age 成功的被我们改名为age_new 了

  redis 127.0.0.1:6379[1]> keys 
  *1) "age"  
  redis 127.0.0.1:6379[1]> rename age  age_new  
  *OK  
  redis 127.0.0.1:6379[1]> keys 
  *1) "age_new"   
```

 

### 1.1.4 type

*返回值的类型*

> 示例：这个方法可以非常简单的判断出值的类型
>
> <img src="C:\Users\HBY\AppData\Roaming\Typora\typora-user-images\image-20210728204948414.png" alt="image-20210728204948414" style="zoom:150%;" />





# Redis持久化方案

*RDB方式的持久化是**通过快照**（snapshotting）完成的，当**符合一定条件**时Redis会自动将内存中的数据**进行快照并持久化到硬盘**。*

*RDB是Redis默认采用的持久化方式。*

 

> save  900 1     表示15分钟（900秒钟）内至少1个键被更改则进行快照。
>
> save  300 10    表示5分钟（300秒）内至少10个键被更改则进行快照。
>
> save  60 10000 



**通过RDB方式实现持久化，一旦Redis异常退出，就会丢失最后一次快照以后更改的所有数据。**

**如果数据很重要以至于无法承受任何损失，则可以考虑使用AOF方式进行持久化**👇👇。

 

##  AOF持久化

*默认情况下Redis没有开启AOF（append only file）方式的持久化，【操作一次就写一次数据】*



Ø 可以通过**修改redis.conf配置文件中的appendonly参数开启**

  `appendonly yes`  



开启AOF持久化后每执行一条会更改Redis中的数据的命令，Redis就会将该命令写入硬盘中的AOF文件。

