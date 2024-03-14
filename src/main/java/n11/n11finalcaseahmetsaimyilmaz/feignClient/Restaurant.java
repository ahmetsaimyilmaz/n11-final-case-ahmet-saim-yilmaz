package n11.n11finalcaseahmetsaimyilmaz.feignClient;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Data
public class Restaurant {

    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double score;

}