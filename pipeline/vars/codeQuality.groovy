def call() {
	// Lê o settings global do Jenkins
	configFileProvider([configFile(fileId: "maven-settings", variable: "MAVEN_SETTINGS")]) {
		// Executa comando maven
		sh "${tool 'Maven'}/bin/mvn -s $env.MAVEN_SETTINGS sonar:sonar"
	}
}