package n11.n11finalcaseahmetsaimyilmaz.userReview;

import lombok.Getter;
import lombok.Setter;
import n11.n11finalcaseahmetsaimyilmaz.restaurant.Restaurant;
import n11.n11finalcaseahmetsaimyilmaz.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    private String reviewText;
    private int score;

}