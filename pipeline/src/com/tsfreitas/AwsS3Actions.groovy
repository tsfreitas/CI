package com.tsfreitas

@Grab(group = 'com.amazonaws', module = 'aws-java-sdk-s3', version = '[1.11.35,1.12.0)')
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.PutObjectRequest;


class AwsS3Actions implements Serializable {

    def bucketName
    def accessKey
    def secretKey

    AwsS3Actions(accessKey, secretKey, bucketName) {
        this.bucketName = bucketName
        this.accessKey = accessKey
        this.secretKey = secretKey
    }

    def archiveArtifact(artifact) {

        // Cria o nome do arquivo
        def fileName = _createFileName(artifact)
        println "Artefato irá subir para repositório em $fileName"

        // Faz upload do arquivo
        def request = new PutObjectRequest(bucketName, fileName, artifact.file)
        _client().putObject(request)

        println "Artefato armazenado com sucesso"

    }

    @NonCPS
    AmazonS3Client _client() {
        return new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey))
    }

    String _createFileName(artifact) {
        // Nome do arquivo deve seguir o padrão /projectName/System/version
        return "${artifact.projectName}/${artifact.system}/${artifact.version}/${artifact.file.name}"
    }

}