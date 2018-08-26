package gq.pickban.repository;

import gq.pickban.model.Updates;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UpdatesRepository extends CrudRepository<Updates, Long> {
    List findByName(String name);
    Updates findById(long id);
    List<Updates> findAll();

}
