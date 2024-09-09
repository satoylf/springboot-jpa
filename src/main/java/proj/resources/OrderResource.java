package proj.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import proj.entities.Order;
import proj.services.OrderService;

@RestController // manipulate HTTP requests and responses in JSON format
@RequestMapping(value = "/orders") // this annotation tells the path of the resource
public class OrderResource {

  @Autowired
  private OrderService service;

  @GetMapping // this annotation tells that this method will answer an HTTP GET request
  public ResponseEntity<List<Order>> findAll() { // ResponseEntity is a type for Spring to return responses from web requests
    List<Order> list = service.findAll();

    return ResponseEntity.ok().body(list); // ok() returns a HTTP response with the status code 200. body() returns the response body
  }

  @GetMapping(value = "/{id}") 
  public ResponseEntity<Order> findById(@PathVariable Long id) { // @PathVariable tells that the parameter will receive the value of the URL
    Order obj = service.findById(id);

    return ResponseEntity.ok().body(obj);
  }
}
