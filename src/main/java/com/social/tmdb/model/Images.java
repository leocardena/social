
package com.social.tmdb.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "backdrops",
    "posters",
    "profiles",
    "stills"
})
public class Images {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("backdrops")
    private List<Backdrop> backdrops;
    @JsonProperty("posters")
    private List<Poster> posters;
    @JsonProperty("profiles")
    private List<Profile> profiles;
    @JsonProperty("stills")
    private List<Still> stills;

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

	/**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The backdrops
     */
    @JsonProperty("backdrops")
    public List<Backdrop> getBackdrops() {
        return backdrops;
    }

    /**
     * 
     * @param backdrops
     *     The backdrops
     */
    @JsonProperty("backdrops")
    public void setBackdrops(List<Backdrop> backdrops) {
        this.backdrops = backdrops;
    }

    /**
     * 
     * @return
     *     The posters
     */
    @JsonProperty("posters")
    public List<Poster> getPosters() {
        return posters;
    }

    /**
     * 
     * @param posters
     *     The posters
     */
    @JsonProperty("posters")
    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }
    
    /**
     * 
     * @return
     *     The profiles
     */
    @JsonProperty("profiles")
    public List<Profile> getProfiles() {
        return profiles;
    }

    /**
     * 
     * @param profiles
     *     The profiles
     */
    @JsonProperty("profiles")
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
    
    /**
     * 
     * @return
     *     The stills
     */
    @JsonProperty("stills")
    public List<Still> getStills() {
		return stills;
	}

    /**
     * 
     * @param stills
     *     The stills
     */
    @JsonProperty("stills")
	public void setStills(List<Still> stills) {
		this.stills = stills;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(backdrops).append(posters).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Images) == false) {
            return false;
        }
        Images rhs = ((Images) other);
        return new EqualsBuilder().append(id, rhs.id).append(backdrops, rhs.backdrops).append(posters, rhs.posters).isEquals();
    }

}
