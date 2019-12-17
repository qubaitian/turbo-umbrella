##删除文件夹
    rm -rf conf 
##创建文件
    touch frpc.ini 
##重启docker
    systemctl restart docker 
##查看端口
    netstat -lnpt
##查看某个端口
    netstat -lnpt |grep 5672
##查看防火墙
    systemctl status firewalld.service
##打开防火墙
    systemctl start firewalld.service
##关闭防火墙
    systemctl stop firewalld.service
##打开某个端口
    firewall-cmd --zone=public --add-port=8081/tcp --permanent
##关闭某个端口
    firewall-cmd --zone=public --remove-port=5672/tcp --permanent
##打开所有端口
    firewall-cmd --zone=public --list-ports
##删除电脑上的钥匙
    ssh-keygen -R 122.51.240.129 
##查看centos的版本
    cat /etc/centos-release
##解压tar.gz
    tar -zxvf java.tar.gz

