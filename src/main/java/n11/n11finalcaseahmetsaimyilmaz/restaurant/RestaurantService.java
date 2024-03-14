package n11.n11finalcaseahmetsaimyilmaz.restaurant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
    public Optional<Restaurant> updateScore(Long id, double newScore) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        restaurant.ifPresent(r -> {
            r.setScore(newScore);
            restaurantRepository.save(r);
        });
        return restaurant;
    }
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void deleteById(Long id) {
        restaurantRepository.deleteById(id);
    }

}