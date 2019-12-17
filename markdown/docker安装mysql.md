##搜索mysql
    docker search mysql
##拉取镜像
    docker pull mysql:5.7
##查看本地镜像
    docker images
##运行容器
    docker run -itd --name mysql-5.7 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql
