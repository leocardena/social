package com.social.trakt.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"released",
"movie"
})
public class Released {

@JsonProperty("released")
private String released;
@JsonProperty("movie")
private Movie movie;

@JsonProperty("released")
public String getReleased() {
return released;
}

@JsonProperty("released")
public void setReleased(String released) {
this.released = released;
}

@JsonProperty("movie")
public Movie getMovie() {
return movie;
}

@JsonProperty("movie")
public void setMovie(Movie movie) {
this.movie = movie;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

}