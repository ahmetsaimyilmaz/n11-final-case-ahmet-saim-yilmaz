package n11.n11finalcaseahmetsaimyilmaz.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(value = "restaurant-service", url = "http://localhost:8080/restaurants")
public interface RestaurantServiceClient {
    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id);
}
