package com.social.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.io.Serializable;

/**
 * Persistent tokens are used by Spring Security to automatically log in users.
 *
 * @see com.social.security.CustomPersistentRememberMeServices
 */
@Entity
@Table(name = "persistenttoken")
public class PersistentToken implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter DATE_TIME_FORMATTER  = DateTimeFormat.forPattern("dd/MM/yyyy");
    private static final int MAX_USER_AGENT_LEN = 255;

    @Id
    @Column(name = "series")
    private String series;

    @JsonIgnore
    @NotNull
    @Column(name = "tokenvalue", nullable = false)
    private String tokenValue;

    @JsonIgnore
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "tokendate")
    private DateTime tokenDate;

    //an IPV6 address max length is 39 characters
    @Size(min = 0, max = 39)
    @Column(name = "ipaddress", length = 39)
    private String ipAddress;

    @Column(name = "useragent")
    private String userAgent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public DateTime getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(DateTime tokenDate) {
        this.tokenDate = tokenDate;
    }

    @JsonGetter
    public String getFormattedTokenDate() {
        return this.tokenDate.toString(DATE_TIME_FORMATTER);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        if (userAgent.length() >= MAX_USER_AGENT_LEN) {
            this.userAgent = userAgent.substring(0, MAX_USER_AGENT_LEN - 1);
        } else {
            this.userAgent = userAgent;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersistentToken that = (PersistentToken) o;

        if (!series.equals(that.series)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return series.hashCode();
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
