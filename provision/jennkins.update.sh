#!/usr/bin/env bash
set -e
# Update jenkins version
USERNAME=admin
PASSWORD=123456
CLI_FOLDER=/vagrant/provision/cli
JENKINS_CLI="java -jar ${CLI_FOLDER}/jenkins-cli.jar"
JENKINS_HOST=http://localhost:8080

VERSION=$(${JENKINS_CLI} -s ${JENKINS_HOST} version --username ${USERNAME} --password ${PASSWORD})
echo "========================================"
echo "Jenkins Version Before Update ${VERSION}"
echo "========================================"

echo "=============="
echo "Update Jenkins"
echo "=============="
# sudo systemctl stop jenkins
sudo yum update -y
# sudo systemctl start jenkins

VERSION=$(${JENKINS_CLI} -s ${JENKINS_HOST} version --username ${USERNAME} --password ${PASSWORD})
echo "======================================="
echo "Jenkins Version After Update ${VERSION}"
echo "======================================="
