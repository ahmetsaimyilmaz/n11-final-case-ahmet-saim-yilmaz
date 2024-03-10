package n11.n11finalcaseahmetsaimyilmaz.userReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {
    private final UserReviewRepository userReviewRepository;

    @Autowired
    public UserReviewService(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
    }

    public UserReview saveUserReview(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    public List<UserReview> getAllUserReviews() {
        return userReviewRepository.findAll();
    }

    public void deleteUserReview(Long id) {
        userReviewRepository.deleteById(id);
    }

}