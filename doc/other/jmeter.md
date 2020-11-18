


### 启动
    .\jmeter.bat
### 新建计划
+ 新建线程组
+ 新建sampler中的http请求 
    填写服务器名称/ip 端口 http 请求方法 路径 编码
    parameters 增加参数(名称 值 是否编码)
+ 新建测试结果类型(监听器)
    - 用表格查看结果
    - 查看结果树
    - 聚合报告
    - 生成概要结果
    - 图形结果
    
### 运行并生成测试报告
+ 执行jmx并生成报告
    .\jmeter.bat -n -t [jmx文件路径] -l [jtl测试报告路径] -e -o [测试报告结果路径]
    比如  .\jmeter.bat -n -t D:\hrz\apache-jmeter-3.3\test\test.jmx -l D:\hrz\apache-jmeter-3.3\test\result.jtl -e -o C:\Users\Administrator\Desktop\jmeter  
+ 2 执行jtl生成html报告
    .\jmeter -g [jtl测试报告路径] -o [测试报告结果路径]




### 聚合报告解析

| 表头            | 含义                              |
| --------------- | -------------------------------- |
| samplers        | 次数                              |
| average         | 平均响应时间                       |
| median          | 中位数，也就是 50％ 用户的响应时间    |
| min             | 最小响应时间                       |
| max             | 最大响应时间                       |
| error           | 错误率                            |
| throughput      | 吞吐量 (请求/秒)                   |
| received Kb/sec | 每秒从服务器端接收到的数据量。       |
| sent Kb/sec     | 每秒从服务器端发送到的数据量。       |
| 90% Line        | 90％ 用户的响应时间                |





