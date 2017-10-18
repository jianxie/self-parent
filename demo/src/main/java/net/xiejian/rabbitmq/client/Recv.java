package net.xiejian.rabbitmq.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class Recv {
	
	private final static String Queue_name = "hello";
	
	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(Queue_name, false, false, false, null);
		
		QueueingConsumer	consumer = new QueueingConsumer(channel);
		// 获取队列的消息
		channel.basicConsume(Queue_name, true, consumer);
		Delivery delivery = null;
		String message = null;
		while(true){
			delivery = consumer.nextDelivery();
			message = new String(delivery.getBody());
			if("exit".equals(message)){
				break;
			}
			System.out.println(message);
		}
		System.out.println("exit");
		channel.close();
		connection.close();
	}
}
