/**
 * 
 *//*
package cqupt.nmid.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

*//**
 * @author MaRong
 * @date 2016年3月16日 下午1:05:43
 * @description
 *//*
public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
	TextMessage textMsg = (TextMessage) message;
	System.out.println("接收到一个纯文本消息。");
	try {
	    System.out.println("消息内容是：" + textMsg.getText());
	} catch (JMSException e) {
	    e.printStackTrace();
	}
    }

}*/
