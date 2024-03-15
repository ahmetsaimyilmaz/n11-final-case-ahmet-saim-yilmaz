package n11.n11finalcaseahmetsaimyilmaz;

import n11.n11finalcaseahmetsaimyilmaz.feignClient.RestaurantServiceClient;
import n11.n11finalcaseahmetsaimyilmaz.user.User;
import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReview;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserReviewControllerIntegrationTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantServiceClient restaurantServiceClient;

    @Test
    public void testCreateUserReview() throws Exception {
        User user = new User();
        user.setId(1L);
        UserReview userReview = new UserReview();
        userReview.setScore(5);
        userReview.setUser(user);
        userReview.setRestaurantId(1);
        String userReviewJson = "{\"user\": { \"id\": 1 },\"restaurantId\":1,\"score\":5,\"reviewText\":\"Great!\"}";

        mockMvc.perform(post("/api/userReviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userReviewJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.score").value(5));
    }

}
