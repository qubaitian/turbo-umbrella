##服务端

使用docker

https://hub.docker.com/r/mritd/shadowsocks
执行

docker run -dt --name ssserver -p 6443:6443 -p 6500:6500/udp mritd/shadowsocks -m "ss-server" -s "-s 0.0.0.0 -p 6443 -m chacha20-ietf-poly1305 -k test123" -x -e "kcpserver" -k "-t 127.0.0.1:6443 -l :6500 -mode fast2"
##以上命令相当于执行了

ss-server -s 0.0.0.0 -p 6443 -m chacha20-ietf-poly1305 -k test123
kcpserver -t 127.0.0.1:6443 -l :6500 -mode fast2

##客户端

https://github.com/shadowsocks/shadowsocks-windows

解压填入所需信息即可

