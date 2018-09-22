package gq.pickban.repository;

import gq.pickban.model.Picks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PicksRepository extends CrudRepository<Picks, Long> {
    List<Picks> findAll();
    Picks findById(long id);
}
