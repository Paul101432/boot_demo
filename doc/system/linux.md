


## 常见配置文件说明
+ 环境变量
```
/etc/profile
/etc/bashrc
/etc/bash.bashrc
/etc/environment
~/.profile -- 当用户登录时执行
~/.bash_logout -- 当每次退出系统(退出bash shell)时执行该文件。
```

+ 开机启动
```
/etc/rc.local
/etc/init.d/
```



## 示例

+ 端口进程
```
-- 根据名字查找
ps -ef | grep [启动的服务名]
-- 根据PID(进程)显示
netstat -ntlp

```

+ vi/vim
```
-- 打开文件
vi [文件名]
-- 设置文档默认格式为unix 解决window/linux的文本问题
:set fileformat=unix

``