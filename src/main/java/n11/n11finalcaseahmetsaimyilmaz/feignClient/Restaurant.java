package n11.n11finalcaseahmetsaimyilmaz.feignClient;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@Data
public class Restaurant {

    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private double score;

    public Restaurant(int id, String name, double latitude, double longitude, double score) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.score = score;
    }

    public Restaurant() {
    }
}