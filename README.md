# boot_demo
jfinal/springboot 演示


## TODO 
+ 基于jboot/springcloud的微服务演示
+ 工作流演示
    https://mvnrepository.com/search?q=snakerflow
    https://github.com/snakerflow-starter/snakerflow-spring-boot-starter
    工作流需求
    + 支持多节点流程 至少1
    + 节点操作:通过/驳回(带描述)/转发/前置后置/
    + 支持会签
    + 支持或签
    + 支持接口触发节点操作
    + 操作留痕
    + 支持加签


## docker 
+ 链接
http://www.jfinal.com/share/1754
https://gitee.com/superbigfu/jfinal_docker_test?_from=gitee_search
+ 
+ linux 修改格式 
    + vi 文件名 
    + 命令行模式输入 :set fileformat=unix
    + w
    + wq!
## 简单web容器化
```

# 解压服务包
tar -zxvf  jf-1.0.tar.gz
# 进入服务包 
cd jf
# dockerfile把当前服务打进本地docker
build.sh  
# 启动运行
docker run -it -d --name jf -p 11000:11000 jf:v1.0 
# 导出docker镜像
docker save 58e95221397d > /demo/jf_v1.0.tar   ##导出镜像
# 导入docker镜像
docker load < /demo/jf_v1.0.tar          ##导入镜像

```
