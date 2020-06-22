package com.example.demo.entity;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMQProducer {
    private final static String QUEUE_NAME="love";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        try (Connection connection=factory.newConnection();
             Channel channel=connection.createChannel();
        ){
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message="小贤，你好";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
            System.out.println("系统发送:"+message+" ");
        }

    }

}
