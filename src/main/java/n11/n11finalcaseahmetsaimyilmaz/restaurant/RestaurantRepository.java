package n11.n11finalcaseahmetsaimyilmaz.restaurant;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends SolrCrudRepository<Restaurant, Long> {


}