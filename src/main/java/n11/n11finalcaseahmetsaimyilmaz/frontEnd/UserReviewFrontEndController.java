package n11.n11finalcaseahmetsaimyilmaz.frontEnd;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
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

import java.util.List;
import java.util.Optional;

@Controller
public class UserReviewFrontEndController {


    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    private final UserService userService;
    private final UserReviewService userReviewService;

    public UserReviewFrontEndController(UserService userService, UserReviewService userReviewService) {
        this.userService = userService;
        this.userReviewService = userReviewService;
    }


    @GetMapping({"/listofuserreviews"})
    public String getUserReviews(Model model) {
        List<UserReview> allUsersReviews = this.userReviewService.getAllUserReviews();
        model.addAttribute("userReviews", allUsersReviews);
        return "userReviewList";
    }


    @RequestMapping({"/userReview/save"})
    public String registerBook(@ModelAttribute("userReviewObject") UserReview userReview, Model model) {
        this.userService.createUser(userReview.getUser());
        this.userReviewService.saveUserReview(userReview);
        List<UserReview> allUserReviews = this.userReviewService.getAllUserReviews();
        model.addAttribute("userReviews", allUserReviews);
        return  "redirect:/listofuserreviews";
    }


    @RequestMapping({"/newUserReview"})
    public String addNewUserReview(Model model) {
        UserReview newReviewBook = new UserReview();
        model.addAttribute("userReviewObject", newReviewBook);
        return "userReviewForm";
    }


    @GetMapping({"/userReviews/edit/{id}"})
    public String showEditFormUserReview(@PathVariable("id") int theId, Model model) {
        Optional<UserReview> u1 = this.userReviewService.findById((long) theId);
        model.addAttribute("userReviewObject", u1);
        return "userReviewForm";
    }
}
