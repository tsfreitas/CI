# Imagem do jenkins com plugins necessários para o ambiente de CI

FROM jenkins:2.7.4

MAINTAINER Thiago Frreitas <thiago.freitas@buscapecompany.com>

# Marca o Jenkins como configurado, para não aparecer a tela de Wizard
RUN echo 2.7.4 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
RUN echo 2.7.4 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion
RUN mkdir -p /usr/share/jenkins/ref/users/admin
ADD config.xml /usr/share/jenkins/ref/users/admin/config.xml

# Instala alguns plugins
RUN /usr/local/bin/install-plugins.sh git git-parameter maven gradle nodejs
RUN /usr/local/bin/install-plugins.sh workflow-aggregator scriptler jacoco sonar
RUN /usr/local/bin/install-plugins.sh timestamper config-file-provider cloudbees-folder ws-cleanup
RUN /usr/local/bin/install-plugins.sh ldap credentials-binding
RUN /usr/local/bin/install-plugins.sh email-ext  emailext-template build-name-setter
