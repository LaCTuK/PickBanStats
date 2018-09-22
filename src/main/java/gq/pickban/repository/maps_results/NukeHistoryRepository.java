package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.NukeHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NukeHistoryRepository extends CrudRepository<NukeHistory, Long> {
    List<NukeHistory> findByTeamId(long id);
    List<NukeHistory> findAll();
}
