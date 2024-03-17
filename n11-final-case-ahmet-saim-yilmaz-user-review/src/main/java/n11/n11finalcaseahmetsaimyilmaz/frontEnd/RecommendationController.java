package n11.n11finalcaseahmetsaimyilmaz.frontEnd;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.restaurantRecommendation.RestaurantRecommendationService;
import n11.n11finalcaseahmetsaimyilmaz.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecommendationController {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    @Autowired
    private RestaurantRecommendationService restaurantRecommendationService;

    @GetMapping("/recommendation")
    public String getRecommendationPage() {
        return "recommendation";
    }

    @PostMapping("/recommendation")
    public String processRecommendation(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude, Model model) {
        System.out.println("lat= " + latitude + " long =" + longitude);
        List<Restaurant> restaurantList = restaurantRecommendationService.enIyiUcRestoraniBul(latitude, longitude);
        model.addAttribute("restaurants", restaurantList);

        return "recommendation";
    }

}
