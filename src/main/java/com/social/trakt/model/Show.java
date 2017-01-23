
package com.social.trakt.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "year",
    "ids",
    "overview",
    "first_aired",
    "airs",
    "runtime",
    "certification",
    "network",
    "country",
    "trailer",
    "homepage",
    "status",
    "rating",
    "votes",
    "updated_at",
    "language",
    "available_translations",
    "genres",
    "aired_episodes",
    "images",
    "cast",
    "crew"
})
public class Show {

    @JsonProperty("title")
    private String title;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("ids")
    private Ids ids;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("first_aired")
    private String firstAired;
    @JsonProperty("airs")
    private Airs airs;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("certification")
    private String certification;
    @JsonProperty("network")
    private String network;
    @JsonProperty("country")
    private String country;
    @JsonProperty("trailer")
    private Object trailer;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("status")
    private String status;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("votes")
    private Integer votes;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("language")
    private String language;
    @JsonProperty("available_translations")
    private List<String> availableTranslations;
    @JsonProperty("genres")
    private List<String> genres;
    @JsonProperty("aired_episodes")
    private Integer airedEpisodes;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("cast")
    private List<Cast> cast;
    @JsonProperty("crew")
    private Crew crew;

   
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("ids")
    public Ids getIds() {
        return ids;
    }

    @JsonProperty("ids")
    public void setIds(Ids ids) {
        this.ids = ids;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("first_aired")
    public String getFirstAired() {
        return firstAired;
    }

    @JsonProperty("first_aired")
    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    @JsonProperty("airs")
    public Airs getAirs() {
        return airs;
    }

    @JsonProperty("airs")
    public void setAirs(Airs airs) {
        this.airs = airs;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("certification")
    public String getCertification() {
        return certification;
    }

    @JsonProperty("certification")
    public void setCertification(String certification) {
        this.certification = certification;
    }

    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("trailer")
    public Object getTrailer() {
        return trailer;
    }

    @JsonProperty("trailer")
    public void setTrailer(Object trailer) {
        this.trailer = trailer;
    }

    @JsonProperty("homepage")
    public String getHomepage() {
        return homepage;
    }

    @JsonProperty("homepage")
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("available_translations")
    public List<String> getAvailableTranslations() {
        return availableTranslations;
    }

    @JsonProperty("available_translations")
    public void setAvailableTranslations(List<String> availableTranslations) {
        this.availableTranslations = availableTranslations;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("aired_episodes")
    public Integer getAiredEpisodes() {
        return airedEpisodes;
    }

    @JsonProperty("aired_episodes")
    public void setAiredEpisodes(Integer airedEpisodes) {
        this.airedEpisodes = airedEpisodes;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }
    
    @JsonProperty("cast")
    public List<Cast> getCast() {
        return cast;
    }

    @JsonProperty("cast")
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    @JsonProperty("crew")
    public Crew getCrew() {
        return crew;
    }

    @JsonProperty("crew")
    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
