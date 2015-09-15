package clouds.cloudstorage;

import java.io.File;

/**
 * 数据上传
 */
public class CloudStorageClient extends AbstractCloudStorage implements
		ICloudStorage {

	private BaiduBOSClient baiduBOSClient;
	
	private String bucketName;
	
	public CloudStorageClient() {
		this.bucketName = "qiqimobile-media";
		baiduBOSClient = new BaiduBOSClient();
	}


	public CloudStorageObject uploadBucketData(String filePath) throws Exception {
		
		String strFileNameObject = makeCloudStoragePath(filePath);

		File file = new File(filePath);
		String url = baiduBOSClient.uploadFile(bucketName, file, strFileNameObject);
		
		CloudStorageObject object = new CloudStorageObject();
		object.setUrl(url);
		object.setLocalFile(file);
		return object;
	}

	public File getFileFromUrl(String url) {
		
		String fileStr = "" + url.split("media")[1];
		File file = new File(fileStr);
		if (file.exists()) {
			return file;
		} else {
			return null;
		}
	}

	public void deleteObject(File file) {
		String strFileNameObject = makeCloudStoragePath(file.getPath());
		baiduBOSClient.deleteObject(bucketName, strFileNameObject);           
	}

	public void deleteLocalFile(File file) {
		if(file.exists()) {
			file.delete();
		}
	}

	public BaiduBOSClient getBaiduBOSClient() {
		return baiduBOSClient;
	}

	public void setBaiduBOSClient(BaiduBOSClient baiduBOSClient) {
		this.baiduBOSClient = baiduBOSClient;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
}
