package nr.springrbmq.modules.transfer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransferDocument(
        @NotEmpty String origin,
        @NotEmpty String destination,
        @NotEmpty String bank,
        @Positive BigDecimal amount,
        @JsonSerialize(using = LocalDateTimeSerializer.class) //
        @JsonDeserialize(using = LocalDateTimeDeserializer.class) //
        @NotNull @Future LocalDateTime expiration)
        implements Serializable {
}
