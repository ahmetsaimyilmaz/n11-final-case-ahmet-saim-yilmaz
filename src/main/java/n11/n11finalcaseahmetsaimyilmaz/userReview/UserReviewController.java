package n11.n11finalcaseahmetsaimyilmaz.userReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userReviews")
public class UserReviewController {

    private final UserReviewService userReviewService;

    @Autowired
    public UserReviewController(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    @PostMapping
    public ResponseEntity<UserReview> addUserReview(@RequestBody UserReview userReview) {
        UserReview savedUserReview = userReviewService.saveUserReview(userReview);
        return new ResponseEntity<>(savedUserReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserReview>> getAllUserReviews() {
        List<UserReview> userReviews = userReviewService.getAllUserReviews();
        return new ResponseEntity<>(userReviews, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserReview(@PathVariable Long id) {
        userReviewService.deleteUserReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}