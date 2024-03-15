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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return user.getName();
    }


    public void setUser(User user) {
        this.user = user;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}