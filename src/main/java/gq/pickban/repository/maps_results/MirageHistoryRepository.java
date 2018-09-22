package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.MirageHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MirageHistoryRepository extends CrudRepository<MirageHistory, Long> {
    List<MirageHistory> findByTeamId(long id);
    List<MirageHistory> findAll();
}
