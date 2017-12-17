#!/usr/bin/env bash

set -

echo "=============="
echo "Current directory"
echo "=============="
pwd

echo "=========================================="
echo "List files and folder in current directory"
echo "=========================================="
ls -la


echo "================"
echo "Install software"
echo "================"
sudo yum install libcurl -y


# sudo echo "http_caching=packages" >> /etc/yum.conf

