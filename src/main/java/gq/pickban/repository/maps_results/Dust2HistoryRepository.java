package gq.pickban.repository.maps_results;

import gq.pickban.model.maps_results.Dust2History;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Dust2HistoryRepository extends CrudRepository<Dust2History, Long> {
    List<Dust2History> findByTeamId(long id);
    List<Dust2History> findAll();
}
