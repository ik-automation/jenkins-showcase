# -*- mode: ruby -*-
# vi: set ft=ruby :

BOX_IMAGE = 'dotronglong/jenkins-docker'
BOX_VERSION = '2.0'
require 'etc'

Vagrant.configure(2) do |config|

  if Vagrant.has_plugin?('vagrant-vbguest')
    config.vbguest.auto_update = false
    # do download the iso file from a webserver
    config.vbguest.no_remote = false
  end

  config.vm.box = BOX_IMAGE
  config.vm.box_version = BOX_VERSION
  config.vm.hostname = 'jenkinss-showcase'
  # TODO add to readme
  config.vm.network(:private_network, ip: '10.0.0.5')
  config.vm.synced_folder ".", "/vagrant", type: "rsync",
   rsync__exclude: [".git/", "Vagrantfile", "README.md", ".editorconfig", ".gitignore"]
#   config.vm.synced_folder "playground", "/vagrant/playground", type: "rsync", :mount_options => ["dmode=777", "fmode=777"]
#   config.vm.synced_folder "provision", "/vagrant/provisionn", type: "rsync", :mount_options => ["dmode=777", "fmode=777"]

  config.vm.post_up_message="Setup complete `vagrant ssh` to ssh into the box. Access Jenkins `http://10.0.0.5:8080/login`"

  config.vm.provider "virtualbox" do |vb|
    vb.gui = false
    vb.memory = 2024
    vb.cpus = 2
    vb.customize ["modifyvm", :id, "--vram", "10"]
    vb.customize ['modifyvm', :id, '--usb', 'off']
    vb.linked_clone = true
    vb.name = 'jenkins-vagrant-vm'
  end
end
