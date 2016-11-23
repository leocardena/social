package com.social.tmdb.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = MovieResponse.class, name = "MovieResponse")})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "page",
    "total_results",
    "total_pages"
})
public abstract class BaseTMDBResponse {

	 	@JsonProperty("page")
	    private Integer page;
	    @JsonProperty("total_results")
	    private Integer totalResults;
	    @JsonProperty("total_pages")
	    private Integer totalPages;
    
    protected BaseTMDBResponse(Integer page, Integer totalResults, Integer totalPages) {
		super();
		this.page = page;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
	}
    
    protected BaseTMDBResponse() {
	}

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

}
