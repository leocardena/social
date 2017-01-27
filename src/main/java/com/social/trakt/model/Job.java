package com.social.trakt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "job",
    "person"
})
public class Job {
	
	@JsonProperty("job")
    private String name;
    @JsonProperty("person")
    private Person person;

    @JsonProperty("job")
    public String getName() {
        return name;
    }

    @JsonProperty("job")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("person")
    public Person getPerson() {
        return person;
    }

    @JsonProperty("person")
    public void setPerson(Person person) {
        this.person = person;
    }

}
