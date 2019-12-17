## 服务端

在服务器上安装docker

    docker pull mritd/shadowsocks

    docker run -dt --name ssserver -p 6443:6443 -p 6500:6500/udp mritd/shadowsocks -m "ss-server" -s "-s 0.0.0.0 -p 6443 -m chacha20-ietf-poly1305 -k test123" -x -e "kcpserver" -k "-t 127.0.0.1:6443 -l :6500 -mode fast2"

以上命令相当于执行了

    ss-server -s 0.0.0.0 -p 6443 -m chacha20-ietf-poly1305 -k test123
    
    kcpserver -t 127.0.0.1:6443 -l :6500 -mode fast2

6443是端口,chacha是加密方法,test123是密码

## 客户端

下载解压填入所需信息即可

    https://github.com/shadowsocks/shadowsocks-windows



