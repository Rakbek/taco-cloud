package tacos.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import tacos.TacoOrder;

@Service
public class KafkaOrderMessagingService implements OrderMessagingService {

  private KafkaTemplate<String, TacoOrder> kafkaTemplate;

  public KafkaOrderMessagingService( KafkaTemplate<String, TacoOrder> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
   
  public void sendOrder(TacoOrder order) {
    kafkaTemplate.send("tacocloud.orders.topic", order);
  }
}