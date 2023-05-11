package com.spring.example.product.exception;

import org.springframework.http.HttpStatus;

/**
 * Customized Exception for Not Found. Exception used when a resource is not
 * found in the system.
 *
 * @author
 */
public class NotFoundException extends BaseException {


  private static final String NOT_FOUND_DEFAULT = "Not Found";

  /**
   * Constructor Method.(Default Message).
   */
  public NotFoundException() {
    super(HttpStatus.NOT_FOUND, NOT_FOUND_DEFAULT);
  }

  /**
   * Constructor Method. (Customized Exception)
   *
   * @param message
   */
  public NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }

  /**
   * Constructor Method. (Exception and Customized Message).
   *
   * @param message
   *                    : Customization message.
   * @param e
   *                    : Exception.
   */
  public NotFoundException(String message, Exception e) {
    super(HttpStatus.NOT_FOUND, message, e);
  }

}
