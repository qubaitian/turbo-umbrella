## 删除docker

    sudo yum remove docker docker-client docker-client-latest docker-common docker-latest docker-latest-logrotate docker-logrotate docker-engine                    

## 安装 Docker Engine-Community

    sudo yum install -y yum-utils device-mapper-persistent-data lvm2
    sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

## 启动docker服务

    sudo systemctl start docker
    
## 重启服务

重启防火墙可能需要重启docker

    sudo systemctl start docker
    
## 测试docker是否可以使用

    sudo docker run hello-world