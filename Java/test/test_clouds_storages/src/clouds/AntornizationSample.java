package clouds;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;

public class AntornizationSample {
	public static void main(String[] args) {

		/**
		 * ACCESS_KEY_ID对应控制台中的“Access Key ID”
		 */
		String ACCESS_KEY_ID = "your-access-key-id";

		/**
		 * SECRET_ACCESS_KEY对应控制台中的“Access Key Secret”
		 */
		String SECRET_ACCESS_KEY = "your-secret-access-key";

		/**
		 * webservice设置
		 */

		// 初始化一个BosClient
		String ENDPOINT = "http://bj.bcebos.com";

		BosClientConfiguration config = new BosClientConfiguration();

		config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID,
				SECRET_ACCESS_KEY));

		// 上面的方式使用默认域名作为BOS的服务地址，如果用户需要自己制定域名，可以通过传入ENDPOINT参数来指定
		/**
		 * 注意：ENDPOINT参数只能用指定的包含Region的域名来进行定义，目前BOS只提供北京一个Region，
		 * 因此ENDPOINT支持主域名http
		 * ://bj.bcebos.com和备域名http://bj.baidubos.com，随着Region的增加将会开放其他可以支持的域名。
		 */
		config.setEndpoint(ENDPOINT);

		/**
		 * 用户验证
		 */

		BosClientConfiguration userConfig = new BosClientConfiguration();

		// 配置代理为本地8080端口
		userConfig.setProxyHost("127.0.0.1");
		userConfig.setProxyPort(8080);

		// 设置用户名和密码
		userConfig.setProxyUsername("username");
		userConfig.setProxyPassword("password");

		/**
		 * 设置网络参数
		 */

		BosClientConfiguration netConfig = new BosClientConfiguration();

		// 设置HTTP最大连接数为10
		netConfig.setMaxConnections(10);

		// 设置TCP连接超时为5000毫秒
		netConfig.setConnectionTimeoutInMillis(5000);

		// 设置Socket传输数据超时的时间为2000毫秒
		netConfig.setSocketTimeoutInMillis(2000);

		BosClient client = new BosClient(config);

	}
}
