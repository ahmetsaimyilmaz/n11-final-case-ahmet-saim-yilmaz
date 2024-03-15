package n11.n11finalcaseahmetsaimyilmaz.userReview;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import n11.n11finalcaseahmetsaimyilmaz.user.User;
import org.springframework.lang.NonNull;

@Entity
@Getter
@Setter
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @NonNull
    private int restaurantId;


    private String reviewText;

    @NonNull
    private int score;

}