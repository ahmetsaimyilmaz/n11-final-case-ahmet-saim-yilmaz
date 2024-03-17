package n11.n11finalcaseahmetsaimyilmaz.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "restaurant-service", url = "http://localhost:8090")
public interface RestaurantServiceClient {
    @GetMapping("/restaurants/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id);

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants();

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant);
}
