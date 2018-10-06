package pro.buildmysoftware.testlimits.order.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class MoneyDeserializer extends JsonDeserializer<Money> {
	@Override
	public Money deserialize(JsonParser p, DeserializationContext ctxt)
		throws IOException, JsonProcessingException {
		return Money.parse(p.readValueAs(String.class));
	}
}
