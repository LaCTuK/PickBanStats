package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.InfernoHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InfernoHistoryRepository extends CrudRepository<InfernoHistory, Long> {
    List<InfernoHistory> findByTeamId(long id);
    List<InfernoHistory> findAll();
}
