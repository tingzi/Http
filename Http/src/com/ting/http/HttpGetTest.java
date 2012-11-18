package com.ting.http;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpGetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ret = doGet("http://api.map.baidu.com/geocoder?output=json&location=39.983424,116.322987");
		System.out.println(ret);
	}

	public static String doGet(String url) {
		String result = null;

		try {
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = new DefaultHttpClient().execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity, HTTP.UTF_8);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}


}
