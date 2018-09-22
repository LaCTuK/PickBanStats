package gq.pickban.repository;

import gq.pickban.model.Bans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BansRepository extends CrudRepository<Bans, Long> {
    //List<Bans> findAll(List<Long> ids);
    List<Bans> findAll();
    Bans findById(long id);
}
