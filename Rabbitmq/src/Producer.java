
//import javax.xml.parsers.FactoryConfigurationError;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.util.Scanner;;
//import com.rabbitmq.client.QueueingConsumer;
public class Producer {

	private final static String Queue_Name="TEST";
	public static void main(String args[]) throws Exception{
	Scanner scanner = new Scanner(System.in);
	ConnectionFactory factory = new ConnectionFactory();
	factory.setHost("135.252.151.146");
	Connection connection = factory.newConnection();
	Channel channel = connection.createChannel();
	channel.queueDeclare(Queue_Name, false, false, false,null);
//	QueueingConsumer consumer = new QueueingConsumer(channel);
//	channel.basicConsume(Queue_Name, true, consumer);
	System.out.println("input the message");
	String message = scanner.next();
	channel.basicPublish("", Queue_Name, null, message.getBytes());
	channel.close();
	connection.close();
	scanner.close();
	}
}
