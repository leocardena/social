
package com.social.trakt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "job",
    "movie",
    "show"
})
public class Production {

    @JsonProperty("job")
    private String job;
    @JsonProperty("movie")
    private Movie movie;
    @JsonProperty("show")
    private Show show;

    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }

    @JsonProperty("movie")
    public Movie getMovie() {
        return movie;
    }

    @JsonProperty("movie")
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    @JsonProperty("show")
    public Show getShow() {
        return show;
    }

    @JsonProperty("show")
    public void setShow(Show show) {
        this.show = show;
    }

}
