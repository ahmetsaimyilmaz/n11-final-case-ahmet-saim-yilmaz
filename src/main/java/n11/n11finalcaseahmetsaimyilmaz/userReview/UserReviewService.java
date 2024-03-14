package n11.n11finalcaseahmetsaimyilmaz.userReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<UserReview> findById(Long id) {
        return userReviewRepository.findById(id);
    }

    public UserReview save(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    public void deleteById(Long id) {
        userReviewRepository.deleteById(id);
    }

}