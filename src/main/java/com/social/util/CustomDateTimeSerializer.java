package com.social.util;

import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Classe que configura globalmente a serialização de datas
 * 
 * @author Leonardo Cardena
 *
 */
public class CustomDateTimeSerializer extends StdSerializer<DateTime> {

	private static final long serialVersionUID = 3709989108010238748L;
	private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

	public CustomDateTimeSerializer() {
		this(null);
	}

	public CustomDateTimeSerializer(Class<DateTime> t) {
		super(t);
	}

	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		gen.writeString(formatter.print(value));
	}
}