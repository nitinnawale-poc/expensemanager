package com.mobiliya.expensemanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CategoryDto.
 *
 * @author Nitin
 */
@JsonInclude(Include.NON_NULL)
public class CategoryDto {

    /** The category name. */
    @JsonProperty("categoryName")
    private String categoryName;

    /**
     * Instantiates a new category dto.
     */
    public CategoryDto() {
    }

    /**
     * Instantiates a new category dto.
     *
     * @param categoryName the category name
     */
    public CategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.categoryName == null) ? 0 : this.categoryName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoryDto other = (CategoryDto) obj;
        if (this.categoryName == null) {
            if (other.categoryName != null)
                return false;
        } else if (!this.categoryName.equals(other.categoryName))
            return false;
        return true;
    }
    

}
