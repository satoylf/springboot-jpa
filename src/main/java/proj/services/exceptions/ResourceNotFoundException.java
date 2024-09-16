package proj.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(Object id) {
    super("Resource not found. Id " + id); // return a message when the id is not found
  }
}
