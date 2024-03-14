package n11.n11finalcaseahmetsaimyilmaz.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "core-instance")
@Getter
@Setter
@AllArgsConstructor
public class Restaurant {

    @Id
    @Indexed(name = "id", type = "string")
    private String id; // Changed to String assuming Solr generally uses string IDs

    @Indexed(name = "name", type = "string")
    private String name;

    @Indexed(name = "latitude", type = "pdouble")
    private double latitude;

    @Indexed(name = "longitude", type = "pdouble")
    private double longitude;

    @Indexed(name = "score", type = "pdouble")
    private double score;

}