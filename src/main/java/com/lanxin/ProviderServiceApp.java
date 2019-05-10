package com.lanxin;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan(value = "com.lanxin.Dao")
public class ProviderServiceApp
{
    @Bean
    public Queue queue(){
    return  new ActiveMQQueue("boot_queue");
   }
    @Bean
    public Topic topic(){
        return  new ActiveMQTopic("boot_topic");
    }

    public static void main( String[] args )
    {
        SpringApplication.run(ProviderServiceApp.class,args);
    }

}
