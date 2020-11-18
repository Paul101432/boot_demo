

## 1 简介
### 1.1 是什么
    基于C++的键值对存储系统. 
### 1.2 特点
    存于内存.可持久化,单线程,支持主从同步,分布式
### 1.3 数据结构及常用方法
+ String: get、set、incr、decr、mget、SETEX 
+ Hash:hget,hset,hgetall
+ List: lpush,rpush,lpop,rpop,lrange
+ Set: sadd,spop,smembers,sunion 
+ Sorted Set: zadd,zrange,zrem,zcard

### 1.4 场景
+ String: 常规key-value缓存应用,存储数字进行增减,有效期
+ Hash: 存储部分变更数据，如用户信息等
+ List: 消息队列系统 取最新N个数据的操作
+ Set: 交集，并集，差集,  不重复,无序
+ Sorted Set: 对比set增加了权重排序


### 1.5 应用
    主页  http://redisdoc.com/
    目前Java端采用的是 jedis 
    客户端 http://docs.redisdesktop.com/en/latest/install/
    

