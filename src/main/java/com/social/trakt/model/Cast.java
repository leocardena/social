package com.social.trakt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "character",
    "person",
    "movie",
    "show"
})
public class Cast {

    @JsonProperty("character")
    private String character;
    @JsonProperty("person")
    private Person person;
    @JsonProperty("movie")
    private Movie movie;
    @JsonProperty("show")
    private Show show;

    @JsonProperty("character")
    public String getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(String character) {
        this.character = character;
    }

    @JsonProperty("person")
    public Person getPerson() {
        return person;
    }

    @JsonProperty("person")
    public void setPerson(Person person) {
        this.person = person;
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