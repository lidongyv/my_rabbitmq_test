import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
public class Receiver {
	final static String QUEUE_NAME = "TEST";
	public static void main(String args[])throws Exception{
	ConnectionFactory factory = new ConnectionFactory();
	factory.setHost("135.252.151.146");
	Connection connection = factory.newConnection();
	Channel channel = connection.createChannel();
	channel.queueDeclare("QUEUE_NAME",false,false,false,null);
	QueueingConsumer consumer = new QueueingConsumer(channel);
	channel.basicConsume(QUEUE_NAME, true, consumer);
	System.out.println("waiting for messages");
	while(true){
		QueueingConsumer.Delivery delivery = consumer.nextDelivery();
		String message = new String(delivery.getBody());
		System.out.println("the message is "+message);
	}
	
	
	}
	
}
