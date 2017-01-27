package com.social.trakt.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "production"
})
public class PersonCrew {

    @JsonProperty("production")
    private List<Production> production;

    @JsonProperty("production")
    public List<Production> getProduction() {
        return production;
    }

    @JsonProperty("production")
    public void setProduction(List<Production> production) {
        this.production = production;
    }

}
