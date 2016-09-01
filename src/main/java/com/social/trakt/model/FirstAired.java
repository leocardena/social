package com.social.trakt.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"first_aired",
"episode",
"show"
})
public class FirstAired {

@JsonProperty("first_aired")
private String firstAired;
@JsonProperty("episode")
private Episode episode;
@JsonProperty("show")
private Show show;

@JsonProperty("first_aired")
public String getFirstAired() {
return firstAired;
}

@JsonProperty("first_aired")
public void setFirstAired(String firstAired) {
this.firstAired = firstAired;
}

@JsonProperty("episode")
public Episode getEpisode() {
return episode;
}

@JsonProperty("episode")
public void setEpisode(Episode episode) {
this.episode = episode;
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