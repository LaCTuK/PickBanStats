package gq.pickban.repository;

import gq.pickban.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TeamRepository extends CrudRepository<Team, Long> {
    //List<Team> findByName(String name);
    Team findById(long id);
    List findByName(String name);
}
