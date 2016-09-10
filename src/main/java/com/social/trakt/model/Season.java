package com.social.trakt.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"number",
"ids",
"rating",
"votes",
"episode_count",
"aired_episodes",
"overview",
"first_aired",
"images"
})
public class Season {

@JsonProperty("number")
private Integer number;
@JsonProperty("ids")
private Ids ids;
@JsonProperty("rating")
private Double rating;
@JsonProperty("votes")
private Integer votes;
@JsonProperty("episode_count")
private Integer episodeCount;
@JsonProperty("aired_episodes")
private Integer airedEpisodes;
@JsonProperty("overview")
private Object overview;
@JsonProperty("first_aired")
private Object firstAired;
@JsonProperty("images")
private Images images;

@JsonProperty("number")
public Integer getNumber() {
return number;
}

@JsonProperty("number")
public void setNumber(Integer number) {
this.number = number;
}

@JsonProperty("ids")
public Ids getIds() {
return ids;
}

@JsonProperty("ids")
public void setIds(Ids ids) {
this.ids = ids;
}

@JsonProperty("rating")
public Double getRating() {
return rating;
}

@JsonProperty("rating")
public void setRating(Double rating) {
this.rating = rating;
}

@JsonProperty("votes")
public Integer getVotes() {
return votes;
}

@JsonProperty("votes")
public void setVotes(Integer votes) {
this.votes = votes;
}

@JsonProperty("episode_count")
public Integer getEpisodeCount() {
return episodeCount;
}

@JsonProperty("episode_count")
public void setEpisodeCount(Integer episodeCount) {
this.episodeCount = episodeCount;
}

@JsonProperty("aired_episodes")
public Integer getAiredEpisodes() {
return airedEpisodes;
}

@JsonProperty("aired_episodes")
public void setAiredEpisodes(Integer airedEpisodes) {
this.airedEpisodes = airedEpisodes;
}

@JsonProperty("overview")
public Object getOverview() {
return overview;
}

@JsonProperty("overview")
public void setOverview(Object overview) {
this.overview = overview;
}

@JsonProperty("first_aired")
public Object getFirstAired() {
return firstAired;
}

@JsonProperty("first_aired")
public void setFirstAired(Object firstAired) {
this.firstAired = firstAired;
}

@JsonProperty("images")
public Images getImages() {
return images;
}

@JsonProperty("images")
public void setImages(Images images) {
this.images = images;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

}