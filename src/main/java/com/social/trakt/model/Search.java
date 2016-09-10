package com.social.trakt.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"type",
"score",
"show"
})
public class Search {

@JsonProperty("type")
private String type;
@JsonProperty("score")
private Double score;
@JsonProperty("show")
private Show show;

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("score")
public Double getScore() {
return score;
}

@JsonProperty("score")
public void setScore(Double score) {
this.score = score;
}

@JsonProperty("show")
public Show getShow() {
return show;
}

@JsonProperty("show")
public void setShow(Show show) {
this.show = show;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

}