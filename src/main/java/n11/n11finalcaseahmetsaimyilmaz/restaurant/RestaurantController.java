package n11.n11finalcaseahmetsaimyilmaz.restaurant;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;



    @PatchMapping("/{id}/score")
    public Optional<Restaurant> updateRestaurantScore(@PathVariable int id, @RequestParam double score) {
        return restaurantService.updateScore(id, score);
    }

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        Page<Restaurant> resultPage = (Page<Restaurant>) restaurantService.findAll();
        List<Restaurant> restaurants = resultPage.getContent();
        return restaurants;
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable int id) {
        return restaurantService.findById(id);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        restaurantService.deleteById(id);
    }
}