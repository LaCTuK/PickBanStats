package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.CacheHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CacheHistoryRepository extends CrudRepository<CacheHistory, Long> {
    List<CacheHistory> findByTeamId(long id);
    List<CacheHistory> findAll();
}
