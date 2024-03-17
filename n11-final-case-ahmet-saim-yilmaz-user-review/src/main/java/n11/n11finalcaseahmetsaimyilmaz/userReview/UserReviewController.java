package n11.n11finalcaseahmetsaimyilmaz.userReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/userReviews")
public class UserReviewController {



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

        UserReview userReview = userReviewService.findById(id).orElseThrow(
                () -> new NotFoundException("UserReview not found for this id :: " + id)
        );
        return ResponseEntity.ok(userReview);
    }

    @PostMapping
    public UserReview createUserReview(@RequestBody UserReview userReview) {
        return userReviewService.save(userReview);
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