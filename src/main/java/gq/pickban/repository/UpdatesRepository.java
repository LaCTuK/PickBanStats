package gq.pickban.repository;

import gq.pickban.model.Updates;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UpdatesRepository extends CrudRepository<Updates, Long> {
    List findByName(String name);
    Updates findById(long id);
    List<Updates> findAll();

}
