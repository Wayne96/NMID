/**
 * 
 *//*
package cqupt.nmid.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

*//**
 * @author MaRong
 * @date 2016年3月16日 下午12:51:33
 * @description 
 *//*
public class ProduceServiceImpl implements ProduceService{
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Override
    public void sendMessage(Destination destination, final String message) {
	  System.out.println("---------------生产者发送消息-----------------");  
	  System.out.println("---------------生产者发了一个消息：" + message);  
	  jmsTemplate.send(destination, new MessageCreator() {
	    
	    @Override
	    public Message createMessage(Session session) throws JMSException {
		
		 return session.createTextMessage(message);  
	    }
	});
	
    }
    
    
    

}*/
