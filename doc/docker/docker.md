

## docker 
+ 链接
http://www.jfinal.com/share/1754
https://gitee.com/superbigfu/jfinal_docker_test?_from=gitee_search





## dockerfile 举例

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
