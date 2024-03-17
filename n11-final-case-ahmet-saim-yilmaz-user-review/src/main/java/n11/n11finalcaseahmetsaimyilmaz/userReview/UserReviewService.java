package n11.n11finalcaseahmetsaimyilmaz.userReview;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;
    private final UserReviewRepository userReviewRepository;
    @Value("${is-test-environment}")
    private boolean isTestEnvironment;

    @Autowired
    public UserReviewService(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
    }

    public List<UserReview> getAllUserReviews() {
        return userReviewRepository.findAll();
    }

    public Optional<UserReview> findById(Long id) {
        return userReviewRepository.findById(id);
    }

    public UserReview save(UserReview userReview) {
        UserReview savedUserReview = userReviewRepository.save(userReview);

        if (!isTestEnvironment) {
            Optional<Restaurant> temp = restaurantServiceClient.getRestaurantById((long) userReview.getRestaurantId());

            if (savedUserReview.getId() != null && temp.isPresent()) {
                long totalScore = userReviewRepository.countByRestaurantId((long) userReview.getRestaurantId());
                double total = (totalScore - 1) * temp.get().getScore() + userReview.getScore();
                double newScore = total / totalScore;
                temp.get().setScore(newScore);
                restaurantServiceClient.createRestaurant(temp.get());
                return savedUserReview;
            } else {
                throw new RuntimeException("Failed to save UserReview");
            }
        }
        return savedUserReview;
    }

    public void deleteById(Long id) {
        Optional<UserReview> optionalUserReview = this.findById(id);
        UserReview userReview = optionalUserReview.get();
        Optional<Restaurant> temp = restaurantServiceClient.getRestaurantById((long) userReview.getRestaurantId());
        long totalScore = userReviewRepository.countByRestaurantId((long) userReview.getRestaurantId());
        double total = totalScore * temp.get().getScore() - userReview.getScore();
        double newScore = total / (totalScore - 1);
        temp.get().setScore(newScore);
        restaurantServiceClient.createRestaurant(temp.get());

        userReviewRepository.deleteById(id);
    }


}