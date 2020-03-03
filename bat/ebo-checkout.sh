#!/bin/bash
echo "checkout ebo-base..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-base.git
cd ebo-base
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-common..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-common.git
echo

echo "checkout ebo-server..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-server.git
cd ebo-server
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-config..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-config-server.git
cd ebo-config-server
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-gateway..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-gateway.git
cd ebo-gateway
rm src/main/java/com/yhhl/ebo/gateway/config/RouteConfig.java
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-api..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo.git
cd ebo
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-oauth2..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-oauth2.git
cd ebo-oauth2
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-cloud..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-admin.git
cd ebo-admin
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-company..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-company.git
cd ebo-company
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-res..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-ump.git
cd ebo-ump
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-templateEntity..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-templateEntity.git
cd ebo-templateEntity
git checkout -b dev origin/dev
cd ../
echo

echo "checkout ebo-ui..."
git clone http://zhangxf:zhangxf%40yhhl@154.8.227.18/ebo_group/ebo-ui.git
cd ebo-ui
git checkout -b dev origin/dev
cd ../
echo
