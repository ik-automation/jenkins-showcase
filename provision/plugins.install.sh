#!/usr/bin/env bash
set -e

USERNAME=admin
PASSWORD=123456
CLI_FOLDER=/vagrant/provision/cli
JENKINS_CLI="java -jar ${CLI_FOLDER}/jenkins-cli.jar"
JENKINS_HOST=http://localhost:8080

echo "======================"
echo "List installed Plugins"
echo "======================"
${JENKINS_CLI} -s ${JENKINS_HOST} list-plugins --username ${USERNAME} --password ${PASSWORD}

${JENKINS_CLI} -s ${JENKINS_HOST} install-plugin blueocean --username ${USERNAME} --password ${PASSWORD}

${JENKINS_CLI} -s ${JENKINS_HOST} install-plugin delivery-pipeline-plugin --username ${USERNAME} --password ${PASSWORD}

${JENKINS_CLI}  -s ${JENKINS_HOST} reload-configuration --username ${USERNAME} --password ${PASSWORD}

${JENKINS_CLI}  -s ${JENKINS_HOST} safe-restart --username ${USERNAME} --password ${PASSWORD}

