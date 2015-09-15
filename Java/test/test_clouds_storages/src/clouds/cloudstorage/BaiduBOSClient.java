package clouds.cloudstorage;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.Credentials;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.baidubce.util.Mimetypes;

public class BaiduBOSClient {

	private BosClient bosClient;
	
	public BaiduBOSClient() {
		BosClientConfiguration configuration = new BosClientConfiguration();
		
		DefaultBceCredentials credentials = new DefaultBceCredentials("56a28b00068c429882a83cb13c3501a0", "8ea8cf58f031478ba5c95cf3188aa851");
		configuration.setCredentials(credentials);
		configuration.setEndpoint("http://bj.bcebos.com");
		bosClient = new BosClient(configuration);
	}
	
    /**
     * 上传文件到百度云盘
     *
     * @param bucket
     * @param fileUpload
     * @return
     */
    public String uploadFileInner(String bucketName, File fileUpload, String strFileNameObject) throws Exception {
    	String strFileUrl = null;
        File newFile = new File(strFileNameObject);
        String newFileName = newFile.getName();

        // 设置 contentType
        Mimetypes types = Mimetypes.getInstance();
        String contentType = types.getMimetype(newFileName);
        ObjectMetadata metadata = new ObjectMetadata();
        if (StringUtils.isNotEmpty(contentType)) {
            metadata.setContentLength(fileUpload.length());
            metadata.setContentType(contentType);
            metadata.setContentDisposition("filename=\"" + newFileName + "\"");
        }

        PutObjectResponse response =
                bosClient.putObject(bucketName, strFileNameObject, fileUpload, metadata);
        
        if (response.getETag() != null) {
            strFileUrl = generatePresignedUrl(bucketName, strFileNameObject);
        }
        
        return strFileUrl;
    }
    
   
    private String generatePresignedUrl(String bucketName, String objectKey) {

    	return bosClient.generatePresignedUrl(bucketName, objectKey, 1800).toString();
    }

    /**
     * 上传文件到百度云盘
     *
     * @param bucket
     * @param fileUpload
     * @return
     */
    public String uploadFile(String bucketName, File fileUpload, String strFileNameObject) throws Exception {
        return uploadFileInner(bucketName, fileUpload, strFileNameObject);
    }
    
    public void deleteObject(String bucketName, String strFileNameObject) {
    	bosClient.deleteObject(bucketName, bucketName + strFileNameObject);
	}


	public BosClient getBosClient() {
		return bosClient;
	}


	public void setBosClient(BosClient bosClient) {
		this.bosClient = bosClient;
	}

}
