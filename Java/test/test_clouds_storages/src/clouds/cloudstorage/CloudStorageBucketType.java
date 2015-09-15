package clouds.cloudstorage;

/**
 * 云存储bucket枚举
 * Created by HarryRen on 2015/3/25.
 */
public enum CloudStorageBucketType {
    //#主题bucket
    TOPIC("face-topic"),
    //#应用程序bucket
    APP("face-app"),
    // # 云存储 上传用户头像的仓库
    USER_IMG("face-userimg"),
    //# 云存储 上传短视频缩略图的仓库
    SHORT_VIDEO_IMG("face-shortvideoimg"),
    //# 云存储 上传短视频的仓库
    SHORT_VIDEO("face-shortvideo"),
    //# 云存储 上传视频缩略图的仓库
    VIDEO_IMG("face-videoimg"),
    //# 云存储 上传视频的仓库
    VIDEO("face-video");


    private String bucketName;

    private CloudStorageBucketType(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
