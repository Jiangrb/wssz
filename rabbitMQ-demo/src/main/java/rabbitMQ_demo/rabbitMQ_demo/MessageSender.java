package rabbitMQ_demo.rabbitMQ_demo;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageSender {

	private final static String QUEUE_NAME = "hello1";

	public static void main(String[] argv) throws java.io.IOException, TimeoutException {
		/**
		 * 创建连接连接到MabbitMQ
		 */
		ConnectionFactory factory = new ConnectionFactory();
		// 设置MabbitMQ所在主机ip或者主机名
		// factory.setHost("localhost");
		factory.setHost("192.168.99.100");
		factory.setPort(9000);
		factory.setUsername("guest");
		factory.setPassword("guest");
		// 创建一个连接
		Connection connection = factory.newConnection();
		// 创建一个频道
		Channel channel = connection.createChannel();
		// 指定一个队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		int i = 0;
		while (true) {
			// 发送的消息
			String message = "hello world !" + i;
			// 往队列中发出一条消息
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("[x] Sent '" + message + "'");
			i++;
		}
	}
}
