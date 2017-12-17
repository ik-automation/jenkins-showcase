# -*- mode: ruby -*-
# vi: set ft=ruby :

BOX_IMAGE = 'dotronglong/jenkins-docker'
BOX_VERSION = '2.0'

Vagrant.configure(2) do |config|

  if Vagrant.has_plugin?('vagrant-vbguest')
    config.vbguest.auto_update = false
    # do download the iso file from a webserver
    config.vbguest.no_remote = false
  end

  config.vm.define 'master', primary: true, autostart: true do |jenkins|
    jenkins.vm.box = BOX_IMAGE
    jenkins.vm.box_version = BOX_VERSION
    jenkins.vm.hostname = 'jenkinss-showcase'
    # TODO add to readme
    jenkins.vm.network(:private_network, ip: '10.0.0.5')
    jenkins.vm.synced_folder ".", "/vagrant", type: "rsync",
       rsync__exclude: [".git/", "Vagrantfile", "README.md", ".editorconfig", ".gitignore"]
#   config.vm.synced_folder "playground", "/vagrant/playground", type: "rsync", :mount_options => ["dmode=777", "fmode=777"]
#   config.vm.synced_folder "provision", "/vagrant/provisionn", type: "rsync", :mount_options => ["dmode=777", "fmode=777"]

    jenkins.vm.provider "virtualbox" do |vb|
        vb.gui = false
        vb.memory = 2024
        vb.cpus = 2
        vb.customize ["modifyvm", :id, "--vram", "10"]
        vb.customize ['modifyvm', :id, '--usb', 'off']
        vb.linked_clone = true
        vb.name = 'jenkins-vagrant-vm'
    end

    jenkins.vm.post_up_message="Setup complete `vagrant ssh` to ssh into the box. Access Jenkins `http://10.0.0.5:8080/login`"
    jenkins.vm.provision 'shell', path: 'provision/helper.sh', privileged: true
    jenkins.vm.provision 'shell', path: 'provision/jennkins.update.sh', privileged: false
    jenkins.vm.provision 'shell', path: 'provision/plugins.install.sh', privileged: false
  end


end
