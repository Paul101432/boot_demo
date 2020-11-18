
## 文件服务
+ 特点
    + 基于GO跨平台
    + 轻量级
    + 适合于存储大容量非结构化

+ 连接
    https://docs.minio.io/cn/
    https://docs.min.io/docs/
    https://www.bookstack.cn/read/MinioCookbookZH/8.md

+ 启动
    + 控制台输出启动指定文件存储路径  .\minio.exe server D:\html\minio
    + 后台启动 指定文件存储路径 ./minio server /data >minilog.conf &

+ 配置文件
.\data\.minio.sys\config\config.json


### 高可用
+ 可以在丢失一半的盘的情况下，仍可以保证数据安全
+ 分布式Minio单租户存在最少4个盘最多16个盘的限制（受限于纠删码）。盘数必须为偶数
+ 依次启动下面ip的服务 账号得一致
+ SDK访问方式 可以通过nginx实现客户端的负载
+ 参考启动配置
```
export MINIO_ACCESS_KEY=<ACCESS_KEY>
export MINIO_SECRET_KEY=<SECRET_KEY>
minio server http://192.168.1.11/export1 http://192.168.1.12/export2 \
               http://192.168.1.13/export3 http://192.168.1.14/export4 \
               http://192.168.1.15/export5 http://192.168.1.16/export6 \
               http://192.168.1.17/export7 http://192.168.1.18/export8

set MINIO_ACCESS_KEY=<ACCESS_KEY>
set MINIO_SECRET_KEY=<SECRET_KEY>
minio.exe server http://192.168.1.11/C:/data http://192.168.1.12/C:/data ^
                  http://192.168.1.13/C:/data http://192.168.1.14/C:/data
```