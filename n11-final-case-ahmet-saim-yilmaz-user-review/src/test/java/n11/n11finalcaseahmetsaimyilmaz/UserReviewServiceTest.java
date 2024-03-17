package n11.n11finalcaseahmetsaimyilmaz;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReview;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewRepository;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserReviewServiceTest {

    @MockBean
    private UserReviewRepository userReviewRepository;

    @MockBean
    private RestaurantServiceClient restaurantServiceClient;

    @Autowired
    private UserReviewService userReviewService;

    @Test
    public void testSaveUserReview() {
        UserReview userReview = new UserReview();
        userReview.setScore(5);
        userReview.setRestaurantId(1);
        Restaurant restaurant = new Restaurant();
        restaurant.setScore(4.5);

        Mockito.when(userReviewRepository.save(any(UserReview.class))).thenReturn(userReview);
        Mockito.when(restaurantServiceClient.getRestaurantById(anyLong())).thenReturn(Optional.of(restaurant));
        Mockito.when(restaurantServiceClient.createRestaurant(any(Restaurant.class))).thenReturn(restaurant);

        UserReview savedUserReview = userReviewService.save(userReview);

        assertThat(savedUserReview).isNotNull();
        verify(userReviewRepository).save(userReview);
    }

}