package n11.n11finalcaseahmetsaimyilmaz.userReview;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import n11.n11finalcaseahmetsaimyilmaz.user.User;

@Entity
@Getter
@Setter
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    @Column(name = "restaurant_id")
    private int restaurant;

    private String reviewText;
    private int score;

}