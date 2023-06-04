package nr.springrbmqconsumer.modules.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import nr.springrbmqconsumer.modules.TransferDocument;

@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void saveTransfer(TransferDocument data) {
        log.info("Transferencia recibida de la cola");
        log.info(data.toString());
    }

}
