package n11.n11finalcaseahmetsaimyilmaz.restaurant;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends SolrCrudRepository<Restaurant, Long> {
}