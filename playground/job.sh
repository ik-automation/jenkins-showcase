#!/usr/bin/env bash

vagrant up
vagrant rsync
vagrant provision

vagrant ssh -c "cd /vagrant; ./build.sh"
result=$?

vagrant suspend

exit ${result}
