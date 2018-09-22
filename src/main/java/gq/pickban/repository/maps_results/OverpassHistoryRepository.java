package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.OverpassHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OverpassHistoryRepository extends CrudRepository<OverpassHistory, Long> {
    List<OverpassHistory> findByTeamId(long id);
    List<OverpassHistory> findAll();
}
