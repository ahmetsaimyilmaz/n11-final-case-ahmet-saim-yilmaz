package n11.n11finalcaseahmetsaimyilmaz.restaurantRecommendation;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class restaurantRecommendationService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;


    private final UserReviewService userReviewService;

    @Autowired
    public restaurantRecommendationService(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    public List<Restaurant> enIyiUcRestoraniBul(double kullaniciLatitude, double kullaniciLongitude) {
        List<Restaurant> tumRestoranlar = restaurantServiceClient.getAllRestaurants(); // Tüm restoranları çekiyoruz
        return tumRestoranlar.stream()
                .filter(r -> calculateDistance(kullaniciLatitude, kullaniciLongitude, r.getLatitude(), r.getLongitude()) <= 10.0) // 10 km içindekileri filtrele
                .sorted(Comparator.comparingDouble(r -> -1 * hesaplaSkor(kullaniciLatitude, kullaniciLongitude, r))) // Skora göre sırala
                .limit(3) // İlk 3'ü al
                .collect(Collectors.toList());
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Dünya'nın yarıçapı kilometre cinsinden
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // Hesaplanan mesafe kilometre cinsinden

        return distance;
    }

    private double hesaplaSkor(double kullaniciLat, double kullaniciLon, Restoran Restaurant) {
        // Restoran ve kullanıcı arasındaki uzaklık ve restoran puanına göre skor hesaplama
    }

}
