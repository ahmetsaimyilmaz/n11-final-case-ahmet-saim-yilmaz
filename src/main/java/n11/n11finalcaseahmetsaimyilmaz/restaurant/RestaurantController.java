package n11.n11finalcaseahmetsaimyilmaz.restaurant;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public void test(){
        List<Restaurant> restaurantList = new ArrayList<>();

        restaurantService.save(new Restaurant("3", "The Spicy Curry", 51.5074, -0.1278, 4.8));
    }

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id) {
        return restaurantService.findById(id);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteById(id);
    }
}