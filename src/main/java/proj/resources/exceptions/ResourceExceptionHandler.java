package proj.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import proj.services.exceptions.DatabaseException;
import proj.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // intercept exceptions
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class) // intercept ResourceNotFoundException
  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    StandardError err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Resource not found", e.getMessage(), request.getRequestURI()); // create a StandardError object
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err); 
  }

  @ExceptionHandler(DatabaseException.class) // intercept DatabaseException
  public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
    StandardError err = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Database exception", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }
}
