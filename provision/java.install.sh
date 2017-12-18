#!/usr/bin/env bash
set -e

echo "=============="
echo "Update Jenkins"
echo "=============="

cd ~
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u151-b12/e758a0de34e24606bca991d704f6dcbf/jdk-8u151-linux-x64.rpm"
sudo yum localinstall jdk-8u151-linux-x64.rpm -y
rm ~/jdk-8u151-linux-x64.rpm
export JAVA_HOME=/usr/java/jdk1.8.0_151/jre
sudo sh -c "echo export JAVA_HOME=/usr/java/jdk1.8.0_151/jre >> /etc/environment"


