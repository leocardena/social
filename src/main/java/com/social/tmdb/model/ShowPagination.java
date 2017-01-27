
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
    "page",
    "shows",
    "total_results",
    "total_pages"
})
public class ShowPagination {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("results")
    private List<Show> shows;
    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonProperty("total_pages")
    private Integer totalPages;

    /**
     * 
     * @return
     *     The page
     */
    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 
     * @return
     *     The shows
     */
    @JsonProperty("results")
    public List<Show> getShows() {
        return shows;
    }

    /**
     * 
     * @param shows
     *     The shows
     */
    @JsonProperty("results")
    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    @JsonProperty("total_results")
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The total_results
     */
    @JsonProperty("total_results")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The totalPages
     */
    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * 
     * @param totalPages
     *     The total_pages
     */
    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(page).append(shows).append(totalResults).append(totalPages).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShowPagination) == false) {
            return false;
        }
        ShowPagination rhs = ((ShowPagination) other);
        return new EqualsBuilder().append(page, rhs.page).append(shows, rhs.shows).append(totalResults, rhs.totalResults).append(totalPages, rhs.totalPages).isEquals();
    }

}
