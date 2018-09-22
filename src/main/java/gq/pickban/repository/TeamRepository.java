package gq.pickban.repository;

import gq.pickban.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findById(long id);
    List findByName(String name);
}
