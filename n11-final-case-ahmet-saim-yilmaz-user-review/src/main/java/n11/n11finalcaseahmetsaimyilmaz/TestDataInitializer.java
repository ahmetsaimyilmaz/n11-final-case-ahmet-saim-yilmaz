package n11.n11finalcaseahmetsaimyilmaz;

import jakarta.annotation.PostConstruct;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.user.User;
import n11.n11finalcaseahmetsaimyilmaz.user.UserRepository;
import n11.n11finalcaseahmetsaimyilmaz.user.UserService;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReview;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestDataInitializer {

    @Autowired
    private UserService userService;

    @Autowired
    private UserReviewService userReviewService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;



    public void resetAutoIncrement() {

        jdbcTemplate.execute("ALTER SEQUENCE users_id_seq RESTART WITH 1");
    }
    @PostConstruct
    public void testData() {
        resetAutoIncrement();
        // Check if users already exist
        if (userService.count() == 0) {

            Restaurant restaurant1 = new Restaurant(1, "The Gourmet Kitchen", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant1);
            Restaurant restaurant2 = new Restaurant(2, "Cafe Delights", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant2);
            Restaurant restaurant3 = new Restaurant(3, "Bistro Boulevard", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant3);
            Restaurant restaurant4 = new Restaurant( 4,"Dine Fine", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant4);
            Restaurant restaurant5 = new Restaurant( 5,"Spice Symphony", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant5);
            Restaurant restaurant6 = new Restaurant( 6,"The Curry Leaf", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant6);
            Restaurant restaurant7 = new Restaurant(7, "Ocean's Plate", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant7);
            Restaurant restaurant8 = new Restaurant(8, "Mountain Munch", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant8);
            Restaurant restaurant9 = new Restaurant(9, "Urban Eats", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant9);
            Restaurant restaurant10 = new Restaurant( 10,"Garden Bites", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant10);
            // No users exist, so we can generate test data
            List<User> temp = new ArrayList<>();
            temp.add(new User(1L,"user1","surname1",0,0));
            temp.add(new User(2L,"user2","surname2",0,0));
            temp.add(new User(3L,"user3","surname3",0,0));
            temp.add(new User(4L,"user4","surname4",0,0));
            temp.add(new User(5L,"user5","surname5",3,3));
            temp.add(new User(6L,"user6","surname6",3,3));
            temp.add(new User(7L,"user7","surname7",3,3));
            temp.add(new User(8L,"user8","surname8",3,3));
            temp.add(new User(9L,"user9","surname9",3,3));

            userService.saveUsers(temp);

            for (int i = 1; i < 10; i++) {
                User user = temp.get(i % temp.size()); // Cycle through users
                UserReview review = new UserReview(
                        user,
                        i,
                        "Review text for restaurant " + i,
                        (i % 5) + 1 // Score cycles from 1 to 5
                );
                userReviewService.save(review);
            }
        } else {
            // Users already exist, do not generate test data
            System.out.println("Test data not generated since data already exists.");
        }
    }
}