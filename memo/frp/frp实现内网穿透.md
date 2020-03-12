## 服务端 docker

#### 下载镜像

        docker pull cloverzrg/frps-docker

#### 使用docker在服务器上搭建

        docker run -d --name frp-server -p 7500:7500 -p 7700:7700 -p 8080:8080 -p 8082:8082 -p 8081:8081 -v /root/conf:/conf --restart=always cloverzrg/frps-docker
    
#### frps.ini 服务端配置

    # /root/conf/frps.ini
    [common]
    bind_port = 7700
    token = 123456
    vhost_tcp_port = 8080
    vhost_http_port = 8081
    vhost_https_port = 8082
    
    dashboard_port = 7500
    dashboard_user = admin
    dashboard_pwd = 123456
    
    tcp_mux = true
    max_pool_count = 10

## 客户端 windows

##### 下载对应版本https://github.com/fatedier/frp/releases 解压cmd运行frpc.exe   
    
#### frpc.ini 客户端配置

    #frpc.ini
    [common]
    server_addr = 122.51.240.129
    server_port = 7700
    token = 123456
 
    [test]
    type = tcp
    local_port = 8080
    remote_port = 8080