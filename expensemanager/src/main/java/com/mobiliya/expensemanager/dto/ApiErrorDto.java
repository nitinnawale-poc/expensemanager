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


public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public HttpStatus getStatus() {
return status;
}

public void setStatus(HttpStatus status) {
this.status = status;
}

public String getTimestamp() {
return timestamp;
}

public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

private ApiErrorDto() {
timestamp = Instant.now().toString();
}

public ApiErrorDto(HttpStatus status) {
this();
this.status = status;
this.message = "Unknown error occurred";
}

public ApiErrorDto(HttpStatus status, String message, Throwable ex) {
this();
this.status = status;
this.message = ex.getMessage();
}

}
