package com.social.trakt.model;

import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "score",
    "movie",
    "show",
    "person"
})
public class Search {

    @JsonProperty("type")
    private String type;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("movie")
    private Movie movie;
    @JsonProperty("show")
    private Show show;
    @JsonProperty("person")
    private Person person;

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The score
     */
    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The movie
     */
    @JsonProperty("movie")
    public Movie getMovie() {
        return movie;
    }

    /**
     * 
     * @param movie
     *     The movie
     */
    @JsonProperty("movie")
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * 
     * @return
     *     The show
     */
    @JsonProperty("show")
    public Show getShow() {
        return show;
    }

    /**
     * 
     * @param show
     *     The show
     */
    @JsonProperty("show")
    public void setShow(Show show) {
        this.show = show;
    }

    /**
     * 
     * @return
     *     The person
     */
    @JsonProperty("person")
    public Person getPerson() {
        return person;
    }

    /**
     * 
     * @param person
     *     The person
     */
    @JsonProperty("person")
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(score).append(movie).append(show).append(person).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Search) == false) {
            return false;
        }
        Search rhs = ((Search) other);
        return new EqualsBuilder().append(type, rhs.type).append(score, rhs.score).append(movie, rhs.movie).append(show, rhs.show).append(person, rhs.person).isEquals();
    }

}
