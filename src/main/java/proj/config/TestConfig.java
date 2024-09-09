package proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import proj.entities.User;
import proj.entities.Order;
import proj.repositories.OrderRepository;
import proj.repositories.UserRepository;

@Configuration // configuration class
@Profile("test")
public class TestConfig implements CommandLineRunner { // execute run method when the application starts

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
    Order o2 = new Order(null, Instant.parse("2019-06-20T19:23:07Z"), u2);
    Order o3 = new Order(null, Instant.parse("2019-06-20T19:33:07Z"), u1);
    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
