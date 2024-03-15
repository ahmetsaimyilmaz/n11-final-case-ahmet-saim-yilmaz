package n11.n11finalcaseahmetsaimyilmaz.restaurantRecommendation;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantRecommendationController {

    @Autowired
    private RestaurantRecommendationService restaurantRecommendationService;

    @GetMapping("/recommendations")
    public ResponseEntity<List<Restaurant>> getRecommendations(@RequestParam double latitude, @RequestParam double longitude) {
        List<Restaurant> restaurants = restaurantRecommendationService.enIyiUcRestoraniBul(latitude, longitude);

        return ResponseEntity.ok(restaurants);
    }


}
