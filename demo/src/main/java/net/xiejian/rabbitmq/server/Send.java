package net.xiejian.rabbitmq.server;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 发送消息
 * @author jian_xie
 * @date 2016年6月1日
 */
public class Send {
	
	private final static String Queue_name = "hello";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(Queue_name, false, false, false, null);
		
		String message = "Hello world!";
		
		channel.basicPublish("", Queue_name, null, message.getBytes());
		System.out.println(message);
		channel.close();
		connection.close();
	}
}
