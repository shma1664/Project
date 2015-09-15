package clouds.cloudstorage;

import java.io.File;

/**
 * 上传数据成功后返回的对象
 * Created by HarryRen on 2015/3/25.
 */
public class CloudStorageObject {


    private String url;

    private File localFile;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public File getLocalFile() {
		return localFile;
	}

	public void setLocalFile(File localFile) {
		this.localFile = localFile;
	}


}
