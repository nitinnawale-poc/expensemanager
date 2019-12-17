package com.mobiliya.expensemanager.dto;


import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ApiErrorDto.
 *
 * @author Nitin
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The message. */
    @JsonProperty("message")
    private String message;
    
    /** The status. */
    @JsonProperty("status")
    private HttpStatus status;
    
    /** The timestamp. */
    @JsonProperty("timestamp")
    private String timestamp;    

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Instantiates a new api error dto.
	 */
	private ApiErrorDto() {
        timestamp = Instant.now().toString();
    }

    /**
     * Instantiates a new api error dto.
     *
     * @param status the status
     */
    public ApiErrorDto(HttpStatus status) {
        this();
        this.status = status;
        this.message = "Unknown error occurred";
    }

    /**
     * Instantiates a new api error dto.
     *
     * @param status the status
     * @param message the message
     * @param ex the ex
     */
    public ApiErrorDto(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = ex.getMessage();
    }

}
