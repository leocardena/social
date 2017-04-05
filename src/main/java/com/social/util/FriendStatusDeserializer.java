package com.social.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class FriendStatusDeserializer extends JsonDeserializer<FriendStatus> {

	@Override
	public FriendStatus deserialize(JsonParser jsonParser, DeserializationContext sc) {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node;
		try {
			node = oc.readTree(jsonParser);
			if (node == null) {
				return null;
			}

			String text = node.textValue(); // gives "A" from the request

			if (text == null) {
				return null;
			}

			return FriendStatus.create(text);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
