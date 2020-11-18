
## 1 简介
+ grafana 仪表盘和图形编辑器
+ Loki 日志聚合系统


## 2 安装
### 2.1 window
```
-- grafana exe安装 开机自启
-- loki 下载exe启动包 参考官网/github脚本启动即可
.\loki-windows-amd64.exe --config.file=loki-local-config.yaml

```
### 2.2 centos7
```
-- grafana 下载rpm包 默认配置文件在 /etc/grafana
yum localinstall grafana-6.5.2-1.x86_64.rpm
systemctl start grafana-server
systemctl status grafana-server.service 
systemctl restart grafana-server
-- Loki 
 nohup ./loki-linux-amd64 -config.file=loki-local-config.yaml >/dev/null 2>&1 &
```
### 2.3 docker



## 3 集成
+ [grafana + loki  ](https://www.yht7.com/news/81660)
+ [grafana + nginx ](https://www.cnblogs.com/wurijie/p/11109673.html)


## 4 备注

+ [java集成-logback](https://github.com/loki4j/loki-logback-appender)
+ [官网](https://grafana.com/oss/loki/?plcmt=footer)
+ [文档](https://grafana.com/docs/loki/latest/installation/local/)
+ [下载中心](https://github.com/grafana/loki/tags)
+ [华为云-grafana](https://mirrors.huaweicloud.com/grafana/7.3.2/)