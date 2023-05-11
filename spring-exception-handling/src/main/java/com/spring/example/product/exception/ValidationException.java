package com.spring.example.product.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom Exception for Invalid Request Handling.
 *
 */
public class ValidationException extends BaseException {

  private static final String BAD_REQUEST_DEFAULT = "Invalid Request";

  /**
   * Constructor Method. (Default Message).
   *
   */
  public ValidationException() {
    super(HttpStatus.BAD_REQUEST, BAD_REQUEST_DEFAULT);
  }

  /**
   * Constructor Method.
   *
   * @param message
   *            : The message for the exception
   */
  public ValidationException(String message) {
    super(HttpStatus.BAD_REQUEST, message);
  }

  /**
   * Constructor Method.
   *
   * @param message
   *            : The message for the exception
   *
   * @param e
   *            : The cause.
   */
  public ValidationException(String message, Exception e) {
    super(HttpStatus.BAD_REQUEST, message, e);
  }

}
