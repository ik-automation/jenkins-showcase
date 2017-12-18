# Jenkins Pipeline Showcase


[Discover Vagrant Boxes](https://app.vagrantup.com/boxes/search?order=desc&page=1&provider=&q=jenkins&sort=created&utf8=%E2%9C%93)

Code style
[Wiki](https://github.com/editorconfig/editorconfig/wiki)

Gitignore
[Create .ignore]()


Vagrant commands
vagrant up >> crate new vagrant box
vagrant up --provision >> force the update on first run
$ vagrant ssh. SSH into virtual machine.
$ vagrant up. Start virtual machine.
$ vagrant share. Share your virtual machine to the world via a temporary and unique url.
$ vagrant halt. Halt virtual machine.
$ vagrant destroy. Destroy your virtual machine. ...
$ vagrant provision. ...
$ vagrant reload.

[Install Jenkins Plugins](https://wiki.jenkins.io/display/JENKINS/Jenkins+CLI)
[Vagrant Box Used](https://app.vagrantup.com/dotronglong/boxes/jenkins-docker)

admin/123456


in linux when logged you can find project file in
```bash
cd /vagrant
ls -la
```

What is installed on the BOX
JRE 8u15
Nginx
Jenkins 2.x
Docker CE
Docker Compose

Do all the steps with installation


TODO make all steps visual
Login to Jenkins
http://10.0.0.5:8080/login
use credentials
admin/123456


Info
underlying OS version
CentOS Linux release 7.4.1708 (Core)


cd /var/lib/jenkins/workspace


TODO

add dependency analyze stage

Run tests
./mvnw clean install -Punit-tests
./mvnw clean test -Pintegraion-tests

./mvnw clean install --projects project-api -Punit-tests

 ./mvnw clean verify --projects project-api -Pintegration-tests

 control certain environmental constraints
 with enforcer
./mvnw post-clean -Pinfrastructure

Analyze dependencies
./mvnw org.apache.maven.plugins:maven-dependency-plugin:2.10:analyze

Run Bdd tests
./mvnw clean install --projects project-bdd-tests -Pbdd-tests
[Example](https://github.com/ctco/cukes/tree/master/cukes-samples/cukes-rest-sample)
