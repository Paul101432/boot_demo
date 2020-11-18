# 基础

+ 配置相关

| 命令/配置 | 结果 | 备注 |
| --------- | ---- | ---- |
|   show variables like '%max_connections%';        |  查看最大连接数    |      |
|   set GLOBAL max_connections=1024;        |   临时设置最大连接数   |      |
|   my.cnf，在[mysqld]段中添加或修改 max_connections=1024       |  长期设置最大连接数    |      |

+ 主要函数

| 函数 | 说明 |
| ---- | ---- |
|CURRENT_DATE()CURDATE() |返回当前日期2018-09-19|
|LOCALTIME()LOCALTIMESTAMP()SYSDATE() |返回当前日期2018-09-19 20:57:43|
|DATEDIFF(d1,d2)|计算日期 d1->d2 之间相隔的天数|
|date_format(NOW(),'%Y-%m-%d %H:%i:%s')|格式化当前时间 返回 2016-01-16 22:23:00|
|STR_TO_DATE('2019-01-20 16:01:45', '%Y-%m-%d %H:%i:%s') |字符串转时间|
|FIND_IN_SET(str,strlist)|查询字段(strlist)中包含(str)的结果,strlist 字段名 参数以”,”分隔 如 (1,2,6,8,10,22)|
|  LOCATE(s1,s)   |   从字符串 s 中获取 s1 的开始位置   |
|  LCASE(s)    | 将字符串 s 的所有字母变成小写字母     |
| REPLACE(s,s1,s2)     |  将字符串 s2 替代字符串 s 中的字符串 s1    |
| UPPER(s)     |   将字符串转换为大写   |


-----------------------------------------


# 互主方案
	https://www.baidu.com/link?url=XDWdil3PQGBi1nlXIVCOHYC0r2Jb2eP9lGkPo6l8Yl6dIvQ9vtolWo9LViP7LgLIDGG-3nU68XGM2M8I6Br9dnOybXDBXrcj1a-g_Yi1OYW&wd=&eqid=b6017d9d00025346000000065e5882ba


## 1 期望
+ 减少单数据库压力
+ 应用集群的情况下 通过nginx转发 提升快速负载响应

## 2 条件
+ 原来没有执行过主从配置之类的单mysql
+ 提供互可访问的数据库账号密码
+ 提前关闭 并配置好需要同步的库跟数据

## 3 流程 
+ 关闭数据库 并其他处理好源数据的同步 
+ 编写两边的配置文件 my.cnf 
+ 启动两个mysql 执行获取同步参数
``` show master status```
+ 分别执行同步脚本
+ 测试

### 4 配置操作

#### 4.1 my.cnf 主要增加配置
```
#任意自然数n，只要保证两台MySQL主机不重复就可以了。
server-id=1
#server-id=2
#步进值auto_imcrement。一般有n台主MySQL就填n
auto_increment_increment=2
#auto_increment_increment=2

#起始值。一般填第n台主MySQL。此时为第一台主MySQL
auto_increment_offset=1
#auto_increment_offset=2

#开启二进制日志
log-bin=mysql-bin

#要同步的数据库，默认所有库,多个重复设置
# binlog-do-db 是数据库主服务器配置中,需要主从备份的数据库配置
# replicate-do-db 在自身已经是从服务器,又作为其它服务器的主服务器时候使用,用法与binlog-do-db一致
replicate-do-db=sd
replicate-do-db=sdlog 
binlog-do-db=sd
binlog-do-db=sdlog

#忽略mysql库【我一般都不写】
#binlog-ignore=mysql

#忽略information_schema库【我一般都不写】
#binlog-ignore=information_schema
```

#### 4.2 配置同步
+ 查看同步配置信息
``` show master status; ```

+ 查看同步结果 
``` SHOW SLAVE STATUS  ```

+ 同步脚本 

``` 
stop slave;
CHANGE MASTER TO MASTER_HOST='127.0.0.1',MASTER_PORT=7001, MASTER_USER='root', MASTER_PASSWORD='root', MASTER_LOG_FILE='mysql-bin.000001', MASTER_LOG_POS = 154;
start slave;
```

+ 只有当Slave_Io_Running和Slave_SQL_Running都为Yes时，才算配置成功。

### 5 问题回复
+ 关闭一个数据库,另一个库可以用
+ 重新开的库,会根据二进制同步
	
