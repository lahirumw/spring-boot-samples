package com.spring.example.product.advisor;

import com.spring.example.product.domain.BaseExceptionResponseDto;
import com.spring.example.product.exception.BaseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  public static final String INTERNAL_DEFAULT = "Internal Server Error";

  /**
   * Method to handle Resource Exceptions thrown by Controllers
   *
   * @param e
   *                     : The base exception object.
   * @param request
   *                     : The Http request object.
   * @param response
   *                     : The Http response object.
   * @return {@link ResponseEntity}
   *                         : exception.
   */
  @ExceptionHandler({ BaseException.class })
  public ResponseEntity<BaseExceptionResponseDto> handleResourceException(BaseException e, HttpServletRequest request,
      HttpServletResponse response) {

    HttpHeaders responseHeaders = new HttpHeaders();

    responseHeaders.setContentType(MediaType.APPLICATION_JSON);

    BaseExceptionResponseDto exceptionDto = new BaseExceptionResponseDto(e);

    return new ResponseEntity<>(exceptionDto, responseHeaders, e.getHttpStatus());
  }

  /**
   * Method to handle Exceptions thrown by Controllers
   *
   * @param e
   *                     : The exception thrown from the controller.
   * @param request
   *                     : The request object.
   * @param response
   *                     : The response object.
   * @return {@link ResponseEntity}
   *                         : exception.
   */
  @ExceptionHandler({ Exception.class })
  public ResponseEntity<BaseExceptionResponseDto> handleException(Exception e, HttpServletRequest request,
      HttpServletResponse response) {

    HttpHeaders responseHeaders = new HttpHeaders();

    responseHeaders.setContentType(MediaType.APPLICATION_JSON);

    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    BaseExceptionResponseDto exceptionDto = new BaseExceptionResponseDto(httpStatus.value(),
        INTERNAL_DEFAULT);

    return new ResponseEntity<>(exceptionDto, responseHeaders, httpStatus);
  }
}
