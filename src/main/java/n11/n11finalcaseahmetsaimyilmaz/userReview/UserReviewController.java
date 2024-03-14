package n11.n11finalcaseahmetsaimyilmaz.userReview;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userReviews")
public class UserReviewController {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    private final UserReviewService userReviewService;

    @Autowired
    public UserReviewController(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    @GetMapping
    public List<UserReview> getAllUserReviews() {
        return userReviewService.getAllUserReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReview> getUserReviewById(@PathVariable Long id) {

        Optional<Restaurant> temp =  restaurantServiceClient.getRestaurantById((long) userReviewService.findById(id).get().getRestaurant());
        System.out.println(temp.get().toString());
        return userReviewService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserReview createUserReview(@RequestBody UserReview userReview) {
        return userReviewService.saveUserReview(userReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReview> updateUserReview(@PathVariable Long id, @RequestBody UserReview userReview) {
        return userReviewService.findById(id)
                .map(existingUserReview -> {
                    userReview.setId(id);
                    UserReview updatedUserReview = userReviewService.save(userReview);
                    return ResponseEntity.ok(updatedUserReview);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserReview(@PathVariable Long id) {
        return userReviewService.findById(id)
                .map(userReview -> {
                    userReviewService.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}