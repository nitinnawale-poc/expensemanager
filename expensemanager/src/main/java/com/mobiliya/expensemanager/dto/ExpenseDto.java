package com.mobiliya.expensemanager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ExpenseDto.
 *
 * @author Nitin
 */
@JsonInclude(Include.NON_NULL)
public class ExpenseDto {

    /** The expense title. */
    @JsonProperty("expenseTitle")
    private String expenseTitle;

    /** The category. */
    @JsonProperty("category")
    private CategoryDto category;

    /** The amount. */
    @JsonProperty("amount")
    private double amount;

    /** The date. */
    @JsonProperty("date")
    private Date date;

    /**
     * Instantiates a new expense dto.
     */
    public ExpenseDto() {
    }

    /**
     * Instantiates a new expense dto.
     *
     * @param expenseTitle the expense title
     * @param category     the category
     * @param amount       the amount
     * @param date         the date
     */
    public ExpenseDto(String expenseTitle, CategoryDto category, double amount, Date date) {
        this.expenseTitle = expenseTitle;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(this.amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((this.category == null) ? 0 : this.category.hashCode());
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        result = prime * result + ((this.expenseTitle == null) ? 0 : this.expenseTitle.hashCode());
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
        ExpenseDto other = (ExpenseDto) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (this.category == null) {
            if (other.category != null)
                return false;
        } else if (!this.category.equals(other.category))
            return false;
        if (this.date == null) {
            if (other.date != null)
                return false;
        } else if (!(this.date.getYear()==other.date.getYear() && this.date.getMonth()==other.date.getMonth() && this.date.getDate()==other.date.getDate()))
            return false;
        if (this.expenseTitle == null) {
            if (other.expenseTitle != null)
                return false;
        } else if (!this.expenseTitle.equals(other.expenseTitle))
            return false;
        return true;
    }
   
}
