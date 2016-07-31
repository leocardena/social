
package com.social.trakt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "trakt",
    "slug",
    "imdb",
    "tmdb"
})
public class Ids {

    @JsonProperty("trakt")
    private Integer trakt;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("imdb")
    private String imdb;
    @JsonProperty("tmdb")
    private Integer tmdb;

    @JsonProperty("trakt")
    public Integer getTrakt() {
        return trakt;
    }

    @JsonProperty("trakt")
    public void setTrakt(Integer trakt) {
        this.trakt = trakt;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("imdb")
    public String getImdb() {
        return imdb;
    }

    @JsonProperty("imdb")
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @JsonProperty("tmdb")
    public Integer getTmdb() {
        return tmdb;
    }

    @JsonProperty("tmdb")
    public void setTmdb(Integer tmdb) {
        this.tmdb = tmdb;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
