package clouds;

import clouds.cloudstorage.CloudStorageClient;

public class TestMain {

	public static void main(String[] args) {
		final CloudStorageClient cloudStorageClient = new CloudStorageClient();

		for(int i=0; i<=50; ++i) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						cloudStorageClient.uploadBucketData("D:/20150828-1111-111120150828112232264.mp4");
						cloudStorageClient.uploadBucketData("D:/executeLog_bak.png");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
