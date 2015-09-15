package clouds.cloudstorage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import clouds.RandomUtil;

public abstract class AbstractCloudStorage {

	private static final SimpleDateFormat DIR_DATAFORMAT = new SimpleDateFormat("yyyy/mm/dd");

	/**
	 * 生成文件名
	 * 
	 * @param strName
	 *            原来文件名
	 * @param defaultExt
	 * @return
	 */
	private String makeCloudStoragePathInner(String strName) {
		String strUpName = StringUtils.join(new String[] {
				DIR_DATAFORMAT.format(new Date()), "/", strName });
		return strUpName;
	}

	/**
	 * 所有名字都由系统生成，原文件名被覆盖
	 * 
	 * @param fileName
	 * @param defaultExt
	 * @return
	 */
	public String makeCloudStoragePath(String filePath) {
		
		if(filePath.contains("media")) {
			return filePath.split("media")[1];
		}
	
		int index = filePath.lastIndexOf('.');
		String fileType = index < 0 ? "" : filePath.substring(index);
		String newFileName = getCloudStorageFileName(fileType);
		return makeCloudStoragePathInner(newFileName);
	}

	/**
	 * 根据文件名-生成新文件名
	 * 
	 * @param fileUpload
	 * @return
	 */
	public String getCloudStorageFileName(File fileUpload) {
		String cloudStorageFileName = StringUtils.join(new Object[] {
				System.nanoTime(), RandomUtil.generateString(6),
				fileUpload.getName() });
		return cloudStorageFileName;
	}

	/**
	 * 根据文件类型-生成文件名
	 * 
	 * @param fileType
	 *            .mp4
	 * @return
	 */
	public String getCloudStorageFileName(String fileType) {
		String cloudStorageFileName = StringUtils.join(new Object[] {
				System.nanoTime(), RandomUtil.generateString(6), fileType });
		return cloudStorageFileName;
	}
}
