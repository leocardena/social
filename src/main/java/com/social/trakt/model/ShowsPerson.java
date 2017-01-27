
package com.social.trakt.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cast",
    "crew"
})
public class ShowsPerson {

    @JsonProperty("cast")
    private List<Cast> cast;
    @JsonProperty("crew")
    private PersonCrew crew;

    @JsonProperty("cast")
    public List<Cast> getCast() {
        return cast;
    }

    @JsonProperty("cast")
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    @JsonProperty("crew")
    public PersonCrew getCrew() {
        return crew;
    }

    @JsonProperty("crew")
    public void setCrew(PersonCrew crew) {
        this.crew = crew;
    }

}
