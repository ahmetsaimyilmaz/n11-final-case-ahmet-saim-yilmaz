package n11.n11finalcaseahmetsaimyilmaz.user;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    private String surname;
    private double latitude;
    private double longitude;

    public User(@NonNull String name, String surname, double latitude, double longitude) {
        this.name = name;
        this.surname = surname;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User(Long id, @NonNull String name, String surname, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User() {

    }
}