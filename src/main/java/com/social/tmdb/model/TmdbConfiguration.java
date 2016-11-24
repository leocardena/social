
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
    "images",
    "change_keys"
})
public class TmdbConfiguration {

    @JsonProperty("images")
    private Images images;
    @JsonProperty("change_keys")
    private List<String> changeKeys;

    /**
     * 
     * @return
     *     The images
     */
    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The changeKeys
     */
    @JsonProperty("change_keys")
    public List<String> getChangeKeys() {
        return changeKeys;
    }

    /**
     * 
     * @param changeKeys
     *     The change_keys
     */
    @JsonProperty("change_keys")
    public void setChangeKeys(List<String> changeKeys) {
        this.changeKeys = changeKeys;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(images).append(changeKeys).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TmdbConfiguration) == false) {
            return false;
        }
        TmdbConfiguration rhs = ((TmdbConfiguration) other);
        return new EqualsBuilder().append(images, rhs.images).append(changeKeys, rhs.changeKeys).isEquals();
    }

}
