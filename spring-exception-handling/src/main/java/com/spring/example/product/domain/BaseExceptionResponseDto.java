package com.spring.example.product.domain;

import com.spring.example.product.exception.BaseException;

/**
 *The base exception wrapper for error responses.
 *
 */
public class BaseExceptionResponseDto {

  private int code;

  private String description;

  /**
   * Constructor Method.
   *
   * @param e
   *              : Base exception.
   */
  public BaseExceptionResponseDto(BaseException e) {
    this.code = e.getHttpStatus().value();
    this.description = e.getMessage();
  }

  /**
   * Constructor Method.
   *
   * @param code
   *                        : The code of the error.
   * @param description
   *                        : The description of the error.
   */
  public BaseExceptionResponseDto(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

}
