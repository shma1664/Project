package clouds.cloudstorage;

import java.io.File;

/**
 * 云存储调用接口
 */
public interface ICloudStorage {

	/**
	 * 上传用户数据到云盘
	 * 
	 * @param bucketName
	 * @param file
	 * @param fileTypeH
	 * @return
	 * @throws Exception
	 */
	public CloudStorageObject uploadBucketData(String filePath) throws Exception;

	/**
	 * 通过url获取本地备份文件
	 * 
	 * @param url
	 * @return
	 */
	public File getFileFromUrl(String url);
	
	/**
	 * 删除object
	 * @param bucketName
	 * @param objectKey
	 */
	public void deleteObject(File file);
	
	public void deleteLocalFile(File file);
	
}
