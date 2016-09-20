/**
 * Created by tsfreitas on 19/09/16.
 */
import com.tsfreitas.AwsS3Actions

def call(body) {
    def s3Action = new AwsS3Actions(env.AWS_ACCESS_KEY,env.AWS_SECRET_KEY,env.AWS_BUCKET_NAME)
    s3Action.archiveArtifact(body)
}