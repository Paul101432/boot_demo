 
### 1 简介
+ 场景 http服务器 静态服务器 反向代理 负载均衡 动态代理 重写url
+ 文档 http://nginx.org/en/docs/
+ 其他版本  OpenResty, kong, Tengine, Apache APISIX 


### 2 常用命令
+ 检查配置文件 nginx -t
+ 启动 start nginx
+ 关闭 nginx -s stop
+ 重启 nginx -s reload



### 3 参考使用


```  
    ### + 3.1 access_log 按日期存储
    http {
        log_format  main  '$remote_addr - $remote_user [$time_iso8601] "$request" '
                          '$status $body_bytes_sent "$http_referer" '
                          '"$http_user_agent" "$http_x_forwarded_for"';
        server {
            if ($time_iso8601 ~ '(\d{4}-\d{2}-\d{2})') {
                    set $current_day $1;
            }
            access_log  logs/access-$current_day.log  main;
            listen 80; 
            location / {
                root   html;
                index  index.html index.htm;
            }
        }
    }

    ### 3.2 web集群: 这里需要注意nginx的几个时间设置
    http {
        include       mime.types; 
        keepalive_timeout  5; 
        upstream tomcat_server{
            
            server 127.0.0.1:8180;
            server 127.0.0.1:8280;
        }
        server {
            listen       90;
            server_name  localhost;
            location / {
                root   html;
                index  index.html index.htm;
                proxy_pass http://tomcat_server;            
                proxy_connect_timeout  2s; 
                proxy_send_timeout 2s;
                proxy_read_timeout 2s;            
                proxy_set_header Host $host;
                proxy_set_header X-Forwarded-For $remote_addr;
            }        
        }
    }
 
    ### 解决前端css等样式无法生效的bug.
    http{
    include       mime.types;
    default_type  application/octet-stream;   
    }

    ###3.3 前后端分离
        ## 静态代码
        location / {
            root   html;
            index  index.html index.htm;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
        
        ## 后台服务
 	    location /sdc/web/ {
            proxy_set_header  Host              $http_host;
            proxy_set_header  X-Real-IP         $remote_addr;
            proxy_set_header  X-Forwarded-For   $proxy_add_x_forwarded_for;
            proxy_set_header  X-Forwarded-Proto $scheme;
            proxy_pass   http://127.0.0.1:8001;
        }
        
 

    ### 3.4 https 
    http {
        server {
            ## https
            listen       443 ssl;
            listen       80;
            server_name  sd.code.com;
            ssl_certificate      cert/sd.crt;
            ssl_certificate_key  cert/sd3.key;
            ssl_protocols  SSLv2 SSLv3 TLSv1;
            ssl_ciphers  HIGH:!aNULL:!MD5;
            ssl_prefer_server_ciphers   on;
            location / {
                root   html;
                index  index.html index.htm index.php;
            }
        }
    }
 
    ###3.5 限流 
    ### limit_req_zone 用来限制单位时间内的请求数，即速率限制,采用的漏桶算法 "leaky bucket"。
    ### limit_req_conn 用来限制同一时间连接数，即并发限制。 
    http {
        # $binary_remote_addr
        # zone=one:1m 生成一个大小为10M，名字为one的内存区域，用来存储访问的频次信息
        # rate=1r/s 每秒1次
        limit_req_zone  $binary_remote_addr   zone=one:1m   rate=1r/s;
        
        server {
            # zone=one 设置使用哪个配置区域来做限制
            # burst=100 设置一个大小为5的缓冲区当有大量请求（爆发）过来时，超过了访问频次限制的请求可以先放到这个缓冲区内 
            # nodelay 超过访问频次而且缓冲区也满了的时候就会直接返回503，如果没有设置，则所有请求会等待排队
            limit_req zone=one burst=100 nodelay;
        }
    } 
    http {
        # 设置存储区域addr(10M)  其中路由/的并发数是1
        limit_conn_status 505; 
        limit_conn_zone $binary_remote_addr zone=addr:10m;
        server {
            location / {
                    limit_conn addr 1; 
                    root   html;
                    index  index.html index.htm;
            } 
        }
    }
```

### 4 log_format 说明

| 参数 | 说明  | 示例 |
| -------------------- | --------------- | ------------------------------------------------------------ |                                                              
| $remote_addr             | 客户端地址                                    | 211.28.65.253| 
| $remote_user             | 客户端用户名称                                | --| 
| $time_local              | 访问时间和时区                                | 18/Jul/2012:17:00:01 +0800| 
| $request                 | 请求的URI和HTTP协议                           | "GET /article-10000.html HTTP/1.1"| 
| $http_host               | 请求地址，即浏览器中你输入的地址（IP或域名）     | www.wang.com 192.168.100.100| 
| $status                  | HTTP请求状态                                 |  200| 
| $upstream_status         | upstream状态                                  | 200| 
| $body_bytes_sent         | 发送给客户端文件内容大小                        | 1547| 
| $http_referer            | url跳转来源                                   | https://www.baidu.com/| 
| $http_user_agent         | 用户终端浏览器等信息                           | "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; SV1; GTB7.0; .NET4.0C;| 
| $ssl_protocol            | SSL协议版本                                   | TLSv1| 
| $ssl_cipher              | 交换数据中的算法                               | RC4-SHA| 
| $upstream_addr           | 后台upstream的地址，即真正提供服务的主机地址     | 10.10.10.100:80| 
| $request_time            | 整个请求的总时间                               | 0.205| 
| $upstream_response_time  | 请求过程中，upstream响应时间                    | 0.002| 
