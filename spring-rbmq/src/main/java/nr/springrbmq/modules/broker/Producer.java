package nr.springrbmq.modules.broker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nr.springrbmq.modules.transfer.TransferDocument;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {
    
    @Value("${spring.rabbitmq.exchange}")
    private String EXCHANGE;

    // @Autowired
    // private AmqpTemplate amqpTemplate;
    private final RabbitTemplate rabbitTemplate;

    public void sendTransfer(TransferDocument data) {
        rabbitTemplate.convertAndSend(EXCHANGE, null, data);
        log.info("Transferencia enviada");
    }
}
