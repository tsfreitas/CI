package com.tsfreitas

@Grab(group = 'com.amazonaws', module = 'aws-java-sdk-s3', version = '[1.11.35,1.12.0)')
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.PutObjectRequest;


class AwsS3Actions implements Serializable {

    def s3Client

    AwsS3Actions(accessKey, secretKey) {
        s3Client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey))
    }

    def archiveArtifact(artifact) {

        // Cria o nome do arquivo
        def fileName = _createFileName(artifact)
        println "Artefato irá subir para repositório em $fileName"

        // Faz upload do arquivo
        def request = new PutObjectRequest('artifact-reposuitory', fileName, artifact.file)
        s3Client.putObject(request)

        println "Artefato armazenado com sucesso"

    }


    String _createFileName(artifact) {
        // Nome do arquivo deve seguir o padrão /projectName/System/version
        return "${artifact.projectName}/${artifact.system}/${artifact.version}/${artifact.file.name}"
    }

}