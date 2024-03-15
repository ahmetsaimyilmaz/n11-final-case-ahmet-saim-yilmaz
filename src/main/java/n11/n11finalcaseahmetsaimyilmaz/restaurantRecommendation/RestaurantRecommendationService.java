package n11.n11finalcaseahmetsaimyilmaz.restaurantRecommendation;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RestaurantRecommendationService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;


    private final UserReviewService userReviewService;

    @Autowired
    public RestaurantRecommendationService(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    public List<Restaurant> enIyiUcRestoraniBul(double lat, double lon) {
        List<Restaurant> tumRestoranlar = restaurantServiceClient.getAllRestaurants(); // Tüm restoranları çekiyoruz
        return tumRestoranlar.stream()
                .filter(r -> calculateDistance(lat, lon, r.getLatitude(), r.getLongitude()) <= 10.0) // 10 km içindekileri filtrele
                .sorted(Comparator.comparingDouble(r -> -1 * hesaplaSkor(lat, lon, r))) // Skora göre sırala
                .limit(3) // İlk 3'ü al
                .collect(Collectors.toList());
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;

    }

    private double hesaplaSkor(double lat, double lon, Restaurant restaurant) {
        double distance = calculateDistance(lat,lon,restaurant.getLatitude(),restaurant.getLongitude());
        System.out.println((distance*0.7 + restaurant.getScore()*0.3) + " Rest " +restaurant.getName());
        return distance*0.7 + restaurant.getScore()*0.3;

    }

}
