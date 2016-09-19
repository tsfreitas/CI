def call() {
	// Lê o settings global do Jenkins
	configFileProvider([configFile(fileId: "maven-settings", variable: "MAVEN_SETTINGS")]) {
		try {
			// Executa comando maven
			sh "${tool 'Maven'}/bin/mvn -s $env.MAVEN_SETTINGS clean org.jacoco:jacoco-maven-plugin:prepare-agent package"
		} finally {
			// Gera relatório do Junit
			junit "**/target/surefire-reports/*.xml"
		}
	}
}