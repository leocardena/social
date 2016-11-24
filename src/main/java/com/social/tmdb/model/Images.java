package com.social.tmdb.model;

import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "base_url",
    "secure_base_url",
    "backdrop_sizes",
    "logo_sizes",
    "poster_sizes",
    "profile_sizes",
    "still_sizes"
})
public class Images {

    @JsonProperty("base_url")
    private String baseUrl;
    @JsonProperty("secure_base_url")
    private String secureBaseUrl;
    @JsonProperty("backdrop_sizes")
    private List<String> backdropSizes;
    @JsonProperty("logo_sizes")
    private List<String> logoSizes;
    @JsonProperty("poster_sizes")
    private List<String> posterSizes;
    @JsonProperty("profile_sizes")
    private List<String> profileSizes;
    @JsonProperty("still_sizes")
    private List<String> stillSizes;

    /**
     * 
     * @return
     *     The baseUrl
     */
    @JsonProperty("base_url")
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * 
     * @param baseUrl
     *     The base_url
     */
    @JsonProperty("base_url")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * 
     * @return
     *     The secureBaseUrl
     */
    @JsonProperty("secure_base_url")
    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    /**
     * 
     * @param secureBaseUrl
     *     The secure_base_url
     */
    @JsonProperty("secure_base_url")
    public void setSecureBaseUrl(String secureBaseUrl) {
        this.secureBaseUrl = secureBaseUrl;
    }

    /**
     * 
     * @return
     *     The backdropSizes
     */
    @JsonProperty("backdrop_sizes")
    public List<String> getBackdropSizes() {
        return backdropSizes;
    }

    /**
     * 
     * @param backdropSizes
     *     The backdrop_sizes
     */
    @JsonProperty("backdrop_sizes")
    public void setBackdropSizes(List<String> backdropSizes) {
        this.backdropSizes = backdropSizes;
    }

    /**
     * 
     * @return
     *     The logoSizes
     */
    @JsonProperty("logo_sizes")
    public List<String> getLogoSizes() {
        return logoSizes;
    }

    /**
     * 
     * @param logoSizes
     *     The logo_sizes
     */
    @JsonProperty("logo_sizes")
    public void setLogoSizes(List<String> logoSizes) {
        this.logoSizes = logoSizes;
    }

    /**
     * 
     * @return
     *     The posterSizes
     */
    @JsonProperty("poster_sizes")
    public List<String> getPosterSizes() {
        return posterSizes;
    }

    /**
     * 
     * @param posterSizes
     *     The poster_sizes
     */
    @JsonProperty("poster_sizes")
    public void setPosterSizes(List<String> posterSizes) {
        this.posterSizes = posterSizes;
    }

    /**
     * 
     * @return
     *     The profileSizes
     */
    @JsonProperty("profile_sizes")
    public List<String> getProfileSizes() {
        return profileSizes;
    }

    /**
     * 
     * @param profileSizes
     *     The profile_sizes
     */
    @JsonProperty("profile_sizes")
    public void setProfileSizes(List<String> profileSizes) {
        this.profileSizes = profileSizes;
    }

    /**
     * 
     * @return
     *     The stillSizes
     */
    @JsonProperty("still_sizes")
    public List<String> getStillSizes() {
        return stillSizes;
    }

    /**
     * 
     * @param stillSizes
     *     The still_sizes
     */
    @JsonProperty("still_sizes")
    public void setStillSizes(List<String> stillSizes) {
        this.stillSizes = stillSizes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(baseUrl).append(secureBaseUrl).append(backdropSizes).append(logoSizes).append(posterSizes).append(profileSizes).append(stillSizes).toHashCode();
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
        return new EqualsBuilder().append(baseUrl, rhs.baseUrl).append(secureBaseUrl, rhs.secureBaseUrl).append(backdropSizes, rhs.backdropSizes).append(logoSizes, rhs.logoSizes).append(posterSizes, rhs.posterSizes).append(profileSizes, rhs.profileSizes).append(stillSizes, rhs.stillSizes).isEquals();
    }

}
