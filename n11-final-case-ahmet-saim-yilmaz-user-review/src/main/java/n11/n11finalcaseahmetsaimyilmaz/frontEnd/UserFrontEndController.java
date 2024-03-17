package n11.n11finalcaseahmetsaimyilmaz.frontEnd;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.user.User;
import n11.n11finalcaseahmetsaimyilmaz.user.UserService;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class UserFrontEndController {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    private final UserService userService;
    private final UserReviewService userReviewService;

    public UserFrontEndController(UserService userService, UserReviewService userReviewService) {
        this.userService = userService;
        this.userReviewService = userReviewService;
    }


    @GetMapping({"/listofusers"})
    public String getUsers(Model model) {
        List<User> allUsers = this.userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "userList";
    }

    @GetMapping({"/users/edit/{id}"})
    public String showEditForm(@PathVariable("id") int theId, Model model) {
        User u1 = this.userService.getUserById((long) theId);
        model.addAttribute("userObject", u1);
        return "userForm";
    }

    @RequestMapping({"/user/save"})
    public String registerUser(@ModelAttribute("userObject") User user, Model model) {
        this.userService.createUser(user);
        List<User> allUsers = this.userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return  "redirect:/listofusers";
    }

    @RequestMapping({"/newUser"})
    public String addNewUser(Model model) {
        User newUser = new User();
        model.addAttribute("userObject", newUser);
        return "userForm";
    }

    @GetMapping({"/users/delete/{id}"})
    public String deleteCustomer(@PathVariable("id") int theId, Model model) {
        this.userService.deleteUser((long) theId);
        return "redirect:/listofusers";
    }



}
