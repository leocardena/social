package com.social.trakt.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"season",
"number",
"title",
"ids",
"number_abs",
"overview",
"rating",
"votes",
"first_aired",
"updated_at",
"available_translations",
"images"
})
public class Episode {

@JsonProperty("season")
private Integer season;
@JsonProperty("number")
private Integer number;
@JsonProperty("title")
private String title;
@JsonProperty("ids")
private Ids ids;
@JsonProperty("number_abs")
private Object numberAbs;
@JsonProperty("overview")
private String overview;
@JsonProperty("rating")
private Double rating;
@JsonProperty("votes")
private Integer votes;
@JsonProperty("first_aired")
private String firstAired;
@JsonProperty("updated_at")
private String updatedAt;
@JsonProperty("available_translations")
private List<Object> availableTranslations;
@JsonProperty("images")
private Images images;

@JsonProperty("season")
public Integer getSeason() {
return season;
}

@JsonProperty("season")
public void setSeason(Integer season) {
this.season = season;
}

@JsonProperty("number")
public Integer getNumber() {
return number;
}

@JsonProperty("number")
public void setNumber(Integer number) {
this.number = number;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("ids")
public Ids getIds() {
return ids;
}

@JsonProperty("ids")
public void setIds(Ids ids) {
this.ids = ids;
}

@JsonProperty("number_abs")
public Object getNumberAbs() {
return numberAbs;
}

@JsonProperty("number_abs")
public void setNumberAbs(Object numberAbs) {
this.numberAbs = numberAbs;
}

@JsonProperty("overview")
public String getOverview() {
return overview;
}

@JsonProperty("overview")
public void setOverview(String overview) {
this.overview = overview;
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

@JsonProperty("first_aired")
public String getFirstAired() {
return firstAired;
}

@JsonProperty("first_aired")
public void setFirstAired(String firstAired) {
this.firstAired = firstAired;
}

@JsonProperty("updated_at")
public String getUpdatedAt() {
return updatedAt;
}

@JsonProperty("updated_at")
public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

@JsonProperty("available_translations")
public List<Object> getAvailableTranslations() {
return availableTranslations;
}

@JsonProperty("available_translations")
public void setAvailableTranslations(List<Object> availableTranslations) {
this.availableTranslations = availableTranslations;
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