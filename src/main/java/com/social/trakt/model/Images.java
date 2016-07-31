
package com.social.trakt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fanart",
    "poster",
    "logo",
    "clearart",
    "banner",
    "thumb"
})
public class Images {

    @JsonProperty("fanart")
    private Fanart fanart;
    @JsonProperty("poster")
    private Poster poster;
    @JsonProperty("logo")
    private Logo logo;
    @JsonProperty("clearart")
    private Clearart clearart;
    @JsonProperty("banner")
    private Banner banner;
    @JsonProperty("thumb")
    private Thumb thumb;

    @JsonProperty("fanart")
    public Fanart getFanart() {
        return fanart;
    }

    @JsonProperty("fanart")
    public void setFanart(Fanart fanart) {
        this.fanart = fanart;
    }

    @JsonProperty("poster")
    public Poster getPoster() {
        return poster;
    }

    @JsonProperty("poster")
    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    @JsonProperty("logo")
    public Logo getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    @JsonProperty("clearart")
    public Clearart getClearart() {
        return clearart;
    }

    @JsonProperty("clearart")
    public void setClearart(Clearart clearart) {
        this.clearart = clearart;
    }

    @JsonProperty("banner")
    public Banner getBanner() {
        return banner;
    }

    @JsonProperty("banner")
    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    @JsonProperty("thumb")
    public Thumb getThumb() {
        return thumb;
    }

    @JsonProperty("thumb")
    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
