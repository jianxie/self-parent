package net.xiejian.httpclient.example1;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

/**
 * 同步请求与异步请求
 * 
 * @author jian_xie
 * @date 2015年10月31日
 */
public class HttpClientMain {
	
	private static final int times = 10;

	public static void main(String[] args) throws Exception {
		HttpClientMain httpClientMain = new HttpClientMain();
		long start, end;
		start = System.currentTimeMillis();
		httpClientMain.test1();
		end = System.currentTimeMillis();
		System.out.println("sync:" + (end - start));
				
		start = System.currentTimeMillis();		
		httpClientMain.test2();
		end = System.currentTimeMillis();
		System.out.println("async:" + (end - start));
	}

	public void test1() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// Execute 500 request in async
		HttpGet request = new HttpGet("http://www.coder4.com/");
		for (int i = 0; i < times; i++) {
			request.setHeader("Connection", "close");
			CloseableHttpResponse response = httpclient.execute(request);
//			System.out.println("sync:" + i + response.getStatusLine());
			response.getStatusLine();
			response.close();
		}

		httpclient.close();
	}

	public void test2() throws InterruptedException, ExecutionException, IOException {
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		// Start the client
		httpclient.start();

		// Execute 100 request in async
		final HttpGet request = new HttpGet("http://www.coder4.com/");
		request.setHeader("Connection", "close");
		List<Future<HttpResponse>> respList = new LinkedList<Future<HttpResponse>>();
		for (int i = 0; i < times; i++) {
			respList.add(httpclient.execute(request, null));
		}

		// Print response code
		int i = 0;
		for (Future<HttpResponse> response : respList) {
			response.get().getStatusLine();
//			System.out.println("async:" + i++ + response.get().getStatusLine());
		}

		httpclient.close();
	}
}
