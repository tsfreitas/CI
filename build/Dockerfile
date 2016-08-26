# Imagem do jenkins com plugins necessários para o ambiente de CI

FROM jenkins:2.7.2

MAINTAINER Thiago Frreitas <thiago.freitas@buscapecompany.com>

# Instala alguns plugins
RUN /usr/local/bin/install-plugins.sh timestamper ldap jacoco maven-plugin

# Marca o Jenkins como configurado, para não aparecer a tela de Wizard
#RUN echo 2.7.2 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state