#基础镜像 jdk8
FROM openjdk:8-jdk-alpine

#维护者信息
LABEL maintainer="herongzhen@gzsdkj.com"

# 指定一个环境变量，会被后续 RUN 指令使用，并在容器运行时保持
## 设置时区
ENV TZ=Asia/Shanghai

# 指定工作目录,不存在就生成
WORKDIR /sdc

# 复制本地主机的 <src>（为 Dockerfile 所在目录的相对路径）到容器中的 <dest>
COPY ./jf /sdc

# 在当前镜像基础上执行指定命令
## 软连接服务器时间配置环境变量
## 打印时间格式
## 在容器中生成日志目录 /sdc/log
## 软连接到 sd_ca_logs
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && \
    echo ${TZ} > /etc/timezone && \
    mkdir -p /sdc/log && \
    ln -s /sdc/log /sd_ca_logs

# 该容器暴露的端口号
EXPOSE 11000

# 创建一个可以从本地主机或其他容器挂载的挂载点
VOLUME ["/sd_ca_logs"]

# 指定启动容器时执行的命令
ENTRYPOINT ["java","-Xverify:none","-cp","./config:./lib/*","com.sdtech.demo.JFConfig"]
