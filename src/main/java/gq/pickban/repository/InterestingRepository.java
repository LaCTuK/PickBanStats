package gq.pickban.repository;

import gq.pickban.model.Interesting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface InterestingRepository extends CrudRepository<Interesting, Long> {
    List findByName(String name);
    Interesting findById(long id);
    List<Interesting> findAll();
}
