package n11.n11finalcaseahmetsaimyilmaz.userReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {

    @Query("SELECT COUNT(u) FROM UserReview u WHERE u.restaurantId = :restaurantId")
    long countByRestaurantId(Long restaurantId);
}