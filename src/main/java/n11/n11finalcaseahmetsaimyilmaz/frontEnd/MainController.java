package n11.n11finalcaseahmetsaimyilmaz.frontEnd;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.user.User;
import n11.n11finalcaseahmetsaimyilmaz.user.UserService;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReview;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    private final UserService userService;
    private final UserReviewService userReviewService;

    public MainController(UserService userService, UserReviewService userReviewService) {
        this.userService = userService;
        this.userReviewService = userReviewService;
    }

    @GetMapping
    public String showMainMenu() {
        System.out.println("test");
        return "index";
    }

    @GetMapping({"/listofrestaurants"})
    public String getRestaurants(Model model) {
        List<Restaurant> allRestaruants = this.restaurantServiceClient.getAllRestaurants();
        model.addAttribute("restaurants", allRestaruants);
        return "restaurantList";
    }








}
