package nr.springrbmq.modules.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nr.springrbmq.modules.broker.Producer;

@RestController
@RequestMapping("/api/v1/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final Producer producer;

    @PostMapping
    public ResponseEntity<?> getMethodName(@Valid @RequestBody TransferDocument data) {
        producer.sendTransfer(data);
        return ResponseEntity.ok().body(data);
    }

}
