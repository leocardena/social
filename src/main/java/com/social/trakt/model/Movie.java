
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
    "tagline",
    "overview",
    "released",
    "runtime",
    "trailer",
    "homepage",
    "rating",
    "votes",
    "updated_at",
    "language",
    "available_translations",
    "genres",
    "certification",
    "images"
})
public class Movie {

    @JsonProperty("title")
    private String title;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("ids")
    private Ids ids;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("released")
    private String released;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("trailer")
    private String trailer;
    @JsonProperty("homepage")
    private String homepage;
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
    @JsonProperty("certification")
    private String certification;
    @JsonProperty("images")
    private Images images;

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

    @JsonProperty("tagline")
    public String getTagline() {
        return tagline;
    }

    @JsonProperty("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("released")
    public String getReleased() {
        return released;
    }

    @JsonProperty("released")
    public void setReleased(String released) {
        this.released = released;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("trailer")
    public String getTrailer() {
        return trailer;
    }

    @JsonProperty("trailer")
    public void setTrailer(String trailer) {
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

    @JsonProperty("certification")
    public String getCertification() {
        return certification;
    }

    @JsonProperty("certification")
    public void setCertification(String certification) {
        this.certification = certification;
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
