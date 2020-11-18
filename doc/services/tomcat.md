### tomcat
    (Apache Tomcat)[http://tomcat.apache.org/]
#### 1. 端口修改 编码修改-->  server.xml

#### 2. tomcat 调优
    设置JVM时 会跟设置jdk冲突
#### 2.1 jvm 限制   --> catalina.bat https://blog.csdn.net/lifetragedy/article/details/7708724
   ```
   rem jvm setting 
   set JAVA_OPTS=-server -Xms64m -Xmx64m -XX:PermSize=128m -XX:MaxPermSize=128m
   ```
#### 2.2 server.xml  

  https://blog.csdn.net/lifetragedy/article/details/7708724
  https://blog.csdn.net/jinwanmeng/article/details/7756591
  https://blog.csdn.net/cicada688/article/details/14451541

##### 2.2.1 Connector http://tomcat.apache.org/tomcat-9.0-doc/config/http.html#Common_Attributes

| 属性 | 默认值  | 含义 |
| -------------------- | --------------- | ------------------------------------------------------------ |
| enableLookups| false   | 是否开启DNS查找  |
| connectionTimeout| 60000(60s)  | 网络连接超时时间毫秒数   |
| maxThreads   | 200 | Tomcat使用线程来处理接收的每个请求。这个值表示Tomcat可创建的最大的线程数，即最大并发数 |
| acceptCount  | 100 | 当线程数达到maxThreads后，后续请求会被放入一个等待队列，这个acceptCount是这个队列的大小，如果这个队列也满了，就直接refuse connection |
| minProcessors| 10  | 最小空闲连接线程数   |
| maxProcessors| 75  | 并发处理的最大请求数 |
| useURIValidationHack | true| 校验url  |
| disableUploadTimeout | true| 是否禁止servlet容器在数据上载期间使用不同的、通常较长的连接超时 |
| compression  | | 是否对响应的数据进行压缩 |
| compressionMinSize   | 2048(2kb)   | 启用压缩的输出内容大小 b |  
| compressibleMimeType | json,xml,css... | 压缩类型 |


##### 2.2.2 Executor http://tomcat.apache.org/tomcat-9.0-doc/config/executor.html#Standard_Implementation

|   标签   |  默认值    |  含义    |
| ---- | ---- | ---- |
| maxThreads    | 200 | 该线程池可以容纳的最大线程数 |
| threadRenewalDelay | 5 | 线程池中所有线程的线程优先权 |
| prestartminSpareThreads | false | 在 Tomcat 初始化的时候就初始化 minSpareThreads 的参数值 |
| threadPriority | 5 | 线程池中所有线程的线程优先权 |
| daemon | true | 是否守护线程 |
| namePrefix | tomcat-exec- | 在JVM上，每个运行线程都可以有一个name 字符串。这一属性为线程池中每个线程的name字符串设置了一个前缀，Tomcat将把线程号追加到这一前缀的后面 |
| minSpareThreads | 25 | 初始化时创建的线程数 |
| maxIdleTime | 60000(1分钟) | 在Tomcat关闭一个空闲线程之前，允许空闲线程持续的时间(以毫秒为单位)。只有当前活跃的线程数大于minSpareThread的值，才会关闭空闲线程 |
| maxQueueSize | int 最大值 | 可在等待执行之前排队等待的可运行任务的最大数目。 |
    
    
    
## 注意
+ server.xml 有个软连接设置 true的话  独立存放的目录 WEB-INF是可以访问的 