/**
 * Created by tsfreitas on 19/09/16.
 */

def call(body) {
    def s3Action = new com.tsfreitas.AwsS3Actions(env.accesKey,env.secretKey)
    s3Action.archiveArtifact(body)
}