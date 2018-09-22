package gq.pickban.repository;

import gq.pickban.model.Interesting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface InterestingRepository extends CrudRepository<Interesting, Long> {
    List findByName(String name);
    Interesting findById(long id);
    List<Interesting> findAll();
}
