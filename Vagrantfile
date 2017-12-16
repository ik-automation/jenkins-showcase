# -*- mode: ruby -*-
# vi: set ft=ruby :

BOX_IMAGE = 'codeyourinfra/jenkins'
BOX_VERSION = '1.0'
require 'etc'

Vagrant.configure(2) do |config|

  if Vagrant.has_plugin?('vagrant-vbguest')
    config.vbguest.auto_update = false
    config.vbguest.no_remote = false
  end

  config.vm.box = BOX_IMAGE
  config.vm.box_version = BOX_VERSION
  config.vm.hostname = 'jenkinss-showcase'
  # TODO add to readme
  config.vm.network(:private_network, ip: '10.0.0.5')

  if Etc.getlogin == "jenkins" then
    cpus = Etc.nproce ssors - 1
    # Get total memory by calling "free" command and parsing output
    total_memory = %x(free -m).split(" ")[7].to_i
    memory = total_memory - 1024
    # Use rsync for syncing
    config.vm.synced_folder ".", "/vagrant", type: "rsync", rsync__exclude: ".git/"
  else
    memory = 1024
    cpus = 1
  end

  config.vm.provider "virtualbox" do |vb|
    vb.gui = false
    vb.memory = memory
    vb.cpus = cpus
    vb.linked_clone = true
    vb.name = 'jenkins-vm'
  end
end  