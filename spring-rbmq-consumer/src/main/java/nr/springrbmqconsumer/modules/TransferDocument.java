package nr.springrbmqconsumer.modules;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public record TransferDocument(
                String origin,
                String destination,
                String bank,
                BigDecimal amount,
                @JsonSerialize(using = LocalDateTimeSerializer.class) //
                @JsonDeserialize(using = LocalDateTimeDeserializer.class) //
                LocalDateTime expiration)
                implements Serializable {
}
