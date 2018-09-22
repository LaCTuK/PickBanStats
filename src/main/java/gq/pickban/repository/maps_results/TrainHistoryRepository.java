package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.TrainHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainHistoryRepository extends CrudRepository<TrainHistory, Long> {
    List<TrainHistory> findByTeamId(long id);
    List<TrainHistory> findAll();
}
