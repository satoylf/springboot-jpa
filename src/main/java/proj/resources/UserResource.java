package proj.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import proj.entities.User;
import proj.services.UserService;

@RestController // manipulate HTTP requests and responses in JSON format
@RequestMapping(value = "/users") // this annotation tells the path of the resource
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping // this annotation tells that this method will answer an HTTP GET request
  public ResponseEntity<List<User>> findAll() { // ResponseEntity is a type for Spring to return responses from web requests
    List<User> list = service.findAll();

    return ResponseEntity.ok().body(list); // ok() returns a HTTP response with the status code 200. body() returns the response body
  }

  @GetMapping(value = "/{id}") 
  public ResponseEntity<User> findById(@PathVariable Long id) { // @PathVariable tells that the parameter will receive the value of the URL
    User obj = service.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @PostMapping // this annotation tells that this method will answer an HTTP POST request
  public ResponseEntity<User> insert(@RequestBody User obj) { // @RequestBody tells that the parameter will receive the object in JSON format
    obj = service.insert(obj);
    
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
          .buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(null).body(obj); // created() returns a HTTP response with the status code 201
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);

    return ResponseEntity.noContent().build(); // noContent() returns a HTTP response with the status code 204
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
    obj = service.update(id, obj);

    return ResponseEntity.ok().body(obj);
  }
}
