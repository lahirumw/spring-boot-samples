package com.spring.example.product.exception;

import org.springframework.http.HttpStatus;
/**
    * This class is extended by other HTTP resource specific exceptions
    *
     *
     */
public class BaseException extends RuntimeException {

  /**
   * Serialization ID.
   */
  private static final String BASE_DEFAULT = "Error occurred";

  /**
   * HttpStatus of the Error.
   */
  private final HttpStatus httpStatus;

  /**
   * Constructor Method. (Default message and Http status).
   *
   */
  public BaseException() {
    super(BASE_DEFAULT);
    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  /**
   * Constructor Method. (Default message and Http status).
   *
   * @param e
   */
  public BaseException(Exception e) {
    super(BASE_DEFAULT, e);
    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  /**
   * Constructor Method. (Default Http status).
   *
   * @param message
   *            : Exception message to be set.
   */
  public BaseException(String message) {
    super(message);
    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  /**
   * Constructor Method.
   *
   * @param httpStatus
   *            : The Http status assigned to the exception.
   *
   * @param message
   *            : Exception message to be set.
   */
  public BaseException(HttpStatus httpStatus, String message) {
    super(message);
    this.httpStatus = httpStatus;
  }

  /**
   * Constructor Method.
   *
   * @param httpStatus
   *            : The Http status assigned to the exception.
   *
   * @param message
   *            : Exception message to be set.
   *
   * @param e
   *            : THe exception initial thrown (cause).
   */
  public BaseException(HttpStatus httpStatus, String message, Exception e) {
    super(message, e);
    this.httpStatus = httpStatus;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
