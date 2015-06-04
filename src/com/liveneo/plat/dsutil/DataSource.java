package com.liveneo.plat.dsutil;

import com.liveneo.lm.utils.Base64Decode;
import com.liveneo.lm.utils.Base64Encode;

public class DataSource extends org.logicalcobwebs.proxool.ProxoolDataSource {
	/** * 重置数据库链接信息为明文 */
	public void setPassword(String mi) {
		super.setPassword(mi);
		String passWord = DesDecode(mi);
		super.setPassword(passWord);
//		String url = reSetUrl(super.getDriverUrl(), super.getPassword());
//		super.setDriverUrl(url);
	} /* 替换url的密码为明文 */

	public String reSetUrl(String url, String pwd) {
		int begin = url.indexOf('/');
		int end = url.indexOf('@');
		String url2 = url.substring(0, begin + 1) + pwd + url.substring(end);
		return url2;
	}

	public String getPassword() {
		return super.getPassword();
	} /* 根据数据库配置文件密码密文得到明文 */

	public String DesDecode(String mi) {
		Base64Decode base64 = new Base64Decode();
		return base64.decode(mi);
	}
	public static void main(String[] args) {
		DataSource d = new DataSource();
//		System.out.println(d.DesDecode("nippon2013"));
		Base64Encode base64 = new Base64Encode();
		System.out.println(base64.encode("liveneo@2015"));
	}
}
