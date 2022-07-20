package tacos.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import tacos.TacoOrder;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {

  private JmsTemplate jms;

  public JmsOrderMessagingService(JmsTemplate jms) {
    this.jms = jms;
    this.jms.setDefaultDestinationName("localhost");
  }

  @Override
  public void sendOrder(TacoOrder order) {
    jms.send(new MessageCreator() {
      public Message createMessage(Session session) throws JMSException {
        return session.createObjectMessage(order);
      }
    });
    
  }
  
}