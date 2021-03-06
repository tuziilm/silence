package com.wxad.base.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {

	/**
	 * 禁止广告区域
	 */
	public static final String BAN_ADVERTISING_AREA = "";

	/**
	 * 禁止机型
	 */
	public static final String BAN_MODEL = "";

	public static String getIpAddr(HttpServletRequest request) {
		String ip = "";
		try{
			ip = request.getHeader("x-forwarded-for");

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

				ip = request.getHeader("Proxy-Client-IP");

			}

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

				ip = request.getHeader("WL-Proxy-Client-IP");

			}

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

				ip = request.getRemoteAddr();

			}
			return ip;
		}catch(Exception ex){
			return ip;
		}
	}

	public static boolean ipIsValid(String ipSection, String ip) {
		if (ipSection == null)
			return false;
		if (ip == null)
			return false;
		ipSection = ipSection.trim();
		ip = ip.trim();
		final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
		if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
			return false;
		int idx = ipSection.indexOf('-');
		String[] sips = ipSection.substring(0, idx).split("\\.");
		String[] sipe = ipSection.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
		for (int i = 0; i < 4; ++i) {
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		return ips <= ipt && ipt <= ipe;
	}

	/**
	 * 
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getAddresses(String content, String encodingString)
			throws UnsupportedEncodingException {
		// 这里调用pconline的接口
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		// 从http://whois.pconline.com.cn取得IP所在的省市区信息
		String returnStr = getResult(urlStr, content, encodingString);
		if (returnStr != null) {
			// 处理返回的省市区信息
			String[] temp = returnStr.split(",");
			if (temp.length < 3) {
				return "0";// 无效IP，局域网测试
			}
			
			String country = decodeUnicode((temp[1].split(":"))[2].replaceAll(
					"\"", ""));// 国家
			/**
			 * 
			 * String region = (temp[5].split(":"))[1].replaceAll("\"", "");
			 * region = decodeUnicode(region);// 省份
			 * String country = ""; String area = ""; String region = ""; String
			 * city = ""; String county = ""; String isp = ""; for(int
			 * i=0;i<temp.length;i++){ switch(i){ case 1:country =
			 * (temp[i].split(":"))[2].replaceAll("\"", ""); country =
			 * decodeUnicode(country);//国家 break; case 3:area =
			 * (temp[i].split(":"))[1].replaceAll("\"", ""); area =
			 * decodeUnicode(area);//地区 break; case 5:region =
			 * (temp[i].split(":"))[1].replaceAll("\"", ""); region =
			 * decodeUnicode(region);//省份 break; case 7:city =
			 * (temp[i].split(":"))[1].replaceAll("\"", ""); city =
			 * decodeUnicode(city);//市区 break; case 9:county =
			 * (temp[i].split(":"))[1].replaceAll("\"", ""); county =
			 * decodeUnicode(county);//地区 break; case 11:isp =
			 * (temp[i].split(":"))[1].replaceAll("\"", ""); isp =
			 * decodeUnicode(isp);//ISP公司 break; } }
			 */
			// System.out.println(country+"="+area+"="+region+"="+city+"="+county+"="+isp);
			return country;
		}
		return null;
	}

	/**
	 * @param urlStr
	 *            请求的地址
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 */
	private static String getResult(String urlStr, String content,
			String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
			connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			out.flush();// 刷新
			out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
			// ,以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

	/**
	 * unicode 转换成 中文
	 * 
	 * @author fanhui 2007-3-15
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}
	
	/**
	 * 返回客户端请求结果
	 */
	public static String responseCode(Boolean flag) {
		JSONObject responseObject = new JSONObject();
		try {
			responseObject.put("status", flag);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String codeInfo = responseObject.toString();
		String responseInfo = DesUtil.encode(codeInfo);
		return responseInfo;
	}
	
	/**
	 * 屏蔽IP地址
	 * @param request
	 * @return
	 */
	public static String shieldIp(HttpServletRequest request){
		
		//获得客户端请求IP地址
		String ipAddr = Utils.getIpAddr(request);

		if (ipAddr == null) {
			InetAddress inet = null;
			try {
				inet = InetAddress.getByName(request.getRemoteAddr());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

			if (inet != null) {
				ipAddr = inet.getHostAddress();
			}
		}

		try {
			ipAddr = Utils.getAddresses("ip=" + ipAddr, "UTF-8");
		} catch (Exception ex) {

		}
		
		return ipAddr;
	}
	
	public static String getDateTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
}
